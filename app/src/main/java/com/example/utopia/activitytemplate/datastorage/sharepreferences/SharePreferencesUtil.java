package com.example.utopia.activitytemplate.datastorage.sharepreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by weiwei on 11/10/15.
 */
public class SharePreferencesUtil {

    public static void save2XML(Context context, String other) {
        SharedPreferences.Editor editor = context.getSharedPreferences("data", Context.MODE_PRIVATE).edit();
        editor.putString("name", "Lily");
        editor.putInt("age", 21);
        editor.putBoolean("married", false);
        editor.putString("other", other);
        editor.commit();
    }

    public static String readFromXML(Context context) {
        StringBuilder content = new StringBuilder();
        SharedPreferences pref = context.getSharedPreferences("data", Context.MODE_PRIVATE);
        content.append(pref.getString("name","")).append(pref.getInt("age",0)).append(pref.getBoolean("married", false)).append(pref.getString("other", "null"));
        return content.toString();
    }

}
