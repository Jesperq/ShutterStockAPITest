package com.example.joppa.shutterstockapitest.api;

import android.util.Base64;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * Created by Jesper on 2015-11-14.
 */
public class ShutterStock {
    private static final RestAdapter ADAPTER = new RestAdapter.Builder()
            .setEndpoint("https://api.shutterstock.com/v2")
            .setRequestInterceptor(new RequestInterceptor() {
                @Override
                public void intercept(RequestFacade request) {
                    String authInfo = "6eb7cacd905f51071447:45529182045fce27f0206aa98113b7c003ffa1a3";
                    String authString = "Basic " + Base64.encodeToString(authInfo.getBytes(), Base64.NO_WRAP);
                    request.addHeader("Authorization", authString);
                }
            }).build();

    private static final ShutterStockService SERVICE = ADAPTER.create(ShutterStockService.class);

    /*
    Search metod som använder search från interfacet ShutterStockService
     */
    public static void search(String query, Callback<List<Image>> cb){
        SERVICE.search(query, new ImageCallback(cb));
    }

    /*
    Metod som hämtar de senaste bilderna med getRecent i interfacet ShutterStockService
     */
    public static void getRecent(Date date, Callback<List<Image>> cb){
        SERVICE.getRecent(new SimpleDateFormat("yyyy-MM-dd").format(date), new ImageCallback(cb));
    }

    /**
     * Privat class som gör det lättare för oss att få ut rätt typ av Callback
     */
    private static class ImageCallback implements Callback<Response>{
        private Callback<List<Image>> cb;

        ImageCallback(Callback<List<Image>> cb){
            this.cb = cb;
        }

        @Override
        public void success(Response response, retrofit.client.Response response2) {
            cb.success(response.data, response2);
        }

        @Override
        public void failure(RetrofitError error) {

        }
    }
}
