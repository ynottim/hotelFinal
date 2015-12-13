package com.bau.hotel.service;

import com.bau.hotel.EncryptionUtils;
import com.bau.hotel.dao.UserDao;
import com.bau.hotel.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean saveUser(User user){
        if( checkIfUsernameIsAvailable(user) ){
            user.setPassword( getEncryptedPassword(user) );
            userDao.addUser(user);
            return true;
        }

        return false;
    }

    private String getEncryptedPassword(User user) {
        return EncryptionUtils.encrypt(user.getPassword());
    }

    private boolean checkIfUsernameIsAvailable(User user){
        User existingUser = getUserWithUsername(user.getUsername());

        return existingUser == null;
    }

    public User getUserWithUsername(String username){
        return userDao.getUser(username);
    }


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
