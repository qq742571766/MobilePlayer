package com.example.administrator.mobileplayer.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/4/20.
 */

public class BaseFragment extends Fragment {
    private int position;
    private ArrayList<BasePager> basePagers;

    public BaseFragment(int position, ArrayList<BasePager> basePagers) {
        this.basePagers = basePagers;
        this.position = position;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        BasePager basePager = getBasePager();
        if (basePager != null) {
            return basePager.rootview;
        }
        return null;
    }

    private BasePager getBasePager() {
        BasePager basePager = basePagers.get(position);
        if (basePager != null) {
            basePager.initDate();
        }
        return basePager;
    }
}
