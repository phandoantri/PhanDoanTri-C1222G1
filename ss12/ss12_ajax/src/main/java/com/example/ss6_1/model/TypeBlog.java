package com.example.ss6_1.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;
@Entity
@Table(name = "type_blog")
public class TypeBlog {
    @Id
    private int idTypeBlog;
    private String nameTypeBlog;

    @OneToMany(mappedBy = "typeBlog")
    @JsonBackReference
    private List<Blog> blogs;


    public TypeBlog() {
    }

    public TypeBlog(int idTypeBlog, String nameTypeBlog) {
        this.idTypeBlog = idTypeBlog;
        this.nameTypeBlog = nameTypeBlog;
    }

    public int getIdTypeBlog() {
        return idTypeBlog;
    }

    public void setIdTypeBlog(int idTypeBlog) {
        this.idTypeBlog = idTypeBlog;
    }

    public String getNameTypeBlog() {
        return nameTypeBlog;
    }

    public void setNameTypeBlog(String nameTypeBlog) {
        this.nameTypeBlog = nameTypeBlog;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
