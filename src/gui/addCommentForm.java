/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entities.Comment;
import java.util.Date;
import services.CommentService;
/**
 *
 * @author tasni
 */
public class addCommentForm extends BaseForm{
    
    public addCommentForm(Form previous) {
        
        setTitle("New Comment");
        setLayout(BoxLayout.y());
        add(new Label("Add a new Commnet"));
        getToolbar().addCommandToLeftBar("⬅",null, (e) -> previous.showBack());
        
        
        TextField tf_content = new TextField("","Content");
        Button btn_post = new Button("Add Comment");
        
        btn_post.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tf_content.getText().length()==0))
                    Dialog.show("Alert", "Blank Fields", "OK", null);
                    
                else 
                { try {
                  String date = new Date().toString(); 
                  Comment c = new Comment(1,6,0,date);
                  if (new CommentService().addComment(c))
                       Dialog.show("Succecsss", "good", "OK", null);
                    } catch (NumberFormatException e) {
                         Dialog.show("Alert", "WRONG", "OK", null);
                    }
                }   
            }
        });
        
        addAll(tf_content,btn_post);
    }

 
    
}
