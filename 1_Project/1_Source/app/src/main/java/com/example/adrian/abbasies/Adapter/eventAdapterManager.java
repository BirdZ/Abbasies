package com.example.adrian.abbasies.Adapter;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.adrian.abbasies.Objects.Evento;
import com.example.adrian.abbasies.R;
import com.example.adrian.abbasies.Repository.repositoryController;

public class eventAdapterManager {
    private repositoryController rc;
    private Context cntx;

    public eventAdapterManager(Context cntx){
        this.cntx = cntx;
        this.rc = new repositoryController(cntx);
    }

    public int getCount() {
        return rc.getCount();
    }

    public Evento getItem(int position) {
        return rc.getEvent(position);
    }

    public String getItemId(int position) {

        return rc.getEvent(position).getObjectId();
    }

    public View getView(View convertView, Evento event){
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
            Log.v("event", convertView.toString());
        } else {
            Log.v("event", "else");
            holder = (eventHolder) convertView.getTag();
        }
        Log.v("event", holder.toString());
        holder.hour.setText(event.getEventDate().getHours()+"");
        holder.day.setText(event.getEventDate().getDay()+"");
        holder.month.setText(event.getEventDate().getMonth()+"");
        holder.tittle.setText(event.getEventTitle()+"");
        return convertView;
    }

    public void updateList(){

    }
}

class eventHolder{
    TextView day;
    TextView month;
    TextView hour;
    TextView tittle;
}
