/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.TextField;
import com.mycompany.entities.Reclamation;
import com.mycompany.services.ServiceReclamation;


/**
 *
 * @author ACER
 */
public class AddReclamation extends Form{

    AddReclamation(Form previous) {
       setTitle("Add Reclamations"); 
       setLayout(BoxLayout.y());
               
       TextField tfUser = new TextField("", "userId");
       TextField tfState = new TextField("active", "state");
       TextField tfEmail = new TextField("", "email");
       TextField tfSubject = new TextField("", "subject");
       TextField tfReclamation = new TextField("", "reclamation");
       
       Button btnValider = new Button("Add Reclamation");
       
       btnValider.addActionListener(new ActionListener(){
           @Override
           public void actionPerformed(ActionEvent evt) {
              if ((tfUser.getText().length()==0)||(tfState.getText().length()==0)||(tfEmail.getText().length()==0)||(tfSubject.getText().length()==0)||(tfReclamation.getText().length()==0))
                       Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
              else
              {
                  
                  try {
                  
                  Reclamation r = new Reclamation("1", "active", tfEmail.getText(), tfSubject.getText(), tfReclamation.getText());
                  if (new ServiceReclamation().addReclamation(r))
                       Dialog.show("Succecsss", "good", "OK", null);
                    } catch (NumberFormatException e) {
                         Dialog.show("Alert", "WRONG", "OK", null);
                    }
              }
              
            }
       });
       
       addAll(tfUser,tfState,tfEmail,tfSubject,tfReclamation,btnValider);
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
}
