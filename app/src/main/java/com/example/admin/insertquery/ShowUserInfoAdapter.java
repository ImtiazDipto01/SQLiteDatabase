package com.example.admin.insertquery;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 3/24/2017.
 */

public class ShowUserInfoAdapter extends ArrayAdapter {

    List list = new ArrayList() ;

    public ShowUserInfoAdapter(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }

    static class LayoutHandler{
       TextView name, pass ;

    }

    @Override
    public void add(@Nullable Object object) {
        super.add(object);
        list.add(object) ;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Nullable
    @Override
    public Object getItem(int position) {
        return list.get(position) ;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView ;
        LayoutHandler layoutHandler ;
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;
            view = layoutInflater.inflate(R.layout.user_info_row, parent, false) ;
            layoutHandler = new LayoutHandler() ;
            layoutHandler.name = (TextView) view.findViewById(R.id.username) ;
            layoutHandler.pass = (TextView) view.findViewById(R.id.password) ;
            view.setTag(layoutHandler);
        }
        else{

            layoutHandler = (LayoutHandler) view.getTag() ;
        }
        DataProvider dataProvider = (DataProvider) this.getItem(position) ;
        layoutHandler.name.setText(dataProvider.getName());
        layoutHandler.pass.setText(dataProvider.getPassword());

        return view;
    }
}
