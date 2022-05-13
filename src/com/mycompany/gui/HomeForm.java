/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;

/**
 *
 * @author ACER
 */
public class HomeForm extends Form{
    Form current;
    public HomeForm(Resources theme){
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label ("Choose an option"));
        Button btnAdmin = new Button ("Admin");
        Button btnClient = new Button ("Client");
        
        btnAdmin.addActionListener(e-> new ListReclamation(current).show());
        btnClient.addActionListener(e-> new AddReclamation(current).show());
        
        addAll(btnAdmin,btnClient);
        
    
    
    }

    
}
