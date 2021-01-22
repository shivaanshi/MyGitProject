package com.meenakshi.mygitproject

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityD: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        findViewById<TextView>(R.id.tv_activity_name).text = this.localClassName
        findViewById<TextView>(R.id.tv_activity_name).setTextColor(Color.MAGENTA)
    }
}