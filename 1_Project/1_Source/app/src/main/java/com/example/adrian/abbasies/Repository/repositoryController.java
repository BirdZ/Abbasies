package com.example.adrian.abbasies.Repository;

import android.content.Context;

import com.example.adrian.abbasies.Objects.Evento;

public class repositoryController {

    private repositoryManager rm;

    public repositoryController(Context cntx){
        this.rm = new repositoryManager(cntx);
    }

    public Evento getEvent(int position){
        return rm.getEvent(position);
    }


    public void loadNewEvents(){
        rm.loadNewEvents();
    }

    public void loadOldEvents(){
        rm.loadOldEvents();
    }

    public void updateDB(){

    }

    public void updateEvent(String code){
        rm.updateEvent(code);
    }
    public int getCount(){
        return rm.count();
    }

}
