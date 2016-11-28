package io.github.staray.verticalscrolltextview;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.staray.library.VerticalScrollTextView;

public class MainActivity extends AppCompatActivity {

    private VerticalScrollTextView tv;
    private List<String> info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (VerticalScrollTextView) findViewById(R.id.scroll_tv);
        info = new ArrayList<>();

        init();

        tv.setList(info);

        tv.setOnItemClickListener(new VerticalScrollTextView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void init() {
        info.add("诺基亚概念机亮相：侧滑键盘美哭...\n高画质游戏仅入门，还能Hold住VR");
        info.add("新品推荐：爆款耳机特价销售...\nGTX 1060性能评测，对比GTX 970...");
        info.add("全球显卡姓名排行：AMD第一英特尔...\n神奇动物在哪里值得一看");
    }

    @Override
    protected void onResume() {
        super.onResume();
        tv.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        tv.stop();
    }
}
