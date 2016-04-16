package com.inoapp.fonoapi;

import com.google.gson.annotations.Expose;

/**
 * Created by Trung Vo on 3/11/16.
 */
public class FonoStatus {
    @Expose public String status;
    @Expose public String message;

    public String toJson() {
        return DataAcquirer.getInstance().gson.toJson(this);
    }

    public static FonoStatus newInstances(String json) {
        return DataAcquirer.getInstance().gson.fromJson(json, FonoStatus.class);
    }
}

//{"status":"error","message":"No Matching Results Found.","innerException":null}