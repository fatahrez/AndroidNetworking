package com.lukmo.retrofitpractise.Network;

public class NetworkUtils {
    private static UserService userService;

    public static UserService getUserService(){
        if (userService == null)
            userService = RetrofitAdapter.getInstance().create(UserService.class);

        return userService;
    }
}
