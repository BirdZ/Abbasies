package com.example.adrian.abbasies.Objects;

import java.util.Date;

/**
 * Created by Adrian on 24/04/2016.
 */
public class Advertisement {
    private String objectId;
    private Date createdAt;
    private Date uptadedAt;

    public Advertisement(String objectId, Date uptadedAt, Date createdAt){
        this.objectId = objectId;
        this.createdAt = createdAt;
        this.uptadedAt = uptadedAt;
    }
}
