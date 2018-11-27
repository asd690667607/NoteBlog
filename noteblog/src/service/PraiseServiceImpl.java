package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Praise;
import mapper.PraiseDao;

@Service
public class PraiseServiceImpl implements PraiseService{

	@Autowired
	private PraiseDao praiseDao;
	
	public Praise findPraiseByEmail(String user_email) {
		
		
		return praiseDao.findPraiseByEmail(user_email);
	}

	public int insertPraise(Praise praise) {
		
		return praiseDao.insertPraise(praise);
	}

}
