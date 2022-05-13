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

/**
 *
 * @author ACER
 */
public class ServiceReclamation {
    public boolean resultOK;
    
    public boolean addReclamation(Reclamation r){
        String url = Statics.BASE_URL+"/reclamations"+r.getUser()+"/"+r.getEmail()+"/"+r.getState()+"/"+r.getSubject()+"/"+r.getReclamation();
        ConnectionRequest req = new ConnectionRequest(url);
        req.addResponseListener(new ActionListener<NetworkEvent>(){
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK=req.getResponseCode()==200;
            }
        
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;   
    }
}
