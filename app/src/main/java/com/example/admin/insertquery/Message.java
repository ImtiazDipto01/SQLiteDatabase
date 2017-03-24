package com.example.admin.insertquery;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Admin on 3/18/2017.
 */

public class Message {

    public static void message(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
