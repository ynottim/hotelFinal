package com.bau.hotel;

import com.bau.hotel.dao.EntryDao;
import com.bau.hotel.model.Entry;
import com.bau.hotel.model.User;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.mutable.MutableLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;

@Controller
public class EntryController {

    public static final String CSRF_TOKEN_SESSION_KEY = "addHotelPostCsrfToken";

    @Autowired
    private EntryDao entryDao;

    @RequestMapping("/rest/entries")
    @ResponseBody
    public List<Entry> getAllEntries(){
        return entryDao.getEntries();
    }



    @RequestMapping("/readHotelReview")
    public ModelAndView readPost(@RequestParam(name = "id", required = false) Integer entryId){
        boolean redirectToMainPage = false;

        if( entryId == null ){
            redirectToMainPage = true;
        }

        ModelAndView mav = new ModelAndView("readHotelReview");

        Entry entry = entryDao.getEntry(entryId);
        if( entry == null ){
            redirectToMainPage = true;
        } else {
            mav.addObject("entry", entry);
            mav.addObject("tags", entryDao.getTags(entry));
        }

        if( redirectToMainPage ){
            mav = new ModelAndView(new RedirectView("/", true));
        }

        return mav;
    }

    @RequestMapping("/secure/addHotelReview")
    public ModelAndView showEntryForm(HttpSession session){
        String csrfToken = RandomStringUtils.randomAlphanumeric(20);
        session.setAttribute(CSRF_TOKEN_SESSION_KEY, csrfToken);

        ModelAndView mav = new ModelAndView("addHotelReview");
        mav.addObject("csrfToken", csrfToken);

        return mav;
    }

    @RequestMapping(path = "/secure/addHotelReview", method = RequestMethod.POST)
    public ModelAndView addEntry(@RequestParam("title") String title,
                                 @RequestParam("entry") String entry,
                                 @RequestParam("image") MultipartFile imageFile[],
                                 @RequestParam("tags") String tags,
                                 @RequestParam("csrfToken") String csrfToken,
                                 HttpSession session){

        User user = (User) session.getAttribute("user");
        ModelAndView mav;

        if(checkCsrfToken(session, csrfToken) && isValidData(title, entry)){
            String[] tagArray = StringUtils.split(tags, ",");
            for( int i=0; i<tagArray.length; i++ ){
                tagArray[i] = tagArray[i].trim();
            }

            Entry entryData = new Entry();
            entryData.setTitle(title);
            entryData.setEntry(entry);
            entryData.setImagePath(saveUploadedFile(imageFile, session.getServletContext()));
            entryDao.addEntry(entryData, user);
            mav = new ModelAndView(new RedirectView("/", true));
        } else {
            mav = new ModelAndView(new RedirectView("/secure/addHotelReview", true));
            mav.addObject("error", true);
        }

        return mav;
    }

    private boolean checkCsrfToken(HttpSession session, String csrfToken){
        String csrfTokenValue = (String) session.getAttribute(CSRF_TOKEN_SESSION_KEY);
        session.removeAttribute(CSRF_TOKEN_SESSION_KEY);
        return csrfTokenValue != null && csrfTokenValue.equals(csrfToken);
    }

    private String saveUploadedFile(MultipartFile imageFile[], ServletContext servletContext) {
        String filePath = null;

//        String fileName = uploadedFile.getFileName();
//        String mimeType = getServletContext().getMimeType(fileName);
//        if (mimeType.startsWith("image/")) {
//            // It's an image.
//        }

        for(MultipartFile file : imageFile) {
            if(!file.isEmpty());
            {
                for(int i = 0; i < imageFile.length; i++) {

                    MultipartFile image = imageFile[i];

                    String displayFolder = "/resources/upload";
                    File uploadFolder = getUploadFolder(servletContext, displayFolder);

                    writeUploadedFileToDisk(imageFile[i],uploadFolder);
                    filePath = displayFolder + "/" + image.getOriginalFilename();
                }
            }
        }

        return filePath;
    }

    private void writeUploadedFileToDisk(MultipartFile imageFile, File uploadFolder) {
        File serverFile = new File(uploadFolder, imageFile.getOriginalFilename());

        try(BufferedOutputStream stream =  new BufferedOutputStream(new FileOutputStream(serverFile));){
            stream.write(imageFile.getBytes());
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private File getUploadFolder(ServletContext servletContext, String displayFolder) {
        File folder = new File(servletContext.getRealPath(displayFolder));
        if( !folder.exists() ){
            folder.mkdir();
        }
        return folder;
    }

    private boolean isValidData(String title, String entry) {
        return StringUtils.isNoneBlank(title, entry);
    }

    public void setEntryDao(EntryDao entryDao) {
        this.entryDao = entryDao;
    }
}
