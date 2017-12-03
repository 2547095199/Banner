package banner.bwie.com.banner.model;

import banner.bwie.com.banner.okhttp.OkHttp3Utils;
import okhttp3.Callback;

/**
 * Created by CZ on 2017/12/2.
 */
public class BannerModel {
    public void getData(Callback callback) {
        OkHttp3Utils.doGet("http://120.27.23.105/ad/getAd", callback);
    }
}
