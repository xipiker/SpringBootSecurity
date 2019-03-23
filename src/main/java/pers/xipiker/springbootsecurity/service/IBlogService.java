package pers.xipiker.springbootsecurity.service;

import pers.xipiker.springbootsecurity.entity.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();
    void deleteBlog(Long id);
}
