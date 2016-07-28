package com.example.adrian.abbasies.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.adrian.abbasies.Objects.Advertisement;

/**
 * Created by Adrian on 24/04/2016.
 */
public class advertisementAdapterController extends BaseAdapter {
    private advertisementAdapterManager aam;
    private Context cntx;

    public advertisementAdapterController(Context cntx) {
        this.aam = new advertisementAdapterManager(cntx);
        this.cntx = cntx;
    }

    @Override
    public int getCount() {
        return aam.getCount();
    }

    @Override
    public Object getItem(int position) {
        return aam.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        try{
            return Long.parseLong(aam.getItemId(position));
        }catch (NumberFormatException e){
            return 0;
        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Advertisement advertisement = aam.getItem(position);
        Log.v("service", advertisement.toString());
        return aam.getView(convertView, advertisement);
    }
}
