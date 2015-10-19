package com.example.adrian.abbasies.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by Adrian on 31/08/2015.
 */
public class eventAdapterController extends BaseAdapter {

    private eventAdapterManager eam;

    public eventAdapterController() {
        this.eam = new eventAdapterManager();
    }

    @Override
    public int getCount() {

        return eam.getCount();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
