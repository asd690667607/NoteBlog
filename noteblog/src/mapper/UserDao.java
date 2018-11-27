package mapper;

import java.util.List;

import bean.User;

public interface UserDao {
	 User findUserByEmail(String user_email);
	 int insertUser(User user);
	 int updateUser(User user);
	 List<User> findAllUser();
	 int deleteUser(int user_id);
	 int insertDeleteUser(User user);
	 List<User> findAllDeleteUser();
	 User findUserById(int user_id);
	 int huifuUser(int user_id);
	 User findDeleteUserById(int user_id);
	 int addUser(User user);
	 User findDeleteUserByEmail(String user_email);
	 int updateaUser(User user);
}
