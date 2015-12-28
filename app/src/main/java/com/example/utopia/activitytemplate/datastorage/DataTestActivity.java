package com.example.utopia.activitytemplate.datastorage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.utopia.activitytemplate.R;
import com.example.utopia.activitytemplate.datastorage.file.FileUtil;
import com.example.utopia.activitytemplate.datastorage.sharepreferences.SharePreferencesUtil;
import com.example.utopia.activitytemplate.datastorage.sqlite.SQLiteUtil;

public class DataTestActivity extends AppCompatActivity implements View.OnClickListener{

    EditText editText;
    TextView textView;
    Button btnSaveFile, btnReadFile, btnSaveSharePre, btnReadSharePre, btnSaveDB, btnReadDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_test);

        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_view);

        btnReadFile = (Button) findViewById(R.id.btn_read_from_file);
        btnSaveFile = (Button) findViewById(R.id.btn_save2file);
        btnSaveSharePre = (Button) findViewById(R.id.btn_save2share_pre);
        btnReadSharePre = (Button) findViewById(R.id.btn_read_from_share_pre);
        btnSaveDB = (Button) findViewById(R.id.btn_save2DB);
        btnReadDB = (Button) findViewById(R.id.btn_read_from_DB);

        editText.setOnClickListener(this);
        textView.setOnClickListener(this);
        btnSaveFile.setOnClickListener(this);
        btnReadFile.setOnClickListener(this);
        btnSaveSharePre.setOnClickListener(this);
        btnReadSharePre.setOnClickListener(this);
        btnSaveDB.setOnClickListener(this);
        btnReadDB.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.edit_text:
                    break;
            case R.id.text_view:
                    break;
            case R.id.btn_save2file:
                FileUtil.saveStr2file(this, editText.getText().toString());
                break;
            case R.id.btn_read_from_file:
                textView.setText(FileUtil.readFromFile(this));
                break;
            case R.id.btn_save2share_pre:
                SharePreferencesUtil.save2XML(this, editText.getText().toString());
                break;
            case R.id.btn_read_from_share_pre:
                textView.setText(SharePreferencesUtil.readFromXML(this));
                break;
            case R.id.btn_save2DB:
                SQLiteUtil.save2SQLite(this);
                break;
            case R.id.btn_read_from_DB:

                break;
            default:
                return;
        }

    }
}
