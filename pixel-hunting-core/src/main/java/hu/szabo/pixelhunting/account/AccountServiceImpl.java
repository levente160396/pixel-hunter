package hu.szabo.pixelhunting.account;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.szabo.pixelhunting.user.Role;
import hu.szabo.pixelhunting.user.User;
import hu.szabo.pixelhunting.user.UserDisplayVO;
import hu.szabo.pixelhunting.user.UserMapper;
import hu.szabo.pixelhunting.user.UserRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	UserRepository userRepository;

	@Override
	public Role getRoleByUserName(String username) {

		return userRepository.getRoleByUsername(username);
	}

	@Override
	public UserDisplayVO getUserDisplayVOByUserName(String username) {
		User userByUsername = userRepository.getUserByUsername(username);

		return UserMapper.INSTANCE.userToUserDisplayVO(userByUsername);
	}
}
