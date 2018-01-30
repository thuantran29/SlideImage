package com.trannguyentanthuan2903.slideimage;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private ViewPager vp;
    private ImageView left, right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        left = (ImageView) findViewById(R.id.left);
        right = (ImageView) findViewById(R.id.right);
        ArrayList<String> mArray = new ArrayList<>();
        mArray.addAll(getData());
        ImageAdapter adapter = new ImageAdapter(getApplicationContext(), mArray);
        vp = (ViewPager) findViewById(R.id.vp_image);
        vp.setCurrentItem(0);
        vp.setAdapter(adapter);
        left.setOnClickListener(this);
        right.setOnClickListener(this);

    }

    private static List<String> getData() {
        ArrayList<String> list = new ArrayList<>();
        list.add("https://orig00.deviantart.net/98b2/f/2013/251/e/e/naruto___manga_645_by_melonciutus-d6lhdmt.png");
        list.add("https://vignette.wikia.nocookie.net/youtubepoop/images/e/ea/Naruto.png/revision/latest?cb=20150422212156");
        list.add("https://img00.deviantart.net/5a07/i/2017/120/e/9/son_goku_super_saiyan_blue_kaioken_by_rmehedi-db7nexa.png");
        return list;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private int getItem(int i) {
        return vp.getCurrentItem() + i;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left:
                vp.setCurrentItem(getItem(-1), true);
                break;
            case R.id.right:
                vp.setCurrentItem(getItem(+1), true);
                break;
            default:
                break;
        }
    }
}
