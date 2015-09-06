package com.openworld.service.user;

import java.util.Collection;
import java.util.Optional;

import com.openworld.domain.User;
import com.openworld.domain.UserCreateForm;

public interface UserService {

    Optional<User> getUserById(long id);

    Optional<User> getUserByEmail(String email);
    
    Optional<User> getUserByLogin(String login);

    Collection<User> getAllUsers();

    User create(UserCreateForm form);

}
