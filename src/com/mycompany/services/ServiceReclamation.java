/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Reclamation;
import com.mycompany.utils.Statics;
import java.util.ArrayList;




/**
 *
 * @author ACER
 */
public class ServiceReclamation {
    
    public ArrayList<Reclamation> reclamations;
    public static ServiceReclamation instance;
    public boolean resultOK;
    private ConnectionRequest req;
    public ServiceReclamation(){
        req = new ConnectionRequest();
    }
    public static ServiceReclamation getInstance(){
        if (instance == null)
            instance= new ServiceReclamation();
        return instance;
    
    }
    
    public boolean addReclamation(Reclamation r){
        String url = Statics.BASE_URL+"/reclamations"+r.getUserId()+"/"+r.getEmail()+"/"+r.getState()+"/"+r.getSubject()+"/"+r.getReclamation();
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK=req.getResponseCode()==200;
                req.removeResponseListener(this);
            }
        
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   
    }
    
//    public ArrayList<Reclamation> parseReclamation(String jsonText) throws IOException{
//        
//        
//        reclamations = new ArrayList<>();
//        JSONParser j = new JSONParser();
//        
//       // Map<String,Object> reclamationsListJson = j.parseJSON(new java.io.CharArrayReader(jsonText.toCharArray())); 
//            
//        //List<Map<String,Object>> list = (List<Map<String,Object>>)reclamationsListJson.get("root");
//        
//         Map<String,Object> reclamationsListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
//         List<Map<String,Object>> list = (List<Map<String,Object>>)reclamationsListJson.get("root");
//        
//        for(Map<String,Object> obj:list){
//          Reclamation r = new Reclamation() ;
//          float id = Float.parseFloat(obj.get("userId").toString());
//          r.setReclamationId((int)id);
//          r.setUserId(obj.get("userId").toString());
//          r.setState(obj.get("state").toString());
//          r.setEmail(obj.get("email").toString());
//          r.setSubject(obj.get("subject").toString());
//          r.setReclamation(obj.get("reclamation").toString());
//          reclamations.add(r);
//          }      
//    return reclamations;
//    }
//    public ArrayList<Reclamation> getAllReclamations(){
//          String url=Statics.BASE_URL+"/reclamation-back/";
//          req.setUrl(url);
//          req.setPost(false);
//          req.addResponseListener(new ActionListener<NetworkEvent>() {
//              @Override
//              public void actionPerformed(NetworkEvent evt) {
//                  try {
//                      reclamations= parseReclamation(new String(req.getResponseData()));
//                  } catch (IOException ex) {
//                 
//                  }
//                  req.removeResponseListener(this);
//              }
//          });
//          NetworkManager.getInstance().addToQueueAndWait(req);
//          return reclamations;
//      }
    
}
