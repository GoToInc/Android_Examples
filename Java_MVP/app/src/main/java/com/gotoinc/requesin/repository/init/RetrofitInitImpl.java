package com.gotoinc.requesin.repository.init;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.gotoinc.requesin.repository.ApiConsts;
import com.gotoinc.requesin.repository.RetrofitRequest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Illia Derevianko on 23.11.18.
 * GoTo Inc.
 */
public class RetrofitInitImpl implements RetrofitInit {
    private RetrofitRequest retrofitQueries;

    public RetrofitInitImpl() {
        init();
    }

    private void init() {
        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(10_000L, TimeUnit.MILLISECONDS)
                .readTimeout(10_000L, TimeUnit.MILLISECONDS)
                .build();
        GsonBuilder builder = new GsonBuilder();
        builder.excludeFieldsWithoutExposeAnnotation();
        builder.setLenient();
        Gson gson = builder.create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConsts.HOSTNAME)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        retrofitQueries = retrofit.create(RetrofitRequest.class);
    }

    @Override
    public RetrofitRequest get() {
        return retrofitQueries;
    }
}
