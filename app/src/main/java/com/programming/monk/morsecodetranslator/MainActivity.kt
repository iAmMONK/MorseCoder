package com.programming.monk.morsecodetranslator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.gms.ads.AdRequest
import com.programming.monk.morsecodetranslator.databinding.MainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: MainBinding
    private val viewModel by viewModels<MainActivityViewModel> { MainActivityViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        binding.copyButton.setOnClickListener {
            (getSystemService(CLIPBOARD_SERVICE) as? ClipboardManager)?.let {
                it.setPrimaryClip(ClipData.newPlainText("Message", binding.messageOutput.text))
                Toast.makeText(applicationContext, R.string.copied_to_clipboard_message, Toast.LENGTH_SHORT).show()
            }
        }

        binding.deleteButton.setOnClickListener {
            binding.messageInput.text = null
        }

        binding.shareButton.setOnClickListener {
            if (binding.messageOutput.text.isNotBlank()) {
                val sendIntent = Intent()
                sendIntent.action = Intent.ACTION_SEND
                sendIntent.putExtra(Intent.EXTRA_TEXT, binding.messageOutput.text)
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
                it.setPrimaryClip(ClipData.newPlainText("Message", binding.messageOutput.text))
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
            viewModel.onModeSwitched(binding.messageInput.text.toString())
        }

        binding.messageInput.doOnTextChanged { text, _, _, _ ->
            viewModel.onInputTextChanged(text.toString())
        }

        binding.adView.loadAd(AdRequest.Builder().build())

        subscribeUi()
    }

    private fun subscribeUi() {
        viewModel.output.observe(this) {
            binding.messageOutput.text = it
        }

        viewModel.outputHasSpacing.observe(this) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                binding.messageInput.letterSpacing = if(it) 0f else .3f
                binding.messageOutput.letterSpacing = if (it) .3f else 0f
            }
        }
    }
}