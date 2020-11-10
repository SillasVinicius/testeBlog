package com.spring.blog.service;

import java.util.List;
import com.spring.blog.model.Author;

public interface AuthorService {
  
  List<Author> findAll();
  
  Author findById(long id);

  Author save(Author author);
}
