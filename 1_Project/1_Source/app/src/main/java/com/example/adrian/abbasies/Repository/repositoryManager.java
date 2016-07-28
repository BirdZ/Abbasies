package com.example.adrian.abbasies.Repository;

import android.content.Context;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.util.Log;

import com.example.adrian.abbasies.Objects.Evento;
import com.example.adrian.abbasies.Repository.DataBase.SQLiteManager;
import com.example.adrian.abbasies.Repository.serviceWeb.conectServiceWeb;
import com.parse.ParseGeoPoint;

import java.util.Date;

/**
 * Created by Adrián on 31/08/2015.
 */
public class repositoryManager {
    private conectServiceWeb sw;
    private SQLiteManager sqlm;
    private Cursor c;
    private Context cntx;

    public repositoryManager(Context cntx){
        this.sw = new conectServiceWeb();
        this.sqlm = new SQLiteManager(cntx);
        this.c = this.sqlm.getAll();
        this.cntx = cntx;
        Log.v("count", "c.count() -> " + c.getCount());
        if(c.getCount() == 0){
            this.loadOldEvents();
        }
    }

    public Evento getEvent(int position){
        if(this.c.moveToPosition(position)){
            return this.sqlm.getEvent(c.getString(0));
        }
        else {
            conectServiceWeb.getEvento(c.getString(0), this.cntx);
        }
        return null;
    }

    public int count(){
        return c.getCount();
    }

    public void loadNewEvents(){
        conectServiceWeb.getNewEvents(sqlm.getLastUpdate(), cntx);
    }

    public void loadOldEvents(){
        Log.v("service", "loadOldEvents");
        c.moveToLast();
        try {
            conectServiceWeb.getOldEvents(c.getString(0), this.cntx);
        } catch(CursorIndexOutOfBoundsException e) {
            conectServiceWeb.getOldEvents(null, this.cntx);
        }
    }

    public void updateDB(){

    }

    public void updateEvent(String code){
        c.moveToFirst();
        conectServiceWeb.getNewEvents(sqlm.getLastUpdate(), cntx);
    }
}
