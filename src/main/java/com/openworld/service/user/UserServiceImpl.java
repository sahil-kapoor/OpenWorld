package com.openworld.service.user;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.openworld.domain.User;
import com.openworld.domain.UserCreateForm;
import com.openworld.domain.UserDetails;
import com.openworld.repository.UserDetailsRepository;
import com.openworld.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(userRepository.findOne(id));
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findOneByEmail(email);
    }

    @Override
    public Collection<User> getAllUsers() {
        return userRepository.findAll(new Sort("email"));
    }

    @Override
    public User create(UserCreateForm form) {
        User user = new User();
        user.setEmail(form.getEmail());
        user.setLogin(form.getLogin());
        user.setPasswordHash(new BCryptPasswordEncoder().encode(form.getPassword()));
        user.setCreateDate(form.getCreateDate());
        user.setRole(form.getRole());
        
        UserDetails userDetails = new UserDetails();
        userDetails.setFirstName(form.getFirstName());
        userDetails.setLastName(form.getLastName());
        userDetails.setUser(user);
        
        user.setUserDetails(userDetails);
        userDetailsRepository.save(userDetails);
        
        return userRepository.save(user);
    }

	@Override
	public Optional<User> getUserByLogin(String login) {
		return userRepository.findOneByLogin(login);
	}

}
