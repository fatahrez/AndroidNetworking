package com.lukmo.retrofitpractise;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String title;

    @SerializedName("body")
    private String body;

    @SerializedName("userId")
    private String userId;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getUserId() {
        return userId;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return
            "User{" +
                    "id = '" + id + '\'' +
                    ",title = '" + title + '\'' +
                    ",body = '" + body + '\'' +
                    ",userId = '" + userId + '\'' +
                    "}";
    }
}
