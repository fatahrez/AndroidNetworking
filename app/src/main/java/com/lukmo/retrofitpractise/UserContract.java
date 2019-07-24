package com.lukmo.retrofitpractise;

import java.util.List;

public interface UserContract {
    interface View {
        void init();

        void showError(String message);

        void loadDataInList(List<User> users);
    }

    interface Presenter {
        void  start();

        void loadUsers();
    }
}
