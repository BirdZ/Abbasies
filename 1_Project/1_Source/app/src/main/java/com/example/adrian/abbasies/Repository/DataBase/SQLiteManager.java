package com.example.adrian.abbasies.Repository.DataBase;

import android.content.Context;
import android.database.Cursor;

import com.example.adrian.abbasies.Objects.Evento;
import com.parse.ParseGeoPoint;

import java.util.Date;

/**
 * Created by Adrian on 24/08/2015.
 */
public class SQLiteManager  {

    private SQLiteHelper sqlh;
    public SQLiteManager(Context cntx) {
        sqlh = new SQLiteHelper(cntx, SQLiteHelper.DB_NAME, null, 1);
    }

    public boolean saveEvent(Evento evento){

        ParseGeoPoint location = evento.getEventLocation();
        double latitude = location.getLatitude();
        double longitude = location.getLongitude();
        long date = evento.getEventDate().getTime();
        long createAt = evento.getCreatedAt().getTime();
        long updateAt = evento.getUptadedAt().getTime();
        return sqlh.saveEvent(evento.getObjectId(), updateAt, createAt, latitude, longitude, evento.getEventAdress(), evento.getEventType(), date, evento.getEventDescription(), evento.getEventTitle());
    }

    public Evento getEvent(String objectId){
        Cursor c = sqlh.getEvent(objectId);
        ParseGeoPoint location = new ParseGeoPoint();
        location.setLatitude(c.getDouble(SQLiteHelper.COLUMN_EVENT_LOCATIONT_LAT));
        location.setLongitude(c.getDouble(SQLiteHelper.COLUMN_LOCATIONT_LONG));
        Date date = new Date();
        date.setTime(c.getLong(SQLiteHelper.COLUMN_EVENT_DATE));
        Date createAt = new Date();
        createAt.setTime(c.getLong(SQLiteHelper.COLUMN_CREATE_AT));
        Date updateAt = new Date();
        updateAt.setTime(c.getLong(SQLiteHelper.COLUMN_UPDATE_AT));
        Evento event = new Evento(c.getString(SQLiteHelper.COLUMN_OBJECT_ID), updateAt, createAt, location, c.getString(SQLiteHelper.COLUMN_EVENT_ADRESS), c.getInt(SQLiteHelper.COLUMN_EVENT_TYPE), date, c.getString(SQLiteHelper.COLUMN_EVENT_DESCRIPTION), c.getString(SQLiteHelper.COLUMN_EVENT_TITLE));
        return event;
    }

    public Cursor getAll(){
        return sqlh.getEvents();
    }

    public Date getLastUpdate(){
        Date lastUpdate = new Date();
        try{
            lastUpdate.setTime(sqlh.getLastUpdate());
        } catch(Exception e){
            return new Date();
        }
        return lastUpdate;
    }

    public boolean deleteEvent(Evento event){
        return sqlh.deleteEvent(event.getObjectId());
    }
}
