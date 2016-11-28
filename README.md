# 垂直滚动文字显示控件

---

类似淘宝的垂直滚动文字广告条，效果如下：

![](https://raw.githubusercontent.com/Staray/VerticalScrollTextView/master/Images/demo.gif)

## 引用：
Step 1. 在你的root build.gradle中添加：

    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Setp 2. 在你的项目build.gradle中添加：

    dependencies {
        compile 'com.github.Staray:VerticalScrollTextView:v1.0.1'
	}

## 使用方法

在布局文件中引用控件：

     <io.github.staray.library.VerticalScrollTextView
                    android:id="@+id/scroll_tv"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:layout_marginLeft="10dp"
                    android:layout_marginStart="10dp"
                    android:background="#ffffff"
                    app:verticalScrollPeriod="2000"
                    app:verticalScrollTextColor="#333333"
                    app:verticalScrollTextSize="14sp"/>

其中"verticalScrollPeriod"指文字显示时长。
对应的java方法：

    setPeriod(int period)

"verticalScrollTextColor"指文字颜色。
"verticalScrollTextSize"指文字大小。

在java文件中：
初始化控件：

    VerticalScrollTextView tv = (VerticalScrollTextView) findViewById(R.id.scroll_tv);
    

定义需要显示的文字List

    List<String> info = new ArrayList<>();
    info.add("诺基亚概念机亮相：侧滑键盘美哭...\n高画质游戏仅入门，还能Hold住VR");
    info.add("新品推荐：爆款耳机特价销售...\nGTX 1060性能评测，对比GTX 970...");
    info.add("全球显卡姓名排行：AMD第一英特尔...\n神奇动物在哪里值得一看");

然后设置控件内容：

    tv.setList(info);

可以添加点击事件：

    tv.setOnItemClickListener(new VerticalScrollTextView.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
            }
        });

然后覆写OnResume方法，启动文字滚动显示：

    @Override
    protected void onResume() {
        super.onResume();
        tv.start();
    }

覆写OnPause方法，停止文字滚动：

    @Override
    protected void onPause() {
        super.onPause();
        tv.stop();
    }

注意：
一定要先初始化控件，并设置显示内容，再调用start()方法。