package com.example.adrian.abbasies.Adapter;

import android.database.Cursor;

import com.example.adrian.abbasies.Objects.Evento;
import com.example.adrian.abbasies.Repository.repositoryController;

/**
 * Created by Carmen on 31/08/2015.
 */
public class eventAdapterManager {
    private Cursor c;
    private repositoryController rc;

    public int getCount() {
        return c.getCount();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {

        return 0;
    }

    public Evento getEvent(int position) {
        c.moveToPosition(position);
        return rc.getEvento((c.getString(0)));
    }

    public void updateList(){

    }
}
