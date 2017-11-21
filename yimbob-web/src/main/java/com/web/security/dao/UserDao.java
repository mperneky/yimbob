package com.web.security.dao;

import com.web.security.model.User;

public interface UserDao {

    User findById(int id);

    User findBySSO(String sso);

}
