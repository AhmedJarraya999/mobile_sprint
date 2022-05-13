/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author tasni
 */
public class Comment {
    int id , author , id_exp , likes ;
    String date;

    public Comment(int id, int author, int id_exp, int likes, String date) {
        this.id = id;
        this.author = author;
        this.id_exp = id_exp;
        this.likes = likes;
        this.date = date;
    }

    public Comment(int author, int id_exp, int likes, String date) {
        this.author = author;
        this.id_exp = id_exp;
        this.likes = likes;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getId_exp() {
        return id_exp;
    }

    public void setId_exp(int id_exp) {
        this.id_exp = id_exp;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" + "id=" + id + ", author=" + author + ", id_exp=" + id_exp + ", likes=" + likes + ", date=" + date + '}';
    }
    
    
    
}
