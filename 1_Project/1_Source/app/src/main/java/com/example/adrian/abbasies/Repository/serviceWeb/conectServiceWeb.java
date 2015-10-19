package com.example.adrian.abbasies.Repository.serviceWeb;

import android.content.Context;

import com.example.adrian.abbasies.Repository.DataBase.SQLiteHelper;
import com.example.adrian.abbasies.Repository.DataBase.SQLiteManager;
import com.example.adrian.abbasies.Objects.Evento;
import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.Date;
import java.util.List;

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
                if (e == null) {
                    for(ParseObject event : parseObjects){
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
                    }
                } else {
                    // something went wrong
                }
            }
        });

    }

    public static void getOldEvents(String objectId, final Context cntx){
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Event");
        query.setLimit(20);
        if(objectId!=null)
            query.whereLessThan(SQLiteHelper.ATTR_OBJECT_ID, objectId);
        query.findInBackground(new FindCallback<ParseObject>() {
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    for(ParseObject event : parseObjects){
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
                    }
                } else {
                    // something went wrong
                }
            }
        });

    }
}
