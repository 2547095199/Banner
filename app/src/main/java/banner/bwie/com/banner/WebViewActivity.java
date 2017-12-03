package banner.bwie.com.banner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.w);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);

        Intent intent = getIntent();

        String url = intent.getStringExtra("url");
        webView.loadUrl(url);

    }
}
