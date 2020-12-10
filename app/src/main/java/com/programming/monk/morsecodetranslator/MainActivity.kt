package com.programming.monk.morsecodetranslator

import android.app.AlertDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.programming.monk.morsecodetranslator.operations.MorseCoder
import kotlinx.android.synthetic.main.main.*

class MainActivity : AppCompatActivity() {
    private val morseCoder = MorseCoder()
    private var alertVisibility = false
    private var operationValue = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
//        setSupportActionBar(toolbar)
//
//        ibSwap.setOnClickListener(this)
//        btnCopy.setOnClickListener(this)
//        btnCodeIt.setOnClickListener(this)
//        ibAlert.setOnClickListener(this)

//        val adRequest = AdRequest.Builder().build()
//        adView.loadAd(adRequest)
    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val i: Intent
//        when (item.itemId) {
//            R.id.tbMorseCode -> {
//                i = Intent(this, MorsecodePage::class.java)
//                startActivity(i)
//            }
//            R.id.tbAbout -> {
//                i = Intent(this, AboutPage::class.java)
//                startActivity(i)
//            }
//            R.id.tbClear -> {
//                tvCodedMessage.text = ""
//                etMessageToCode.setText("")
//                Toast.makeText(applicationContext, R.string.clear_result_message, Toast.LENGTH_SHORT).show()
//            }
//            R.id.tbShare -> if (morseCoder.codedMessage != "") {
//                val sendIntent = Intent()
//                sendIntent.action = Intent.ACTION_SEND
//                sendIntent.putExtra(Intent.EXTRA_TEXT, morseCoder.codedMessage)
//                sendIntent.type = "text/plain"
//                startActivity(Intent.createChooser(sendIntent, getString(R.string.share_with_title)))
//            } else Toast.makeText(this, R.string.share_empty, Toast.LENGTH_SHORT).show()
//        }
//        return super.onOptionsItemSelected(item)
//    }
//
//    override fun onClick(v: View) {
//        when (v.id) {
//            R.id.btnCodeIt -> {
//                if (etMessageToCode.text.isNotBlank()) {
//                    Toast.makeText(applicationContext, R.string.empty_error_message, Toast.LENGTH_SHORT).show()
//                } else {
//                    if (alertVisibility) {
//                        ibAlert.visibility = View.INVISIBLE
//                        alertVisibility = false
//                    }
//                    if (operationValue) {
//                        tvCodedMessage.text = morseCoder.codeToMorse(etMessageToCode!!.text.toString().toLowerCase())
//                    } else {
//                        tvCodedMessage.text = morseCoder.decodeFromMorse(etMessageToCode!!.text.toString())
//                    }
//                    if (morseCoder.errorExistence) {
//                        ibAlert.visibility = View.VISIBLE
//                        alertVisibility = true
//                    }
//                    if (morseCoder.codedMessage != "") {
//                        btnCopy.visibility = View.VISIBLE
//                    } else btnCopy.visibility = View.INVISIBLE
//                }
//                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
//                val currentFocus = currentFocus
//                if (imm != null && currentFocus != null) {
//                    imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)
//                }
//            }
//            R.id.ibAlert -> {
//                val builder = AlertDialog.Builder(this)
//                        .setIcon(R.mipmap.ic_alert_red_36dp)
//                        .setTitle("Unknown Symbols !")
//                        .setMessage("""
//    Could not recognize following symbols :
//    ${morseCoder.errSymbols}
//    Make sure symbols are in table !
//    """.trimIndent())
//                        .setNeutralButton("OK !") { _, _ ->
//                            ibAlert!!.visibility = View.INVISIBLE
//                            alertVisibility = false
//                        }
//                val alertDialog = builder.create()
//                alertDialog.show()
//            }
//            R.id.btnCopy -> {
//                val clipboard = getSystemService(CLIPBOARD_SERVICE) as? ClipboardManager
//                if (clipboard != null) {
//                    val clip = ClipData.newPlainText("label", morseCoder.codedMessage)
//                    clipboard.setPrimaryClip(clip)
//                    Toast.makeText(applicationContext, R.string.copied_to_clipboard_message, Toast.LENGTH_SHORT).show()
//                }
//            }
//            R.id.ibSwap -> {
//                ibSwap.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_swap))
//                tvLeft.startAnimation(AnimationUtils.loadAnimation(this, R.anim.text_to_left))
//                tvRight.startAnimation(AnimationUtils.loadAnimation(this, R.anim.text_to_right))
//                if (operationValue) {
//                    tvLeft!!.setText(R.string.morse_label)
//                    tvRight!!.setText(R.string.text_label)
//                    etMessageToCode!!.setHint(R.string.morse_to_message)
//                } else {
//                    tvRight!!.setText(R.string.morse_label)
//                    tvLeft!!.setText(R.string.text_label)
//                    etMessageToCode!!.setHint(R.string.message_to_morse)
//                }
//                operationValue = !operationValue
//            }
//        }
//    }
}