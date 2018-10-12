package com.portfolio.jeung.webapplinkpage;

import android.content.Context;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HybridApp extends AppCompatActivity {
private WebView webView;
//WebViwClient 클래스 생성
    //리다이렉트 하는 URL이 왔을 때 처리를 위한 클래스
    class WebCustomClient extends WebViewClient{
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
        return false;
    }
}

class AndroidJavaScriptInterface{
        //토스트 출력을 위해서 생성( 토스트는 액티비티가 있어야 하기 때문에)
        private Context context;
        //핸들러 생성
    private Handler handler = new Handler();
    //생성자
    public AndroidJavaScriptInterface(Context context){
        this.context = context;
    }
    //자바스크립트가 호출할 수 있는 메소드를 셍성하는 어노테이션 (매개변수 라이널 이유는 웹에서 넘어온거라 고칠 수 없어서 파이널러 해준것)
    @JavascriptInterface
    public void showToastMessage(final String message){
        handler.post(new Runnable(){
            public void run() {
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
            }
        });
    }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hybrid_app);

        final WebView webView = (WebView)findViewById(R.id.webView);
        //리다이렉트를 웹 뷰에서 처리하기 위한 설정
        webView.setWebViewClient(new WebCustomClient());
        //웹뷰 안에서 자바스크립트 함수를 사용할 수 있도록 하는 설정
        webView.getSettings().setJavaScriptEnabled(true);
        //자바스크립트에서 네이티브 메소드를 호출할 수 있도록 설정
        //1번 매개변수 : 메소드의 위치를 알려주는 것이고
        //2번 매개변수 : html에서 호출할 때 사용할 인스턴스 이름
        webView.addJavascriptInterface(new AndroidJavaScriptInterface(this),"MYAPP");
        //url 로딩
        webView.loadUrl("http://192.168.0.215:8080/jeung/hybridapp");
        //버튼 클릭이벤트 처리
        Button sendmsg = (Button)findViewById(R.id.sendmsg);
        sendmsg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                EditText message = (EditText)findViewById(R.id.message);
                //자바스크립트 함수 호출
                webView.loadUrl("javascript:showDisplayMessage('"+message.getText().toString()+"')");
            }
        });
    }
}
