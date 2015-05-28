package com.zml.ssh.service.login;

import org.springframework.stereotype.Service;

import com.zml.ssh.domain.User;
import com.zml.ssh.service.base.impl.IBaseService;
import com.zml.ssh.util.StringEncrypt;
@Service
public class LoginService extends IBaseService{
	public User login(User user){
		String uname = user.getUserName();
		String upass=user.getUserPass();
		return this.findBy(uname, StringEncrypt.Encrypt(upass, "MD5")).get(0);
	}
}
