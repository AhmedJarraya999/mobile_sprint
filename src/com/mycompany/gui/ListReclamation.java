/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

/**
 *
 * @author ACER
 */
public class ListReclamation extends Form{

    public ListReclamation(Form previous) {
       setTitle("Show Reclamations");
       
               
       
       getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
       
        
    }

    
    
}
