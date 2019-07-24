package com.lukmo.retrofitpractise;

import java.util.List;

public class UserPresenter implements UserContract.Presenter {
    UserContract.View mView;

    UserPresenter(UserContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.init();
    }

    @Override
    public void loadUsers() {
        UserTask.getUsers(new Callback<List<User>>() {
            @Override
            public void returnResult(List<User> userList) {
                mView.loadDataInList(userList);
            }

            @Override
            public void returnError(String message) {
                mView.showError(message);
            }
        });
    }
}
