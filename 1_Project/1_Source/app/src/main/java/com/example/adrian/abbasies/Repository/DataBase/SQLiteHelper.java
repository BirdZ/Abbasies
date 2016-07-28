package com.example.adrian.abbasies.Repository.DataBase;

/**
 * Created by Adrián on 20/04/2015.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class SQLiteHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Festes App";
    public static final String EVENTS_TABLE_NAME = "Events";

    public static final String ATTR_OBJECT_ID = "objectId";
    public static final int COLUMN_OBJECT_ID = 0;
    public static final String ATTR_EVENT_TITLE = "eventTitle";
    public static final int COLUMN_EVENT_TITLE = 1;
    public static final String ATTR_EVENT_DESCRIPTION = "EventDescription";
    public static final int COLUMN_EVENT_DESCRIPTION = 2;
    public static final String ATTR_EVENT_DATE = "eventDate";
    public static final int COLUMN_EVENT_DATE = 3;
    public static final String ATTR_EVENT_TYPE = "eventType";
    public static final int COLUMN_EVENT_TYPE = 4;
    public static final String ATTR_EVENT_ADRESS = "eventAdress";
    public static final int COLUMN_EVENT_ADRESS = 5;
    public static final String ATTR_EVENT_LOCATIONT_LAT = "eventLocationLat";
    public static final int COLUMN_EVENT_LOCATIONT_LAT = 6;
    public static final String ATTR_EVENT_LOCATIONT_LONG = "eventLocationLong";
    public static final int COLUMN_LOCATIONT_LONG = 7;
    public static final String ATTR_CREATE_AT = "createAt";
    public static final int COLUMN_CREATE_AT = 8;
    public static final String ATTR_UPDATE_AT = "updateAt";
    public static final int COLUMN_UPDATE_AT = 9;

    String sqlEventos = "CREATE TABLE "+EVENTS_TABLE_NAME+" ("+
            ATTR_OBJECT_ID+" TEXT PRIMARY KEY, "+
            ATTR_EVENT_TITLE+" TEXT, "+
            ATTR_EVENT_DESCRIPTION+" TEXT, "+
            ATTR_EVENT_DATE+" INTEGER, "+
            ATTR_EVENT_TYPE+" INT,  "+
            ATTR_EVENT_ADRESS+" TEXT, "+
            ATTR_EVENT_LOCATIONT_LAT+" REAL, "+
            ATTR_EVENT_LOCATIONT_LONG+" REAL, "+
            ATTR_CREATE_AT+" INTEGER, "+
            ATTR_UPDATE_AT+" INTEGER)";

    public SQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlEventos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS" + EVENTS_TABLE_NAME);
        //Se crea la nueva versión de la tabla
        db.execSQL(sqlEventos);
    }

    public boolean saveEvent(String objectId, long uptadedAt, long createdAt, double eventLocationLat, double eventLocationLong, String eventAdress, int eventType, long eventDate, String eventDescription, String eventTitle) {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getWritableDatabase();
        boolean resultado = false;
        Log.v("database", objectId + " " + uptadedAt + " " + createdAt + " " + eventLocationLat + " " + eventLocationLong + " "+ eventAdress + " " + eventType + " " + eventDate + " " + eventDescription + " " + eventTitle);

        if (db != null) {
            //Almacenamos los valores
            ContentValues valores = new ContentValues();
            valores.put(ATTR_OBJECT_ID, objectId);
            valores.put(ATTR_EVENT_TITLE, eventTitle);
            valores.put(ATTR_EVENT_DESCRIPTION, eventDescription);
            valores.put(ATTR_EVENT_DATE, eventDate);
            valores.put(ATTR_EVENT_TYPE, eventType);
            valores.put(ATTR_EVENT_ADRESS, eventAdress);
            valores.put(ATTR_EVENT_LOCATIONT_LAT, eventLocationLat);
            valores.put(ATTR_EVENT_LOCATIONT_LONG, eventLocationLong);
            valores.put(ATTR_CREATE_AT, createdAt);
            valores.put(ATTR_UPDATE_AT, uptadedAt);
            try {
                //Insertamos la nueva línea
                long result = db.insert(EVENTS_TABLE_NAME, null, valores);
                if (result < 0) {
                    //En el caso de que no se haya insertado la línea porque ya existía, se reemplaza
                    String select = ATTR_OBJECT_ID+" = "+objectId;
                    result = db.update(EVENTS_TABLE_NAME, valores, select, null);
                    if (result >= 0)
                        resultado = true;
                    else
                        resultado = false;
                } else
                    resultado = true;
            }  catch (SQLiteConstraintException sqlce){
                resultado = false;
                Log.v("databaseerror", "error");
            } catch (Exception e) {
                resultado = false;
            }
            //Se cerra el escritor
            db.close();
        }
        return resultado;
    }

    public Cursor getEvents() {
        //Obtenemos el escritor de la base de datos
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {ATTR_OBJECT_ID, ATTR_EVENT_TITLE, ATTR_EVENT_DESCRIPTION, ATTR_EVENT_DATE, ATTR_EVENT_TYPE, ATTR_EVENT_ADRESS, ATTR_EVENT_LOCATIONT_LAT, ATTR_EVENT_LOCATIONT_LONG, ATTR_CREATE_AT, ATTR_UPDATE_AT};
        Cursor c = db.query(EVENTS_TABLE_NAME, valores_recuperar,
                null, null, null, null, ATTR_EVENT_DATE+" DESC", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public Cursor getEvent(String objectId){
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {ATTR_OBJECT_ID, ATTR_EVENT_TITLE, ATTR_EVENT_DESCRIPTION, ATTR_EVENT_DATE, ATTR_EVENT_TYPE, ATTR_EVENT_ADRESS, ATTR_EVENT_LOCATIONT_LAT, ATTR_EVENT_LOCATIONT_LONG, ATTR_CREATE_AT, ATTR_UPDATE_AT};
        Cursor c = db.query(EVENTS_TABLE_NAME, valores_recuperar,
                ATTR_OBJECT_ID+" ="+objectId, null, null, null, ATTR_EVENT_DATE+" DESC", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public long getLastUpdate() throws Exception {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = { ATTR_UPDATE_AT };
        Cursor c = db.query(EVENTS_TABLE_NAME, valores_recuperar, null, null, null,null, ATTR_UPDATE_AT + "DESC", "1");
        if (c != null) {
            c.moveToFirst();
        } else {
            throw new Exception();
        }
        return c.getLong(COLUMN_UPDATE_AT);
    }

    public boolean deleteEvent(String objectId){
        return false;
    }
}
