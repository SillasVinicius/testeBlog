package com.spring.blog.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "posts")
public class Post {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotBlank
  private String title;

  @NotBlank
  private String author;

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate createdAt;

  @NotBlank
  @Lob
  private String body;

  public Post() {
  }

  public Post(Long id, String title, String author, LocalDate createdAt, String body) {
    this.id = id;
    this.title = title;
    this.author = author;
    this.createdAt = createdAt;
    this.body = body;
  }

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return this.title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return this.author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public LocalDate getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(LocalDate createdAt) {
    this.createdAt = createdAt;
  }

  public String getBody() {
    return this.body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  public Post id(Long id) {
    this.id = id;
    return this;
  }

  public Post title(String title) {
    this.title = title;
    return this;
  }

  public Post author(String author) {
    this.author = author;
    return this;
  }

  public Post createdAt(LocalDate createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  public Post body(String body) {
    this.body = body;
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Post)) {
            return false;
        }
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(title, post.title) && Objects.equals(author, post.author) && Objects.equals(createdAt, post.createdAt) && Objects.equals(body, post.body);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, title, author, createdAt, body);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", title='" + getTitle() + "'" +
      ", author='" + getAuthor() + "'" +
      ", createdAt='" + getCreatedAt() + "'" +
      ", body='" + getBody() + "'" +
      "}";
  }

}
