package com.spring.blog.service.serviceImpl;

import java.util.List;

import com.spring.blog.model.Author;
import com.spring.blog.repository.AuthorRepository;
import com.spring.blog.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

  @Autowired
  AuthorRepository authorRepository;

  @Override
  public List<Author> findAll() {
    return authorRepository.findAll();
  }

  @Override
  public Author findById(long id) {
    return authorRepository.findById(id).get();
  }

  @Override
  public Author save(Author author) {
    return authorRepository.save(author);
  }
}
