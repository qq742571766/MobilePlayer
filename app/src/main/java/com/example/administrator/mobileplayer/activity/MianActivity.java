package com.example.administrator.mobileplayer.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.administrator.mobileplayer.R;
import com.example.administrator.mobileplayer.base.BaseFragment;
import com.example.administrator.mobileplayer.base.BasePager;
import com.example.administrator.mobileplayer.pager.AudioPager;
import com.example.administrator.mobileplayer.pager.NetAudioPager;
import com.example.administrator.mobileplayer.pager.NetVideoPager;
import com.example.administrator.mobileplayer.pager.VideoPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MianActivity extends FragmentActivity {
    RadioGroup rg_bottem_tag;
    private ArrayList<BasePager> basePagers;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg_bottem_tag = (RadioGroup) findViewById(R.id.rg_bottem_tag);

        basePagers = new ArrayList<>();
        basePagers.add(new VideoPager(this));
        basePagers.add(new AudioPager(this));
        basePagers.add(new NetVideoPager(this));
        basePagers.add(new NetAudioPager(this));

        rg_bottem_tag.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        rg_bottem_tag.check(R.id.rb_video);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                default:
                    position = 0;
                    break;
                case R.id.rb_audio://音频
                    position = 1;
                    break;
                case R.id.rb_net_video://网络视频
                    position = 2;
                    break;
                case R.id.rb_net_audio://网络音频
                    position = 3;
                    break;
            }
            setFragment();
        }
    }
    private void setFragment() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();
        ft.replace(R.id.fl_main_content, new BaseFragment(position,basePagers));
        ft.commit();
    }
}
