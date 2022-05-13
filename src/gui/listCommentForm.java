/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import services.CommentService;

/**
 *
 * @author tasni
 */
public class listCommentForm extends BaseForm{
Form current;
    public listCommentForm(Form previous) {
        current=this;
           add(new Label("Check Comments!"));
        setTitle("List Of Comments");
        
         Button btn_add = new Button("Add Comment");
         btn_add.addActionListener(e-> new addCommentForm(current).show());
         
        SpanLabel sp = new SpanLabel();
        sp.setText(CommentService.getInstance().getAllComments().toString());
        addAll(btn_add,sp);
        getToolbar().addCommandToLeftBar("⬅",null, (e) -> previous.showBack());
    }
    
}
