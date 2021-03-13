package hu.szabo.pixelhunting.user;

import java.util.List;

public interface UserService {

	List<UserDisplayVO> findAllUsers();
	
	List<UserResponse> findAllUser();

	void saveUser(UserSaveVO userSaveVO);

	UserSaveVO findUserSaveVOByUserId(Long userId);

	void deleteUserById(Long userId);

	Boolean findByUsername(String username);

	Boolean checkOldPassword(String oldPassword, Long currentUserId);

	void saveNewPassword(String firstNewPassword, Long id);

	UserResponse saveUser(SaveUserRequest request);

	boolean isUsernameExist(String username);

	boolean isEmailExist(String email);
}
