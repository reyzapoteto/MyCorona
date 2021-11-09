package com.coronaapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.coronaapp.databinding.ActivityNewsBinding
import android.webkit.WebResourceError

import android.webkit.WebResourceRequest

import android.annotation.TargetApi
import android.view.View
import android.webkit.WebView

import android.widget.Toast

import android.webkit.WebViewClient


class NewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsBinding

    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent
        val url = intent.getStringExtra("url")


        binding.imbtnBack.setOnClickListener {
            super.onBackPressed()
        }


        binding.webNews.settings.loadWithOverviewMode = true;
        binding.webNews.settings.setSupportZoom(true);
        binding.webNews.settings.javaScriptEnabled = true;

        binding.progNews.visibility = View.VISIBLE


        binding.webNews.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                errorCode: Int,
                description: String?,
                failingUrl: String?
            ) {
                binding.progNews.visibility = View.INVISIBLE
                Toast.makeText(this@NewsActivity, description, Toast.LENGTH_SHORT).show()
            }

            @TargetApi(Build.VERSION_CODES.M)
            override fun onReceivedError(
                view: WebView?,
                req: WebResourceRequest,
                rerr: WebResourceError
            ) {
                binding.progNews.visibility = View.INVISIBLE
                // Redirect to deprecated method, so you can use it in all SDK versions
                onReceivedError(
                    view,
                    rerr.errorCode,
                    rerr.description.toString(),
                    req.url.toString()
                )
            }
        }

        binding.webNews.loadUrl(url.toString())
        binding.progNews.visibility = View.INVISIBLE
    }
}