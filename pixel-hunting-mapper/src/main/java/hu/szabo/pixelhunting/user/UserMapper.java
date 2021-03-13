package hu.szabo.pixelhunting.user;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	UserDisplayVO userToUserDisplayVO(User user);

	List<UserDisplayVO> usersToUserDisplayVos(List<User> users);

	User userSaveVOToUser(UserSaveVO userSaveVO);

	UserSaveVO userToUserSaveVO(User user);
	
	User saveUserRequestToUser(SaveUserRequest request);
	
	UserResponse userToSaveUserResponse(User user);
	
	List<UserResponse> usersToUserResponse(List<User> users);
}
