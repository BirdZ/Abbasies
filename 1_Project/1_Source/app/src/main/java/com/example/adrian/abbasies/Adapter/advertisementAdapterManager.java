package com.example.adrian.abbasies.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.adrian.abbasies.Objects.Advertisement;
import com.example.adrian.abbasies.Objects.Evento;
import com.example.adrian.abbasies.R;
import com.example.adrian.abbasies.Repository.repositoryController;

/**
 * Created by Adrian on 24/04/2016.
 */
public class advertisementAdapterManager {
    private repositoryController rc;
    private Context cntx;

    public advertisementAdapterManager(Context cntx){
        this.cntx = cntx;
        this.rc = new repositoryController(cntx);
    }

    public int getCount() {
        return rc.getCount();
    }

    public Advertisement getItem(int position) {
        return null; //rc.getA(position);
    }

    public String getItemId(int position) {

        return rc.getEvent(position).getObjectId();
    }

    public View getView(View convertView, Advertisement advertisement){
        eventHolder holder;
        if(convertView == null) {

            LayoutInflater inflater = LayoutInflater.from(this.cntx);
            convertView = inflater.inflate(R.layout.event_view, null);
            holder = new eventHolder();
            holder.day = (TextView)convertView.findViewById(R.id.day_listevent);
            holder.hour = (TextView)convertView.findViewById(R.id.hour_listevent);
            holder.month = (TextView)convertView.findViewById(R.id.month_listevent);
            holder.tittle = (TextView) convertView.findViewById(R.id.title_listevent);
            convertView.setTag(holder);
            Log.v("advertisement", convertView.toString());
        } else {
            Log.v("advertisement", "else");
            holder = (eventHolder) convertView.getTag();
        }
        Log.v("advertisement", holder.toString());
//        holder.hour.setText(advertisement.getEventDate().getHours()+"");
//        holder.day.setText(advertisement.getEventDate().getDay()+"");
//        holder.month.setText(advertisement.getEventDate().getMonth()+"");
//        holder.tittle.setText(advertisement.getEventTitle()+"");
        return convertView;
    }

    public void updateList(){

    }
}
