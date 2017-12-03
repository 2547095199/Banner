package banner.bwie.com.banner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import banner.bwie.com.banner.bean.Bean;
import banner.bwie.com.banner.persenter.BannerPersenter;
import banner.bwie.com.banner.view.BannerView;

public class MainActivity extends AppCompatActivity implements BannerView {


    BannerPersenter persenter = new BannerPersenter(this, this);
    List<Integer> list = new ArrayList<>();
    private Banner banner;
    private List<String> imageArray;
    private List<String> imageTitle;
    List<Bean.DataBean> bean = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        banner = (Banner) findViewById(R.id.banner);
        persenter.get();

    }


    @Override
    public void success(final Bean bean) {
        Toast.makeText(MainActivity.this, bean.getData().get(0).getIcon(), Toast.LENGTH_SHORT).show();
//        list.add(R.mipmap.ic_launcher);
//        list.add(R.mipmap.ic_launcher);
//        list.add(R.mipmap.ic_launcher);
//        list.add(R.mipmap.ic_launcher);

        imageArray = new ArrayList<>();
        imageArray.add(bean.getData().get(0).getIcon());
        imageArray.add(bean.getData().get(1).getIcon());
        imageArray.add(bean.getData().get(2).getIcon());
        imageArray.add(bean.getData().get(3).getIcon());

        imageTitle = new ArrayList<>();
        imageTitle.add(bean.getData().get(0).getTitle());
        imageTitle.add(bean.getData().get(1).getTitle());
        imageTitle.add(bean.getData().get(2).getTitle());
        imageTitle.add(bean.getData().get(3).getTitle());

        banner = (Banner) findViewById(R.id.banner);
        //设置banner样式
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(imageArray);
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.RotateDown);
        //设置标题集合（当banner样式有显示title时）
        banner.setBannerTitles(imageTitle);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();


        banner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                Toast.makeText(MainActivity.this, "我要跳转到商品详情页", Toast.LENGTH_SHORT).show();

                for (int i = 0; i < bean.getData().size(); i++) {
                    if (bean.getData().get(i).getType() == 0) {
                        Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                        intent.putExtra("url", bean.getData().get(i).getUrl());
                        startActivity(intent);
                    } else if (bean.getData().get(i).getType() == 1) {
                        Toast.makeText(MainActivity.this, "我要跳转到商品详情页", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public void fail(Exception e) {
        Toast.makeText(MainActivity.this, "错误", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        persenter.sds();
    }
}
