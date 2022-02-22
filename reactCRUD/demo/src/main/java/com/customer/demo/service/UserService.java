package com.customer.demo.service;

import com.customer.demo.model.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    List<User> listUser();

    List<User> deleteUser(long id);


}
