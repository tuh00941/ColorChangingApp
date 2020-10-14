package edu.temple.colorchangingapp;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;

public class ColorAdapter extends BaseAdapter {

    final Context context;
    final ArrayList<String> colors;
    final ArrayList<String> englishColors;

    public ColorAdapter(Context context, ArrayList<String> colors) {
        this.context = context;
        this.colors = colors;
        this.englishColors = new ArrayList<>();

        Configuration conf = context.getResources().getConfiguration();
        conf = new Configuration(conf);
        conf.setLocale(Locale.ENGLISH);
        Context localizedContext = context.createConfigurationContext(conf);
        Resources res = localizedContext.getResources();
        String[] colores = res.getStringArray(R.array.colors);

        Collections.addAll(englishColors, colores);
    }

    @Override
    public int getCount() {
        return colors.size();
    }

    @Override
    public Object getItem(int position) {
        return colors.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView = new TextView(context);
        textView.setText(getItem(position).toString());

        textView.setBackgroundColor(Color.parseColor(englishColors.get(position)));

        return textView;
    }
}