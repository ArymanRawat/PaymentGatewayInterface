package com.example.TaskPaytm.dao;

import com.example.TaskPaytm.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserDao extends JpaRepository<User, Long> {

    public List<User> findByEmail(String email);

    public List<User> findByMobile(long mobile);

    public List<User> findByGender(String gender);

    public List<User> findByHasWallet(boolean hasWallet);


}
