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
       
        Button btn_add = new Button("Add Experience");
        Button btn_list = new Button("List Experience");
        
        btn_add.addActionListener(e-> new addExperienceForm(current).show());
        btn_list.addActionListener(e-> new listExperienceForm(current).show());
        
        addAll(btn_add,btn_list);
    }
    
}
