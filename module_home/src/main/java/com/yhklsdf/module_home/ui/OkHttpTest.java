package com.yhklsdf.module_home.ui;

import android.support.annotation.NonNull;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class OkHttpTest {
    public static void main(String[] args) throws IOException {
        OkHttpClient mClient = new OkHttpClient();
        OkHttpClient mClient1 = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS )
                .cache(new Cache(new File("cache"),24 * 1024 * 1024))
                .build();

        Request request = new Request.Builder()
                .url("https://hencoder.com/")
                .build();

        Call call = mClient.newCall(request);

        Response response = call.execute();
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            }
        });
    }
}
