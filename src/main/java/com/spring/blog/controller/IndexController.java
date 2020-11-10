package com.spring.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
  @Autowired
  AuthorController author;
  @Autowired
  PostController posts;
  @GetMapping("/")
  public ModelAndView main(Model model){
		model.addAttribute("countAuthors", author.getCount());
		model.addAttribute("countPosts", posts.getCount());
		return new ModelAndView("index");
	}
}
