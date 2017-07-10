package com.example.devin.devin_seekbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /**
     * 시크바를 담고 있는 레이아웃 객체
     */
    private View panel;

    /**
     * 시크바 객체
     */
    private SeekBar seekbar;

    /**
     * 텍스트뷰
     */
    private TextView text01;

    /**
     * 화면밝기 값
     */
    private int brightness = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 레이아웃에 정의된 객체 참조
        panel = findViewById(R.id.panel01);
        text01 = (TextView) findViewById(R.id.text01);
        seekbar = (SeekBar) findViewById(R.id.seekbar01);

        // 버튼 이벤트 처리
        Button showBtn = (Button) findViewById(R.id.showBtn);
        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPanel();
            }
        });

        seekbar.setOnSeekBarChangeListener(new MyOnSeekBarChangeListener());
    }

    private void showPanel() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        seekbar.setProgress(this.brightness);
        panel.setVisibility(View.VISIBLE);
        panel.startAnimation(animation);
    }


    private void hidePanel() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_right);
        panel.startAnimation(animation);
        panel.setVisibility(View.GONE);
    }



    class MyOnSeekBarChangeListener implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            if (i < 30) {
                text01.setText("밝기 수준 : 하");
            }else if (i < 70) {
                text01.setText("밝기 수준 : 중");
            }else {
                text01.setText("밝기 수준 : 상");
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            int i = seekBar.getProgress();

            if (i < 30) {
                seekBar.setProgress(0);
            } else if (i < 70) {
                seekBar.setProgress(50);
            } else {
                seekBar.setProgress(100);
            }
        }
    }


}
