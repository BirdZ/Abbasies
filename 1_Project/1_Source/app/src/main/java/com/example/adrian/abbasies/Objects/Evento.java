package com.example.adrian.abbasies.Objects;

import com.parse.ParseGeoPoint;

import java.util.Date;

/**
 * Created by Adrián on 24/08/2015.
 */
public class Evento {
    private String objectId;
    private String eventTitle;
    private String eventDescription;
    private Date eventDate;
    private int eventType;
    private String eventAdress;
    private ParseGeoPoint eventLocation;
    private Date createdAt;
    private Date uptadedAt;

    public Evento(String objectId, Date uptadedAt, Date createdAt, ParseGeoPoint eventLocation, String eventAdress, int eventType, Date eventDate, String eventDescription, String eventTitle) {
        this.objectId = objectId;
        this.eventTitle = eventTitle;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.eventType = eventType;
        this.eventAdress = eventAdress;
        this.eventLocation = eventLocation;
        this.createdAt = createdAt;
        this.uptadedAt = uptadedAt;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public int getEventType() {
        return eventType;
    }

    public void setEventType(int eventType) {
        this.eventType = eventType;
    }

    public String getEventAdress() {
        return eventAdress;
    }

    public void setEventAdress(String eventAdress) {
        this.eventAdress = eventAdress;
    }

    public ParseGeoPoint getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(ParseGeoPoint eventLocation) {
        this.eventLocation = eventLocation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUptadedAt() {
        return uptadedAt;
    }

    public void setUptadedAt(Date uptadedAt) {
        this.uptadedAt = uptadedAt;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "objectId='" + objectId + '\'' +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventDate=" + eventDate +
                ", eventType=" + eventType +
                ", eventAdress='" + eventAdress + '\'' +
                ", eventLocation=" + eventLocation +
                ", createdAt=" + createdAt +
                ", uptadedAt=" + uptadedAt +
                '}';
    }
}
