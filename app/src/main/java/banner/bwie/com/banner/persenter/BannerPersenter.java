package banner.bwie.com.banner.persenter;

import android.content.Context;

import com.google.gson.Gson;

import java.io.IOException;

import banner.bwie.com.banner.bean.Bean;
import banner.bwie.com.banner.model.BannerModel;
import banner.bwie.com.banner.okhttp.OnUiCallback;
import banner.bwie.com.banner.view.BannerView;
import okhttp3.Call;

/**
 * Created by CZ on 2017/12/2.
 */
public class BannerPersenter {
    BannerView view;
    Context context;
    private final BannerModel model;

    public BannerPersenter(BannerView view, Context context) {
        this.view = view;
        this.context = context;
        model = new BannerModel();
    }

    public void get() {
        model.getData(new OnUiCallback() {
            @Override
            public void onFailed(Call call, IOException e) {
                if (view != null) {
                    view.fail(e);
                }
            }

            @Override
            public void onSuccess(String result) {
                    Gson gson = new Gson();
                    Bean bean = gson.fromJson(result, Bean.class);
                    view.success(bean);

            }
        });
    }

    public void sds() {
        this.view = null;
    }
}
