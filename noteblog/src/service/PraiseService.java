package service;

import bean.Praise;

public interface PraiseService {

	//查询数据库，判断改用户是否已赞
	Praise findPraiseByEmail(String user_email);
	
	//点赞，插入操作
	int insertPraise(Praise praise);
		
}
