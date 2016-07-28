package com.example.adrian.abbasies.Repository.serviceWeb;

import android.content.Context;
import android.util.Log;

import com.example.adrian.abbasies.Repository.DataBase.SQLiteHelper;
import com.example.adrian.abbasies.Repository.DataBase.SQLiteManager;
import com.example.adrian.abbasies.Objects.Evento;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import bolts.Task;

/**
 * Created by Adrian on 21/04/2015.
 */
public class conectServiceWeb {

    public static void getEvento(String id, final Context cntx){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.getInBackground(id, new GetCallback<ParseObject>() {
            public void done(ParseObject event, ParseException e) {
                if (e == null) {
                    String objectId = event.getString("objectId");
                    String eventTitle = event.getString("eventTitle");
                    String eventDescription = event.getString("eventDescription");
                    Date eventDate = event.getDate("eventDate");
                    int eventType = event.getInt("eventType");
                    String eventAdress = event.getString("eventAdress");
                    ParseGeoPoint eventLocation = event.getParseGeoPoint("eventLocation");
                    Date createdAt = event.getDate("createdAt");
                    Date uptadedAt = event.getDate("uptadedAt");
                    Evento evento = new Evento(objectId, uptadedAt, createdAt, eventLocation, eventAdress, eventType, eventDate, eventDescription, eventTitle);
                    SQLiteManager sqlm = new SQLiteManager(cntx);
                    sqlm.saveEvent(evento);
                } else {
                    // something went wrong
                }
            }
        });
    }
    public static void getNewEvents(Date upddateAt, final Context cntx){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        //query.setLimit(20);
        query.whereGreaterThan(SQLiteHelper.ATTR_UPDATE_AT, upddateAt);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> parseObjects, ParseException e) {
                Log.v("service", e.toString());
                if (e == null) {
                    int id = 0;
                    for(ParseObject event : parseObjects){
                        Log.v("service", event.toString());
                        String objectId = event.getString("objectId");
                        Log.v("service", "1");
                        String eventTitle = event.getString("eventTitle");
                        Log.v("service", "2");
                        String eventDescription = event.getString("eventDescription");
                        Log.v("service", "3");
                        Date eventDate = event.getDate("eventDate");
                        Log.v("service", "4");
                        int eventType = event.getInt("eventType");
                        Log.v("service", "5");
                        String eventAdress = event.getString("eventAdress");
                        Log.v("service", "6");
                        ParseGeoPoint eventLocation = event.getParseGeoPoint("eventLocation");
                        Log.v("service", "7");
                        Date createdAt = event.getDate("createdAt");
                        Log.v("service", "8");
                        Date uptadedAt = event.getDate("uptadedAt");
                        objectId = "" +(id++);
                        uptadedAt = new Date();
                        createdAt = new Date();
                        eventLocation = new ParseGeoPoint();
                        eventAdress = "mi dirección";
                        Log.v("service", "aquí");
                        Log.v("service", objectId + " " + uptadedAt + " " + createdAt + " " + eventLocation + " " + eventAdress + " " + eventType + " " + eventDate + " " + eventDescription + " " + eventTitle);
                        Evento evento = new Evento(objectId, uptadedAt, createdAt, eventLocation, eventAdress, eventType, eventDate, eventDescription, eventTitle);
                        SQLiteManager sqlm = new SQLiteManager(cntx);
                        sqlm.saveEvent(evento);
                    }
                } else {
                    // something went wrong
                }
            }
        });

    }

    public static void getOldEvents(String objectId, final Context cntx){
        Log.v("bucle", "fuara bucle");
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.setLimit(20);
        //Task<ParseObject> parseObjects = query.getFirstInBackground();
        if(objectId!=null)
            query.whereLessThan(SQLiteHelper.ATTR_OBJECT_ID, objectId);

        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    int id = 0;
                    Log.v("count", parseObjects.size()+"");
                    for (ParseObject event : parseObjects) {
                        Log.v("bucle", "dentro bucle "+ id);
                        String objectId = event.getString("objectId");
                        String eventTitle = event.getString("eventTitle");
                        String eventDescription = event.getString("eventDescription");
                        Date eventDate = event.getDate("eventDate");
                        int eventType = event.getInt("eventType");
                        String eventAdress = event.getString("eventAdress");
                        ParseGeoPoint eventLocation = event.getParseGeoPoint("eventLocation");
                        Date createdAt = event.getDate("createdAt");
                        Date uptadedAt = event.getDate("uptadedAt");
                        objectId = "" +(id);
                        id = id+1;
                        uptadedAt = new Date();
                        createdAt = new Date();
                        eventLocation = new ParseGeoPoint();
                        eventAdress = "mi dirección";
                        Log.v("service", "aquí");
                        Log.v("service", objectId + " " + uptadedAt + " " + createdAt + " " + eventLocation + " " + eventAdress + " " + eventType + " " + eventDate + " " + eventDescription + " " + eventTitle);
                        Evento evento = new Evento(objectId, uptadedAt, createdAt, eventLocation, eventAdress, eventType, eventDate, eventDescription, eventTitle);
                        SQLiteManager sqlm = new SQLiteManager(cntx);
                        sqlm.saveEvent(evento);
                    }
                } else {
                    // something went wrong
                }
            }
        });

    }
}
