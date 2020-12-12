package com.programming.monk.morsecodetranslator

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.programming.monk.morsecodetranslator.databinding.MainBinding
import com.programming.monk.morsecodetranslator.operations.MorseCoder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainBinding

    private val morseCoder = MorseCoder()
    private var operationValue = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.copyButton.setOnClickListener {
            (getSystemService(CLIPBOARD_SERVICE) as? ClipboardManager)?.let {
                it.setPrimaryClip(ClipData.newPlainText("Message", morseCoder.codedMessage))
                Toast.makeText(applicationContext, R.string.copied_to_clipboard_message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.shareButton.setOnClickListener {
            if (morseCoder.codedMessage != "") {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, morseCoder.codedMessage)
                sendIntent.type = "text/plain"
                startActivity(Intent.createChooser(sendIntent, getString(R.string.share_with_title)))
            } else Toast.makeText(this, R.string.share_empty, Toast.LENGTH_SHORT).show()
        }

        binding.inputCard.setOnClickListener {
            binding.messageInput.requestFocus()
            binding.messageInput.post {
                (getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager)
                        .toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
            }
        }

        binding.outputCard.setOnClickListener {
            (getSystemService(CLIPBOARD_SERVICE) as? ClipboardManager)?.let {
                it.setPrimaryClip(ClipData.newPlainText("Message", morseCoder.codedMessage))
                Toast.makeText(applicationContext, R.string.copied_to_clipboard_message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.translationCard.setOnClickListener {
            binding.translationWayImage.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.rotate_swap).apply {
                interpolator = AccelerateDecelerateInterpolator()
            })

            val holder = binding.inputLabel.text
            binding.inputLabel.text = binding.outputLabel.text
            binding.outputLabel.text = holder
        }

        binding.adView.loadAd(AdRequest.Builder().build())
    }
}