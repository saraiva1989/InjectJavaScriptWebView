package com.example.danielsaraiva1.injectjavascriptwebview

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        webView.loadUrl("https://www.catarse.me/sign_up")

            btInjection.setOnClickListener{
                injectJavaScript(webView)
            }

        webView.webViewClient = WebViewClt(this)
    }

    fun injectJavaScript(webView: WebView){
        webView.evaluateJavascript("javascript:  " +
                "var email= document.getElementById('user_email'); " +
                "email.value = 'test'; " +
                "email.dispatchEvent(new Event('input')) ", null)
    }
}
