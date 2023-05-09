package com.example.ss6.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "typeBlogManager")
public class TypeBlog {
    @Id
    private int idTypeBlog;
    private String nameTypeBlog;

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @OneToMany(mappedBy = "typeBlog")
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
}
