package com.example.binoy1001;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    String[] titles;
    String[] subTitles;
    int[] images;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, String[] titles, String[] subTitles, int[] images) {
        this.context = context;
        this.titles = titles;
        this.subTitles = subTitles;
        this.images = images;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.custom_listview, null);
        }
        ImageView image = convertView.findViewById(R.id.list_image);
        TextView title = convertView.findViewById(R.id.list_title);
        TextView subTitle = convertView.findViewById(R.id.list_subtitle);
        title.setText(titles[position]);
        subTitle.setText(subTitles[position]);
        image.setImageResource(images[position]);
        return convertView;
    }
}
