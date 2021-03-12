package hu.szabo.pixelhunting.user;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import hu.szabo.pixelhunting.utils.CommonMessageUtils;
import hu.szabo.pixelhunting.utils.JSFUtil;
import lombok.Data;


@Data
@Named
@Scope("view")
public class RegistrationBean implements Serializable {

	private static final long serialVersionUID = 3766188389689658627L;
	
	@Inject
	private UserService userService;

	private UserSaveVO userSaveVO;
	
	private String passwordChecker;
	
	@PostConstruct
	public void init() {
		userSaveVO = new UserSaveVO();
	}
	
	public void register() {
		if (null == userSaveVO.getModifyId() && !userSaveVO.getPassword().equals(passwordChecker)) {

			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("userbean.password.checker"));

			return;
		}

		if (null == userSaveVO.getModifyId()
				&& Boolean.TRUE.equals(userService.findByUsername(userSaveVO.getUsername()))) {
			CommonMessageUtils.addFacesMessage(FacesMessage.SEVERITY_ERROR,
					CommonMessageUtils.RB.getString("userbean.same.username"));

			return ;
		}
		
		userSaveVO.setRole(Role.USER);
		userSaveVO.setIsActive(Boolean.TRUE);
		
		userService.saveUser(userSaveVO);
		
		JSFUtil.redirectRelative("/login.xhtml");
	}
}
