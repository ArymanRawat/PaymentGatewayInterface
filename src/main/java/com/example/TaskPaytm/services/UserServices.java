package com.example.TaskPaytm.services;

import com.example.TaskPaytm.dao.UserDao;
import com.example.TaskPaytm.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {


    @Autowired
    private UserDao userDao;

    // Using all pre-created methods of UserRepository
    public List<User> listAll() {

        return userDao.findAll();
    }

    public void save(User user) {

        userDao.save(user);
    }

    public User get(Long id) {
        return userDao.findById(id).get();
    }

    public void delete(Long id) {

        userDao.deleteById(id);
    }

    public void deleteAll() {

        userDao.deleteAll();
    }

    public List<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }

    public List<User> findByMobile(long mobile) {
        return userDao.findByMobile(mobile);
    }

//    public List<User> findByGender(String gender) {
//        return userDao.findByGender(gender);
//    }

////    public List<User> findByHasWallet(boolean hasWallet) {
//
//        return userDao.findByHasWallet(hasWallet);
//    }



}
