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
public class ExperienceBACK extends BaseForm{
    Form current; 
    public ExperienceBACK(Form previous)
    {   current=this;
        getToolbar().addCommandToLeftBar("⬅",null, (e) -> previous.showBack());
        setLayout(BoxLayout.y());
       
        
        
    }
    
}
