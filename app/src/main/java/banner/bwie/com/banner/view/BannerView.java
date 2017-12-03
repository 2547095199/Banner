package banner.bwie.com.banner.view;

import banner.bwie.com.banner.bean.Bean;

/**
 * Created by CZ on 2017/12/2.
 */
public interface BannerView {
    public void success(Bean bean);

    public void fail(Exception e);
}
