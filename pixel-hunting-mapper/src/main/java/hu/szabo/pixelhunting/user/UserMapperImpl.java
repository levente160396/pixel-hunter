package hu.szabo.pixelhunting.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserMapperImpl implements UserMapper {

	@Override
	public UserDisplayVO userToUserDisplayVO(User user) {

		UserDisplayVO userDisplayVO = new UserDisplayVO();

		userDisplayVO.setId(user.getId());
		userDisplayVO.setUsername(user.getUsername());
		userDisplayVO.setFirstName(user.getFirstName());
		userDisplayVO.setLastName(user.getLastName());
		userDisplayVO.setEmail(user.getEmail());
		userDisplayVO.setIsActive(user.getIsActive());
		userDisplayVO.setRole(user.getRole());
		userDisplayVO.setLastLogin(user.getLastLogin());

		return userDisplayVO;
	}

	@Override
	public List<UserDisplayVO> usersToUserDisplayVos(List<User> users) {
		List<UserDisplayVO> results = new ArrayList<>(users.size());

		for (User user : users) {
			UserDisplayVO userDisplayVO = new UserDisplayVO();
			userDisplayVO.setId(user.getId());
			userDisplayVO.setUsername(user.getUsername());
			userDisplayVO.setFirstName(user.getFirstName());
			userDisplayVO.setLastName(user.getLastName());
			userDisplayVO.setEmail(user.getEmail());
			userDisplayVO.setIsActive(user.getIsActive());
			userDisplayVO.setRole(user.getRole());
			userDisplayVO.setLastLogin(user.getLastLogin());

			results.add(userDisplayVO);
		}

		return results;
	}

	@Override
	public User userSaveVOToUser(UserSaveVO userSaveVO) {
		User user = new User();

		user.setId(userSaveVO.getModifyId());
		user.setUsername(userSaveVO.getUsername());
		user.setFirstName(userSaveVO.getFirstName());
		user.setLastName(userSaveVO.getLastName());
		user.setEmail(userSaveVO.getEmail());
		
		if (null == userSaveVO.getModifyId()) {
			user.setPassword(new BCryptPasswordEncoder().encode(userSaveVO.getPassword()));
		}
		
		user.setIsActive(userSaveVO.getIsActive());
		user.setRole(userSaveVO.getRole());
		user.setLastLogin(userSaveVO.getLastLogin());

		return user;
	}

	@Override
	public UserSaveVO userToUserSaveVO(User user) {
		UserSaveVO userSaveVO = new UserSaveVO();

		userSaveVO.setModifyId(user.getId());
		userSaveVO.setUsername(user.getUsername());
		userSaveVO.setFirstName(user.getFirstName());
		userSaveVO.setLastName(user.getLastName());
		userSaveVO.setEmail(user.getEmail());
		userSaveVO.setIsActive(user.getIsActive());
		userSaveVO.setRole(user.getRole());
		userSaveVO.setLastLogin(user.getLastLogin());
		
		return userSaveVO;
	}

	@Override
	public User saveUserRequestToUser(SaveUserRequest request) {
		User user = new User();
		
		user.setId(request.getModifyId());
		user.setUsername(request.getUsername());
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
		user.setIsActive(request.getIsActive());
		user.setRole(request.getRole());
		user.setLastLogin(null);
		
		return user;
	}

	@Override
	public UserResponse userToSaveUserResponse(User user) {
		
		UserResponse response = new UserResponse();
		
		response.setId(user.getId());
		response.setUsername(user.getUsername());
		response.setFirstName(user.getFirstName());
		response.setLastName(user.getLastName());
		response.setEmail(user.getEmail());
		response.setIsActive(user.getIsActive());
		response.setRole(user.getRole());
		response.setLastLogin(user.getLastLogin());
		
		return response;
	}

	@Override
	public List<UserResponse> usersToUserResponse(List<User> users) {
		List<UserResponse> results = new ArrayList<>(users.size());

		for (User user : users) {
			UserResponse userResponse = new UserResponse();
			userResponse.setId(user.getId());
			userResponse.setUsername(user.getUsername());
			userResponse.setFirstName(user.getFirstName());
			userResponse.setLastName(user.getLastName());
			userResponse.setEmail(user.getEmail());
			userResponse.setIsActive(user.getIsActive());
			userResponse.setRole(user.getRole());
			userResponse.setLastLogin(user.getLastLogin());

			results.add(userResponse);
		}

		return results;
	}
}
