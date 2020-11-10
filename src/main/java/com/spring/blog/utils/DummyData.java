package com.spring.blog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import com.spring.blog.model.Author;
import com.spring.blog.model.Post;
import com.spring.blog.repository.AuthorRepository;
import com.spring.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DummyData {
  
  @Autowired
  PostRepository postRepository;

  @PostConstruct
  public void savePost() {

    List<Post> postList = new ArrayList<>();

    Post postOne = new Post();

    postOne.setAuthor("Lorem Ipsum");
    postOne.setCreatedAt(LocalDate.now());
    postOne.setTitle("What is Lorem Ipsum?");
    postOne.setBody("Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");

    Post postTwo = new Post();

    postTwo.setAuthor("Lorem Ipsum");
    postTwo.setCreatedAt(LocalDate.now());
    postTwo.setTitle("Where does it come from?");
    postTwo.setBody("Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32.");

    postList.add(postOne);
    postList.add(postTwo);

    for (Post post : postList) {
      Post postSaved = postRepository.save(post);
      System.out.println(postSaved.getId());
    }
  }
  
  @Autowired
  AuthorRepository authorRepository;

  @PostConstruct
  public void saveAuthor() {

    List<Author> authorList = new ArrayList<>();

    Author authorOne = new Author();

    authorOne.setName("Lorem Ipsum");
    authorOne.setCreatedAt(LocalDate.now());

    authorList.add(authorOne);

    for (Author author : authorList) {
      Author authorSaved = authorRepository.save(author);
      System.out.println(authorSaved.getId());
    }
  }

}
