package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class VendorOneSpinner extends ArrayAdapter<String> {
    private Context context;
    private String[] values;
    private String title;

    public VendorOneSpinner(Context context, int textViewResourceId, String[] values, String title) {
        super(context, textViewResourceId, values);
        this.context = context;
        this.values = values;
        this.title = title;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(title);
        // 设置 TextView 的样式，例如文字大小、颜色等（根据需要调整）
        // 例如：label.setTextSize(16); label.setTextColor(Color.BLACK);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(values[position]);
        // 设置下拉列表中的项的样式
        return label;
    }
}
