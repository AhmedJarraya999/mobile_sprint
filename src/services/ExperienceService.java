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
import entities.Experience;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author tasni
 */
public class ExperienceService {
    public ArrayList<Experience> experiences;
    public static ExperienceService instance;
    public boolean resultOK;
    private ConnectionRequest req;

    public ExperienceService() {
       req = new ConnectionRequest();
    }
    
    public static ExperienceService getInstance(){
        if(instance == null)
            instance= new ExperienceService();
        return instance;   
    }    
    
    public boolean addExperience(Experience e,int id){
        String url=Statics.BASE_URL+"/experience/Front"+id
                +"id_author="+e.getId_author()
                + "likes=" + e.getLikes()
                + "title=" + e.getTitle()
                + "content=" + e.getContent()
                + "date=" + e.getDate();
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
    
      public boolean addExperience(Experience e){
        String url=Statics.BASE_URL+"/experience/Front"
                +"id_author="+e.getId_author()
                + "likes=" + e.getLikes()
                + "title=" + e.getTitle()
                + "content=" + e.getContent()
                + "date=" + e.getDate();
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
      
      public ArrayList<Experience> parseExperiences(String jsonText) throws IOException{
          experiences=new ArrayList<>();
          JSONParser j = new JSONParser();
        
          Map<String,Object> experiencesListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
          List<Map<String,Object>> list = (List<Map<String,Object>>)experiencesListJson.get("root");
         
          for(Map<String,Object> obj : list){
          Experience e = new Experience() ;
          float id = Float.parseFloat(obj.get("id").toString());
          e.setId((int)id);
          e.setId_author((int)Float.parseFloat(obj.get("idAuthor").toString()));
          e.setTitle(obj.get("title").toString());
          e.setContent(obj.get("content").toString());
          e.setDate(obj.get("date").toString());
          e.setLikes((int)Float.parseFloat(obj.get("likes").toString()));
          experiences.add(e);
          }
          return experiences;
      }
      
      public ArrayList<Experience> getAllExperiences(){
          String url=Statics.BASE_URL+"/experience/searchAll/";
          req.setUrl(url);
          req.setPost(false);
          req.addResponseListener(new ActionListener<NetworkEvent>() {
              @Override
              public void actionPerformed(NetworkEvent evt) {
                  try {
                      experiences= parseExperiences(new String(req.getResponseData()));
                  } catch (IOException ex) {
                  
                  }
                  req.removeResponseListener(this);
              }
          });
          NetworkManager.getInstance().addToQueueAndWait(req);
          return experiences;
      }
}
