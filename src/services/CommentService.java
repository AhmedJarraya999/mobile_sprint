/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entities.Comment;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author tasni
 */
public class CommentService {
    public ArrayList<Comment> comments;
    public static CommentService instance;
    public boolean resultOK;
    private ConnectionRequest req;
    
    
      public CommentService() {
       req = new ConnectionRequest();
    }
    
    public static CommentService getInstance(){
        if(instance == null)
            instance= new CommentService();
        return instance;   
    }  
    
    public boolean addComment(Comment c){
        String url=Statics.BASE_URL+"/comment/addJSON/new/"
                +"?id="+c.getId()
                +"?author="+c.getAuthor()
                + "?date=" + c.getDate()
                + "?idExp=" + c.getId_exp()
                + "?content=" + c.getContent();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK=req.getResponseCode()==200;
                req.removeResponseListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
      
      public ArrayList<Comment> parseComments(String jsonText) throws IOException{
          comments=new ArrayList<>();
          JSONParser j = new JSONParser();
        
          Map<String,Object> commentsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
          List<Map<String,Object>> list = (List<Map<String,Object>>)commentsListJson.get("root");
         
          for(Map<String,Object> obj : list){
          Comment c = new Comment() ;
          float id = Float.parseFloat(obj.get("id").toString());
          c.setId((int)id);
          c.setAuthor((int)Float.parseFloat(obj.get("author").toString()));
          c.setContent(obj.get("content").toString());
          c.setDate(obj.get("date").toString());
          c.setLikes((int)Float.parseFloat(obj.get("likes").toString()));
          comments.add(c);
          }
          return comments;
      }
      
      public ArrayList<Comment> getAllComments(){
          String url=Statics.BASE_URL+"/comment/AllComments/";
          req.setUrl(url);
          req.setPost(false);
          req.addResponseListener(new ActionListener<NetworkEvent>() {
              @Override
              public void actionPerformed(NetworkEvent evt) {
                  try {
                      comments= parseComments(new String(req.getResponseData()));
                  } catch (IOException ex) {
                  
                  }
                  req.removeResponseListener(this);
              }
          });
          NetworkManager.getInstance().addToQueueAndWait(req);
          return comments;
      }
    
}
