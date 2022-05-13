/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author tasni
 */
public class HomeForm extends BaseForm{
    Form current; 
    public HomeForm()
   {    
       current=this;
       setTitle("Welcome !");
       setLayout(BoxLayout.y());
       
       add(new Label("Choose an option"));
       Button btn_Back= new Button("Admin Interface");
       Button btn_Front= new Button("User Interface");
       
       btn_Back.addActionListener(e-> new ExperienceBACK(current).show());
       btn_Front.addActionListener(e-> new ExperienceFront(current).show());
       
       addAll(btn_Back,btn_Front);
    }
    
    
}
