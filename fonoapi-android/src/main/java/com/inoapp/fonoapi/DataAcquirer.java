package com.inoapp.fonoapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by mtrung3 on 3/9/16.
 */
public class DataAcquirer {
    //private static final String TAG = "DataAcquirer";

    private static class Holder {
        static final DataAcquirer INSTANCE = new DataAcquirer();
    }

    public static DataAcquirer getInstance() {
        return Holder.INSTANCE;
    }

    public Gson gson;

    DataAcquirer() {
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        gson = builder.create();
    }
}
