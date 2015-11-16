package com.example.joppa.shutterstockapitest.api;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Jesper on 2015-11-14.
 */
public interface ShutterStockService {
    @GET("/images/search")
    public void search(@Query("query") String query, Callback<Response> cb);

    @GET("/images/search")
    public void getRecent(@Query("added_date_start") String query, Callback<Response> cb);
}
