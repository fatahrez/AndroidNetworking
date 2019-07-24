package com.lukmo.retrofitpractise.Network;

import com.lukmo.retrofitpractise.User;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {
    @GET("/posts")
    Observable<List<User>> getUsers();

    @POST("/posts")
    @FormUrlEncoded
    Observable<User> savePost(
            @Field("title") String title,
            @Field("body") String body,
            @Field("userId") long userId
    );
}
