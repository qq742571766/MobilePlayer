package com.example.administrator.mobileplayer.pager;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.mobileplayer.base.BasePager;

/**
 * Created by Administrator on 2017/4/19.
 */

public class VideoPager extends BasePager {

    private TextView textView;

    public VideoPager(Context context) {
        super(context);
    }

    @Override
    public View initview() {
        textView = new TextView(context);

        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    public void initDate() {
        super.initDate();textView.setText("本地视频");
    }
}
