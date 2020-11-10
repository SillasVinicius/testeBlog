package com.spring.blog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.spring.blog.model.Author;
import com.spring.blog.service.AuthorService;
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
public class AuthorController {
  
  @Autowired
  AuthorService authorService;

  @RequestMapping(value = "/authors", method = RequestMethod.GET)
  public ModelAndView getAuthors() {
    ModelAndView modelAndView = new ModelAndView("authors");
    List<Author> authors = authorService.findAll();
    modelAndView.addObject("authors", authors);
    return modelAndView;
  }

  @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
  public ModelAndView getAuthorDetails(@PathVariable("id") long id) {
    ModelAndView modelAndView = new ModelAndView("authorDetails");
    Author author = authorService.findById(id);
    modelAndView.addObject("author", author);
    return modelAndView;
  }
  
  @RequestMapping(value = "/authors/getCount", method = RequestMethod.GET)
	public @ResponseBody int getCount() {
	    List<Author> authors = authorService.findAll();
	    return authors.size();
	}


  @RequestMapping(value = "/newauthor", method = RequestMethod.GET)
  public String getAuthorForm() {
    return "authorForm";
  }

  @RequestMapping(value = "/newauthor", method = RequestMethod.POST)
  public String saveAuthor(@Valid Author author, BindingResult result, RedirectAttributes attributes) {
    if(result.hasErrors()) {
      attributes.addFlashAttribute("message", "Check that the required fields have been completed");
      return "redirect:/newauthor";
    }
    author.setCreatedAt(LocalDate.now());
    authorService.save(author);
    return "redirect:/authors";
  }
}
