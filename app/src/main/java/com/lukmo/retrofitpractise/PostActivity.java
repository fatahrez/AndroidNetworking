package com.lukmo.retrofitpractise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lukmo.retrofitpractise.Network.NetworkUtils;
import com.lukmo.retrofitpractise.Network.UserService;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostActivity extends AppCompatActivity {
    private TextView mResponseTv;
    private UserService mUserService;

    public static final String TAG = PostActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        final EditText titleEt = (EditText) findViewById(R.id.et_title);
        final EditText bodyEt = (EditText) findViewById(R.id.et_body);

        Button submitBtn = (Button) findViewById(R.id.btn_submit);
        mResponseTv = (TextView) findViewById(R.id.tv_response);

        mUserService = NetworkUtils.getUserService();

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEt.getText().toString().trim();
                String body = bodyEt.getText().toString().trim();
                if (!TextUtils.isEmpty(title) && !TextUtils.isEmpty(body)){
                    sendPost(title, body);
                }
            }
        });
    }

    private void sendPost(String title, String body) {
        mUserService.savePost(title, body, 1).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User user) {
                        showResponse(user.toString());
                        Log.i(TAG, "post submitted " + user.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.e(TAG, "Unable to submit post");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void showResponse(String toString) {
        if (mResponseTv.getVisibility() == View.GONE){
            mResponseTv.setVisibility(View.VISIBLE);
        }
        mResponseTv.setText(toString);
    }
}
