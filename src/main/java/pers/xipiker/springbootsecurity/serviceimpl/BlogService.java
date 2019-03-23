package pers.xipiker.springbootsecurity.serviceimpl;

import org.springframework.stereotype.Service;
import pers.xipiker.springbootsecurity.entity.Blog;
import pers.xipiker.springbootsecurity.service.IBlogService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    private List<Blog> list = new ArrayList<>();

    public BlogService() {
        list.add(new Blog(1L, "Spring in action", "good!"));
        list.add(new Blog(2L, "Spring boot in action", "nice!"));
    }

    @Override
    public List<Blog> getBlogs() {
        return list;
    }

    @Override
    public void deleteBlog(Long id) {
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            Blog blog = (Blog) iterator.next();
            if(blog.getId() == id){
                iterator.remove();
            }
        }
    }


}
