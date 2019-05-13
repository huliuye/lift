package com.leparts.liftdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.leparts.lift.helper.OnTokenExpiredListener;
import com.leparts.lift.network.RetrofitHelper;
import com.leparts.lift.view.property.PropertyEntranceActivity;
import com.leparts.lift.view.user.UserEntranceActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView u = findViewById(R.id.user);
        TextView p = findViewById(R.id.property);
        RetrofitHelper helper = RetrofitHelper.newInstance("ecda4a7d3672b3bb23081b7848ba3c6a");
        helper.setOnTokenExpiredListener(() -> {
            //TODO: 获取新token
            helper.resetToken("");
        });
        u.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserEntranceActivity.class);
            intent.putExtra("liftNumber", "31010600970,31010600971");
            startActivity(intent);
        });
        p.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, PropertyEntranceActivity.class);
            startActivity(intent);
        });
    }
}
