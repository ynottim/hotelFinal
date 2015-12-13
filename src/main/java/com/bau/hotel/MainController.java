package com.bau.hotel;

import com.bau.hotel.dao.EntryDao;
import com.bau.hotel.model.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private EntryDao entryDao;

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView("index");
        List<Entry> entries = entryDao.getEntries();
        mav.addObject("entries", entries);

        return mav;
    }

    public void setEntryDao(EntryDao entryDao) {
        this.entryDao = entryDao;
    }
}
