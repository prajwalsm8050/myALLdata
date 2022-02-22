package com.customer.demo.serviceImpl;

import com.customer.demo.customerRepo.UserRepo;
import com.customer.demo.model.User;
import com.customer.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    @Autowired
    UserRepo userrepo;

    @Override
    public User saveUser(User user) {
        return userrepo.save(user);
    }

    @Override
    public List<User> listUser() {
        return userrepo.findAll();
    }

    @Override
    public List<User> deleteUser(long id) {
        userrepo.deleteById(id);
        return  userrepo.findAll();
    }
}
