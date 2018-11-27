package service;

import java.util.List;

import bean.Blog_list;
//个人中心模块显示个人博客及删除
public interface Blog_listService {
	List<Blog_list> findAllblogs();
	void deleteBlogById(int blog_id);
}
