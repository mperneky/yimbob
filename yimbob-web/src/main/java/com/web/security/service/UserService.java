package com.web.security.service;

import com.web.security.model.User;

public interface UserService {

    User findById(int id);

    User findBySso(String sso);

}
