 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author ACER
 */
public class Reclamation {
    
    private int reclamationId;
    private String state;
    private String email;
    private String subject;
    private String reclamation;
    private User user;

    public Reclamation(int reclamationId, String state, String email, String subject, String reclamation, User user) {
        this.reclamationId = reclamationId;
        this.state = state;
        this.email = email;
        this.subject = subject;
        this.reclamation = reclamation;
        this.user = user;
    }

    public Reclamation(String state, String email, String subject, String reclamation, User user) {
        this.state = state;
        this.email = email;
        this.subject = subject;
        this.reclamation = reclamation;
        this.user = user;
    }

    public int getReclamationId() {
        return reclamationId;
    }

    public String getState() {
        return state;
    }

    public String getEmail() {
        return email;
    }

    public String getSubject() {
        return subject;
    }

    public String getReclamation() {
        return reclamation;
    }

    public User getUser() {
        return user;
    }

    public void setReclamationId(int reclamationId) {
        this.reclamationId = reclamationId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setReclamation(String reclamation) {
        this.reclamation = reclamation;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "reclamation{" + "reclamationId=" + reclamationId + ", state=" + state + ", email=" + email + ", subject=" + subject + ", reclamation=" + reclamation + ", user=" + user + '}';
    }
    
    
}
