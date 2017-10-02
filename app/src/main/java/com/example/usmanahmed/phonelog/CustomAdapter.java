package com.example.usmanahmed.phonelog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Usman Ahmed on 02/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<user>
{
    class ViewHolder{
        TextView fullname;
        TextView no;
        TextView gender;
    }
    CustomAdapter(Context context, List arrayList){
        super(context, 0,arrayList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup p) {
        user u= (user) getItem(position);
        ViewHolder vh;
        View view=convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.contact, p, false);
            TextView fullname=(TextView) view.findViewById(R.id.fullname);
            TextView no=(TextView) view.findViewById(R.id.no);
            TextView gender=(TextView) view.findViewById(R.id.gender);
            vh=new ViewHolder();
            vh.fullname=fullname;
            vh.no=no;
            vh.gender=gender;
            view.setTag(vh);
        }

            vh=(ViewHolder) view.getTag();

        vh.fullname.setText(u.fullname);
        vh.no.setText(u.no);
        vh.gender.setText(u.gender);

        return view;
    }
}
