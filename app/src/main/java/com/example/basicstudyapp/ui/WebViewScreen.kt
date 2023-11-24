package com.example.basicstudyapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import androidx.fragment.app.Fragment
import com.example.basicstudyapp.databinding.ScreenWebViewBinding

class WebViewScreen : Fragment() {

    private var _binding: ScreenWebViewBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ScreenWebViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webViewSet("https://www.google.com")
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSet(url: String) {
        binding.webView.apply {
            val webSettings: WebSettings = settings
            webSettings.javaScriptEnabled = true // JavaScriptを有効にする
            webChromeClient = WebChromeClient() // WebViewのクライアントを設定（オプション）
            loadUrl(url)// URLを読み込む
        }
    }
}
