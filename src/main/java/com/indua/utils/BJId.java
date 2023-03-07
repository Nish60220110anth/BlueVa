package com.indua.utils;

import java.util.UUID;

public class BJId {
    /**
     * This function creates a new instance of the BJId class and returns it.
     * 
     * @return A new instance of BJId
     */
    public static BJId createInstance() {
        return new BJId();
    }

    private UUID _id;

    private BJId() {

    }

    /**
     * This function returns the UUID of the object
     * 
     * @return The UUID of the object.
     */
    public UUID getId() {
        return _id;
    }

    /**
     * This function sets the value of the _id variable to the value of the _id
     * parameter
     * 
     * @param _id The unique identifier for the document.
     */

    public void setId(UUID _id) {
        this._id = _id;
    }
}
