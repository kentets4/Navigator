package com.ludumdevo.navigator;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
public class Helper {
    private static final String DIRECTION_API = "https://maps.googleapis.com/maps/api/directions/json?origin=";
    public static final String API_KEY = "AIzaSyDTah-xAk6pKm_hmV2yJ6zOasxY4bxecaM";
    public static final int MY_SOCKET_TIMEOUT_MS = 5000;
    public static String getUrl(String originLat, String originLon, String destinationLat, String destinationLon, int pathTopic){
        String waypoints = "";
        if (pathTopic == 1)
            waypoints = "&waypoints=55.7559404,37.6156441|55.7556246,37.6193867";
        if (pathTopic == 2)
            waypoints = "&waypoints=55.7559404,37.6156441|55.7556246,37.6193867";
        return Helper.DIRECTION_API + originLat+","+originLon+"&destination="+destinationLat+","+destinationLon+"&key="+API_KEY+"&mode=walking"+waypoints;
    }
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}