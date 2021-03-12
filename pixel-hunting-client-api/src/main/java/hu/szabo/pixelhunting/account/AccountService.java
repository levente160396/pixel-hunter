package hu.szabo.pixelhunting.account;

import hu.szabo.pixelhunting.user.Role;
import hu.szabo.pixelhunting.user.UserDisplayVO;

public interface AccountService {

	Role getRoleByUserName(String name);

	UserDisplayVO getUserDisplayVOByUserName(String username);
}
