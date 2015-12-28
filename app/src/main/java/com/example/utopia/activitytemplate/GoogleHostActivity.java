package com.example.utopia.activitytemplate;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class GoogleHostActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView mDefaultHosts, mYourHosts, mNewHosts, mTextPath;
    private Button mBtnChoose, mBtnReplace;
    private static final String HOSTS_FILE_PATH = "/etc/hosts";
    private String yourHostFilePath = "";
    private ProgressBar mProgressBar;

    private Intent mIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_host);


        mDefaultHosts = (TextView) findViewById(R.id.text_default_host);
        mYourHosts = (TextView) findViewById(R.id.text_your_host);
        mNewHosts = (TextView) findViewById(R.id.text_new_host);
        mBtnChoose = (Button) findViewById(R.id.btn_choose);
        mBtnReplace = (Button) findViewById(R.id.btn_replace);
        mTextPath = (TextView) findViewById(R.id.text_path);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mBtnChoose.setOnClickListener(this);
        mBtnReplace.setOnClickListener(this);

        mIntent = new Intent(Intent.ACTION_GET_CONTENT);
        mIntent.setType("*/*");

        mDefaultHosts.setText("Default content: \n"+readHostsFile(HOSTS_FILE_PATH));


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (data != null) {
            Uri uri = data.getData();
            mTextPath.setText(uri.getPath());
            yourHostFilePath = uri.getPath();
            new ReadFileAtBackground().execute(yourHostFilePath);
        }
    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.btn_choose:
                startActivityForResult(mIntent,1,null);
                break;
            case R.id.btn_replace:
                new WriteFileAtBackground().execute();
//                new ReadFileAtBackground1().execute();
                break;
        }
    }

    private String readHostsFile(String path) {
        String content = "";

        try {
            File file = new File(path);
            FileInputStream input = new FileInputStream(file);
            int length = input.available();
            byte buffer[] = new byte[length];
            input.read(buffer);


            content = new String(buffer,"UTF-8");

        } catch (IOException e) {
            e.printStackTrace();
        }


        return content;
    }

    private void writeHostsFile() {
//        try {
//            File file = new File(HOSTS_FILE_PATH);
//            FileOutputStream output = new FileOutputStream(file);
//
//            File fileInput = new File(yourHostFilePath);
//            FileInputStream inputStream = new FileInputStream(fileInput);
//            int length = inputStream.available();
//            byte buffer[] = new byte[length];
//            inputStream.read(buffer);
//
//            output.write(buffer);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            final String cmd = "cat /storage/emulated/legacy/hosts-20151219.txt >> "+HOSTS_FILE_PATH;
            Runtime.getRuntime().exec(cmd);

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mDefaultHosts.setText(cmd);
                }
            });
            Log.i("mylog",cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReadFileAtBackground extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            result = readHostsFile(params[0]);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {

            mYourHosts.setText("Part of content:\n" + s.substring(0, 500) + "\n...");
        }
    }

    private class ReadFileAtBackground1 extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String result = "";
            result = readHostsFile(HOSTS_FILE_PATH);
            return result;
        }

        @Override
        protected void onPostExecute(String s) {

            mNewHosts.setText("Done:\n"+s+"\n...");
        }
    }

    private class WriteFileAtBackground extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... params) {
            writeHostsFile();
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            new ReadFileAtBackground1().execute(HOSTS_FILE_PATH);
        }
    }
}
