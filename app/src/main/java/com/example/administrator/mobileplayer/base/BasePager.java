package com.example.administrator.mobileplayer.base;

import android.content.Context;
import android.view.View;

public abstract class BasePager {
    public Context context;
    public View rootview;

    public BasePager(Context context) {
        this.context = context;
        rootview = initview();
    }

    public abstract View initview();

    public void initDate() {
    }
}
