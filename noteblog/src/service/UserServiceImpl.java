package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import util.Constant;

import bean.User;
import mapper.UserDao;

import util.EmaiCheckCode;
import util.MD5Util;
import util.SendEmailUtil;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	
	
	public User findUserByEmail(String user_email) {
		return userDao.findUserByEmail(user_email);
	}

	public int insertUser(User user) {
		//用户密码 MD5加密处理
		try {
			String password=MD5Util.encode(user.getUser_password());
			user.setUser_password(password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//设置用户等级
		user.setUserIntegral(Constant.INTEGRAL_NORMAL);
		//发送邮箱验证码
		String emailVerifyCode=EmaiCheckCode.getEmaiCheckCode();
		SendEmailUtil.send(user.getUser_email(),emailVerifyCode);
		//设置邮箱验证码
		
		user.setEmailVerifyCode(emailVerifyCode);
	
		return userDao.insertUser(user);
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return userDao.updateUser(user);
	}

	public List<User> findAllUser() {
		// TODO Auto-generated method stub
		return userDao.findAllUser();
	}

	public int deleteUser(int user_id) {
		// TODO Auto-generated method stub
		return userDao.deleteUser(user_id);
	}

	public int insertDeleteUser(User user) {
		// TODO Auto-generated method stub
		return userDao.insertDeleteUser(user);
	}

	public List<User> findAllDeleteUser() {
		// TODO Auto-generated method stub
		return userDao.findAllDeleteUser();
	}

	public User findUserById(int user_id) {
		// TODO Auto-generated method stub
		return userDao.findUserById(user_id);
	}

	public int huifuUser(int user_id) {
		// TODO Auto-generated method stub
		return userDao.huifuUser(user_id);
	}

	public User findDeleteUserById(int user_id) {
		// TODO Auto-generated method stub
		return userDao.findDeleteUserById(user_id);
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		return userDao.addUser(user);
	}

	public User findDeleteUserByEmail(String user_email) {
		// TODO Auto-generated method stub
		return userDao.findDeleteUserByEmail(user_email);
	}

	
	public int updateaUser(User user) {
		return userDao.updateaUser(user);
	}
}
