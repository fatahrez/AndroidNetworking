package com.lukmo.retrofitpractise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class MainActivity extends AppCompatActivity implements UserContract.View{
    private UserContract.Presenter mPresenter;
    private RecyclerView recyclerView;
    CustomAdapter adapter;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new UserPresenter(this);
        mPresenter.start();
    }

    @Override
    public void init() {
        recyclerView= findViewById(R.id.recydler_view);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        mPresenter.loadUsers();

        mButton = (Button) findViewById(R.id.post_activity_button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void loadDataInList(List<User> users) {
        adapter = new CustomAdapter(users);
        recyclerView.setAdapter(adapter);
    }
}
