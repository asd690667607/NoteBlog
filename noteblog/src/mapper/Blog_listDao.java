package mapper;

import java.util.List;
import bean.Blog_list;

//²©¿ÍÏÔÊ¾ºÍÉ¾³ı
public interface Blog_listDao {
	List<Blog_list> findAllblogs();
	void deleteBlogById(int blog_id);
	
}
