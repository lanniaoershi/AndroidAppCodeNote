package com.example.utopia.activitytemplate;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.utopia.activitytemplate.datastorage.DataTestActivity;
import com.example.utopia.activitytemplate.master_detail_flow.ItemListActivity;

public class EmptyActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
        findViewById(R.id.btn_blank_activity).setOnClickListener(this);
        findViewById(R.id.btn_fullscreen_activity).setOnClickListener(this);
        findViewById(R.id.btn_login_activity).setOnClickListener(this);
        findViewById(R.id.btn_navi_activity).setOnClickListener(this);
        findViewById(R.id.btn_scrolling_activity).setOnClickListener(this);
        findViewById(R.id.btn_setting_activity).setOnClickListener(this);
        findViewById(R.id.btn_tabbed_activity).setOnClickListener(this);
        findViewById(R.id.btn_master_flow_activity).setOnClickListener(this);
        findViewById(R.id.btn_data_test_activity).setOnClickListener(this);
        findViewById(R.id.btn_google_host).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        Intent intent;
        switch (id) {
            case R.id.btn_blank_activity:
                intent = new Intent(EmptyActivity.this, BlankActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_fullscreen_activity:
                intent = new Intent(EmptyActivity.this, FullscreenActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login_activity:
                intent = new Intent(EmptyActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_navi_activity:
                intent = new Intent(EmptyActivity.this, NavigationDrawerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_scrolling_activity:
                intent = new Intent(EmptyActivity.this, ScrollingActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_setting_activity:
                intent = new Intent(EmptyActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_tabbed_activity:
                intent = new Intent(EmptyActivity.this, TabbedActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_master_flow_activity:
                intent = new Intent(EmptyActivity.this, ItemListActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_data_test_activity:
                intent = new Intent(EmptyActivity.this, DataTestActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_google_host:
                intent = new Intent(EmptyActivity.this, GoogleHostActivity.class);
                startActivity(intent);
                break;
        }
    }
}
