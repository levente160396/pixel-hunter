package hu.szabo.pixelhunting.user;

import java.util.List;

public interface UserService {

	List<UserDisplayVO> findAllUsers();

	void saveUser(UserSaveVO userSaveVO);

	UserSaveVO findUserSaveVOByUserId(Long userId);

	void deleteUserById(Long userId);

	Boolean findByUsername(String username);

	Boolean checkOldPassword(String oldPassword, Long currentUserId);

	void saveNewPassword(String firstNewPassword, Long id);
}
