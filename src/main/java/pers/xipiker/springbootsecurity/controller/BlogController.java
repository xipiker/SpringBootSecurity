package pers.xipiker.springbootsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pers.xipiker.springbootsecurity.entity.Blog;
import pers.xipiker.springbootsecurity.serviceimpl.BlogService;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

//    @GetMapping("/user/emps")
//    public String list(Model model){
//        List<tUser> list = tUserService.getAll();
//        log.info("list-----{}", list);
//        model.addAttribute("listResult", list);
//        return "emp/list";
//    }

    @GetMapping("/blogs")
    public String list(Model model){
        List<Blog> list = blogService.getBlogs();
        model.addAttribute("listResult", list);
        return "blogs/list";
        //return new ModelAndView("blogs/list", "blogModel", model);
    }
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping(value = "/blogs/{id}")
    public String delete(@PathVariable("id") Long id, Model model){
        blogService.deleteBlog(id);
        model.addAttribute("listResult", blogService.getBlogs());
        //return new ModelAndView("blogs/list", "blogModel", model);
        return "blogs/list";
    }
}
