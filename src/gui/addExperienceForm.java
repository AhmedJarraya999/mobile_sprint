/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.Experience;
import java.util.Date;
import services.ExperienceService;

/**
 *
 * @author tasni
 */
public class addExperienceForm extends BaseForm{

    public addExperienceForm(Form previous) {
        setTitle("Experiences!");
        setLayout(BoxLayout.y());
        getToolbar().addCommandToLeftBar("⬅",null, (e) -> previous.showBack());
        
        TextField tf_title = new TextField("","Title");
        TextField tf_content = new TextField("","Content");
        Button btn_post = new Button("Add Experience");
        
        btn_post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tf_title.getText().length()==0)||(tf_content.getText().length()==0))
                    Dialog.show("Alert", "Blank Fields", "OK", null);
                    
                else 
                { try {
                  String date = new Date().toString(); 
                  Experience e = new Experience(1, 0,tf_title.getText(), tf_content.getText(), date);
                  if (new ExperienceService().addExperience(e))
                       Dialog.show("Succecsss", "good", "OK", null);
                    } catch (NumberFormatException e) {
                         Dialog.show("Alert", "WRONG", "OK", null);
                    }
                }   
            }
        });
        
        addAll(tf_title,tf_content,btn_post);
        
               
    }
    
    
}
