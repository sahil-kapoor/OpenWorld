package com.openworld.service.currentuser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.openworld.domain.CurrentUser;
import com.openworld.domain.Role;

@Service
public class CurrentUserServiceImpl implements CurrentUserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CurrentUserDetailsService.class);

	@Override
	public boolean canAccessUser(CurrentUser currentUser, Long userId) {
		LOGGER.debug("Checking if user={} has access to user={}", currentUser, userId);
		return currentUser != null && (currentUser.getRole() == Role.ADMIN || currentUser.getId().equals(userId));
	}

}
