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
public class ExperienceFront extends BaseForm{
    Form current;
     public ExperienceFront(Form previous)
    {   current=this;
       getToolbar().addCommandToLeftBar("⬅",null, (e) -> previous.showBack());
       
       setLayout(BoxLayout.y());
       setTitle("Front");
       
       
        Button btn_listexperience = new Button("List Experience");
        Button btn_listcomment = new Button("List Comment");
       
        btn_listexperience.addActionListener(e-> new listExperienceForm(current).show());
        btn_listcomment.addActionListener(e-> new listCommentForm(current).show());
        
        addAll(btn_listexperience,btn_listcomment);
    }
    
}
