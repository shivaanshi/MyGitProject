package com.meenakshi.mygitproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityB: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<TextView>(R.id.tv_activity_name).text = this.localClassName
        findViewById<TextView>(R.id.tv_activity_name).setTextColor(Color.GREEN)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val stringBuilder = StringBuilder()
        stringBuilder.append("\n");
        stringBuilder.append(this.localClassName + ": onNewIntent")
        findViewById<TextView>(R.id.tv_description).append(stringBuilder.toString())
        println(stringBuilder.toString())
    }

}