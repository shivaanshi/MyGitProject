package com.meenakshi.mygitproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Lifecycle Method: CREATE " + this.localClassName)
        findViewById<Button>(R.id.btn_click_a).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }
        findViewById<Button>(R.id.btn_click_b).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
        findViewById<Button>(R.id.btn_click_dialog).setOnClickListener {
            startActivity(Intent(this, DialogActivity::class.java))
        }
        findViewById<Button>(R.id.btn_click_trans).setOnClickListener {
            startActivity(Intent(this, TransparentActivity::class.java))
        }
        onResume()
    }

    override fun onStart() {
        super.onStart()
        println("Lifecycle Method: START " + this.localClassName)
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.tv_activity_name).text = this.localClassName
        println("Lifecycle Method: RESUME " + this.localClassName)
    }

    override fun onRestart() {
        super.onRestart()
        println("Lifecycle Method: RESTART " + this.localClassName)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        println("Lifecycle Method: NewIntent " + this.localClassName)
    }

    override fun onPause() {
        super.onPause()
        println("Lifecycle Method: PAUSE " + this.localClassName)
    }

    override fun onStop() {
        super.onStop()
        println("Lifecycle Method: STOP " + this.localClassName)
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Lifecycle Method: DESTROY " + this.localClassName)
    }

}