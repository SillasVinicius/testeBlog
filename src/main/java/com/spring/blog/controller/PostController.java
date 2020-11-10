package com.spring.blog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.spring.blog.model.Post;
import com.spring.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {
  
  @Autowired
  PostService postService;

  @RequestMapping(value = "/posts", method = RequestMethod.GET)
  public ModelAndView getPosts() {
    ModelAndView modelAndView = new ModelAndView("posts");
    List<Post> posts = postService.findAll();
    modelAndView.addObject("posts", posts);
    return modelAndView;
  }

  @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
  public ModelAndView getPostDetails(@PathVariable("id") long id) {
    ModelAndView modelAndView = new ModelAndView("postDetails");
    Post post = postService.findById(id);
    modelAndView.addObject("post", post);
    return modelAndView;
  }
  
  @RequestMapping(value = "/posts/getCount", method = RequestMethod.GET)
	public @ResponseBody int getCount() {
	  List<Post> posts = postService.findAll();
	    return posts.size();
	}

  @RequestMapping(value = "/newpost", method = RequestMethod.GET)
  public String getPostForm() {
    return "postForm";
  }

  @RequestMapping(value = "/newpost", method = RequestMethod.POST)
  public String savePost(@Valid Post post, BindingResult result, RedirectAttributes attributes) {
    if(result.hasErrors()) {
      attributes.addFlashAttribute("message", "Check that the required fields have been completed");
      return "redirect:/newpost";
    }
    post.setCreatedAt(LocalDate.now());
    postService.save(post);
    return "redirect:/posts";
  }
}
