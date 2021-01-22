package com.meenakshi.mygitproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("Lifecycle Method: CREATE")
    }

    override fun onStart() {
        super.onStart()
        println("Lifecycle Method: CREATE")
    }

    override fun onResume() {
        super.onResume()
        println("Lifecycle Method: RESUME")
    }

    override fun onRestart() {
        super.onRestart()
        println("Lifecycle Method: RESTART")
    }

    override fun onPause() {
        super.onPause()
        println("Lifecycle Method: PAUSE")
    }

    override fun onStop() {
        super.onStop()
        println("Lifecycle Method: STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Lifecycle Method: DESTROY")
    }

}