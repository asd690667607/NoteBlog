package service;

import mapper.FeedbackDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Feedback;


@Service
public class FeedbackServiceImpl implements FeedbackService{
	@Autowired
	private FeedbackDao feedbackdao;
	public int insertfeedback(Feedback feedback) {
		System.out.println(feedback+"用户反馈数据");
		return feedbackdao.insertfeedback(feedback);
	}

}
