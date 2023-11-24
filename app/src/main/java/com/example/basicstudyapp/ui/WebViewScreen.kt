package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.basicstudyapp.R

class WebViewScreen : Fragment() {
    private var webView: WebView? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.base_web_view, container, false)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        webView = view.findViewById<WebView>(R.id.web_view)

        webViewSet("https://www.google.com")
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSet(url: String) {
        webView?.apply {
            val webSettings: WebSettings = settings
            webSettings.javaScriptEnabled = true // JavaScriptを有効にする
            webChromeClient = WebChromeClient() // WebViewのクライアントを設定（オプション）
            loadUrl(url)// URLを読み込む
        }
    }
}
