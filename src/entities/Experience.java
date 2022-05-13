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
public class Experience {
    
    int id , id_author , likes;
    String title , content , date;

    public Experience() {
    }
    
    

    public Experience(int id, int id_author, int likes, String title, String content, String date) {
        this.id = id;
        this.id_author = id_author;
        this.likes = likes;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public Experience(int id_author, int likes, String title, String content, String date) {
        this.id_author = id_author;
        this.likes = likes;
        this.title = title;
        this.content = content;
        this.date = date;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Experience{" + "id=" + id + ", id_author=" + id_author + ", likes=" + likes + ", title=" + title + ", content=" + content + ", date=" + date + '}';
    }
    
    
    
}
