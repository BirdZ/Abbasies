package com.example.adrian.abbasies.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.adrian.abbasies.Objects.Evento;

/**
 * Created by Adrian on 31/08/2015.
 */
public class eventAdapterController extends BaseAdapter {

    private eventAdapterManager eam;
    private Context cntx;

    public eventAdapterController(Context cntx) {
        Log.v("service", "eventAdapterController");
        this.eam = new eventAdapterManager(cntx);
        this.cntx = cntx;
    }

    @Override
    public int getCount() {
        Log.v("service", eam.getCount()+"");

        return eam.getCount();
    }

    @Override
    public Object getItem(int position) {
        return eam.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        try{
            return Long.parseLong(eam.getItemId(position));
        }catch (NumberFormatException e){
            return 0;
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Evento event = eam.getItem(position);
        Log.v("service", event.toString());
        return eam.getView(convertView, event);
    }
}
