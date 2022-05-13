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
    private String userId;

    public Reclamation(int reclamationId, String state, String email, String subject, String reclamation, String userId) {
        this.reclamationId = reclamationId;
        this.state = state;
        this.email = email;
        this.subject = subject;
        this.reclamation = reclamation;
        this.userId = userId;
    }

    public Reclamation(String state, String email, String subject, String reclamation, String userId) {
        this.state = state;
        this.email = email;
        this.subject = subject;
        this.reclamation = reclamation;
        this.userId = userId;
    }

    public Reclamation() {
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

    public String getUserId() {
        return userId;
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

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "reclamation{" + "reclamationId=" + reclamationId + ", state=" + state + ", email=" + email + ", subject=" + subject + ", reclamation=" + reclamation + ", userId=" + userId + '}';
    }
    
    
}
