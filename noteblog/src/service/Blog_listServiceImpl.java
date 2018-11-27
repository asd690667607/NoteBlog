package service;

import java.util.List;

import mapper.Blog_listDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bean.Blog_list;
@Service
public class Blog_listServiceImpl implements Blog_listService{
@Autowired
	private Blog_listDao blog_listdao;
	public void deleteBlogById(int blog_id) {
		blog_listdao.deleteBlogById(blog_id);
		
	}

	public List<Blog_list> findAllblogs() {
		
		return blog_listdao.findAllblogs();
	}

}
