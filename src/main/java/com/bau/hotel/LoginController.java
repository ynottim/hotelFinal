package com.bau.hotel;

import com.bau.hotel.model.User;
import com.bau.hotel.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String index(){
        return "login";
    }

    @RequestMapping(path = "/login", method= RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  HttpSession session){
        ModelAndView mav = null;

        if( isForDataValid(username, password) ){
            User user = userService.getUserWithUsername(username);
            if( user != null && user.getPassword().equals( EncryptionUtils.encrypt(password) ) ){
                mav = new ModelAndView(new RedirectView("/", true));
                session.setAttribute("user", user);
            }
        }

        if( mav == null ) {
            mav = new ModelAndView(new RedirectView("/login", true));
            mav.addObject("error", true);
        }

        return mav;
    }

    @RequestMapping("/exit")
    public ModelAndView logoutUser(HttpSession session){
        session.removeAttribute("user");

        return new ModelAndView(new RedirectView("/", true));
    }

    private boolean isForDataValid(String username, String password) {
        return StringUtils.isNoneBlank(username, password);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
