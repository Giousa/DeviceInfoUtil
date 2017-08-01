package com.zmm.widthandheight;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {


    @InjectView(R.id.tv_width)
    TextView mTvWidth;
    @InjectView(R.id.tv_height)
    TextView mTvHeight;
    @InjectView(R.id.tv_rom)
    TextView mTvRom;
    @InjectView(R.id.tv_rom_avail)
    TextView mTvRomAvail;
    @InjectView(R.id.tv_ram)
    TextView mTvRam;
    @InjectView(R.id.tv_ram_avail)
    TextView mTvRamAvail;
    @InjectView(R.id.tv_cpu)
    TextView mTvCpu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        init();
    }

    private void init() {

        int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        int screenHeight = getWindowManager().getDefaultDisplay().getHeight();

        mTvWidth.setText("分辨率：宽 " + screenWidth);
        mTvHeight.setText("分辨率：高 " + screenHeight);


        mTvRam.setText("RAM(内存)：" + DeviceInfoUtils.getTotalRam());
        mTvRamAvail.setText("剩余RAM(内存)：" + DeviceInfoUtils.getAvailableRam(this)+"M");
        mTvRom.setText("ROM：" + DeviceInfoUtils.getTotalROM()+"M");
        mTvRomAvail.setText("剩余ROM：" + DeviceInfoUtils.getAvailableROM()+"M");
        mTvCpu.setText("CPU核心数：" + DeviceInfoUtils.getNumCores());

    }

    public void getScreenDensity_ByWindowManager(){
        DisplayMetrics mDisplayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mDisplayMetrics);
        int width = mDisplayMetrics.widthPixels;
        int height = mDisplayMetrics.heightPixels;
        float density = mDisplayMetrics.density;
        int densityDpi = mDisplayMetrics.densityDpi;
        System.out.println("Screen Ratio: ["+width+"x"+height+"],density="+density+",densityDpi="+densityDpi);
        System.out.println("Screen mDisplayMetrics: "+mDisplayMetrics);
    }
}
