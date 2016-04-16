package com.inoapp.fonoapi;

import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Trung Vo on 3/8/16.
 */
public class FonoApi {

    public static final String URL_API = "https://fonoapi.freshpixl.com/v1/getdevice";
    public static final String TOKEN = "&token=bb48887db376bf9d8c1b0e20ee347d9a770c811372512c8a";
    private static final String TAG = "FonoApi";

    private static class Holder {
        static final FonoApi INSTANCE = new FonoApi();
    }

    public static FonoApi getInstance() {
        return Holder.INSTANCE;
    }

    public class Result {
        FonoDevice[] fonoDevices;
        FonoStatus fonoStatus;

        public String responseJson;

        public Result(FonoDevice[] fonoDevices) {
            this.fonoDevices = fonoDevices;
        }

        public Result(FonoStatus fonoStatus, String responseJson) {
            this.fonoStatus = fonoStatus;
            this.responseJson = responseJson;
        }

        public boolean hasError() {
            return responseJson != null;
        }
        public FonoStatus getStatus() {
            return fonoStatus;
        }

        public FonoDevice[] getDevices() {
            return fonoDevices;
        }

    }

    Result parseStatus(String json) {
        try {
            FonoStatus fonoStatus = FonoStatus.newInstances(json);
            Log.d(TAG, fonoStatus.toJson());
            return new Result(fonoStatus, json);
        } catch (Exception ex2) {
            return new Result(null, json);
        }
    }


    //  ...must be called in background thread
    public Result getDevice(String queryStr) {
        String urlParameters  = "device="+queryStr + TOKEN;

        String json = httpPost(urlParameters);
        if (json == null) {
            Log.e(TAG, "!!! response json = null");
            return null;
        }

        if (json.charAt(0) == '{') {
            return parseStatus(json);
        }

        try {
            FonoDevice[] fonoDevices = FonoDevice.newInstances(json);
            if (fonoDevices == null || fonoDevices.length == 0) {
                return new Result(null, json);
            }

            //Log.d(TAG, "Success. # phones = " + fonoDevices.length);
            return new Result(fonoDevices);
        }
        catch (Exception ex) {
            Log.e(TAG, ex.getMessage() + "\n" + json);
            return parseStatus(json);
        }
    }

    String httpPost(String urlParameters) {
        try {
            byte[] postData = urlParameters.getBytes( "UTF-8" );

            URL url = new URL(URL_API);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setDoOutput( true );
            conn.setInstanceFollowRedirects( false );
            conn.setRequestMethod( "POST" );
            conn.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty( "charset", "utf-8");
            conn.setRequestProperty( "Content-Length", Integer.toString( postData.length ));
            conn.setUseCaches( false );

            conn.getOutputStream().write(postData);

            Reader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

            StringBuilder sb = new StringBuilder();
            for (int c; (c = in.read()) >= 0;)
                sb.append((char)c);
            String response = sb.toString();
            //Log.d(TAG, response);
            return response;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
