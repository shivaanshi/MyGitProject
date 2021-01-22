package com.meenakshi.mygitproject

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


open class BaseActivity: AppCompatActivity() {

    companion object{ var activityManager: ActivityManager? = null}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(activityManager ==null) {
            activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager
        }
        findViewById<TextView>(R.id.tv_activity_name).setTextColor(Color.GREEN)
        findViewById<Button>(R.id.btn_click_a).setOnClickListener {
            startActivity(Intent(this, ActivityA::class.java))
        }
        findViewById<Button>(R.id.btn_click_b).setOnClickListener {
            startActivity(Intent(this, ActivityB::class.java))
        }
        findViewById<Button>(R.id.btn_click_c).setOnClickListener {
            startActivity(Intent(this, ActivityC::class.java))
        }
        findViewById<Button>(R.id.btn_click_d).setOnClickListener {
            startActivity(Intent(this, ActivityD::class.java))
        }
        findViewById<Button>(R.id.btn_click_e).setOnClickListener {
            startActivity(Intent(this, ActivityE::class.java))
        }
        findViewById<Button>(R.id.btn_click_f).setOnClickListener {
            startActivity(Intent(this, ActivityF::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.tv_description).text = getAppTaskState()
    }

    protected open fun getAppTaskState(): String? {
        val stringBuilder = StringBuilder()
        val tasks = (this.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager).appTasks
        stringBuilder.append("Task Size: ")
        stringBuilder.append(tasks.size)
        stringBuilder.append("\n");
        for (task in tasks) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.Q) {
                stringBuilder.append("Task Id: ")
                stringBuilder.append(task.taskInfo.taskId)
                stringBuilder.append("\n");
            }
            stringBuilder.append(" No Activities: ").append(task.taskInfo.numActivities)
            stringBuilder.append("\n");
            stringBuilder.append(" Base Activity: ").append(task.taskInfo.baseActivity?.shortClassName)
            stringBuilder.append("\n");
            stringBuilder.append(" Top Activity: ").append(task.taskInfo.topActivity?.shortClassName)
            stringBuilder.append("\n");
            stringBuilder.append(" Orig Activity: ").append(task.taskInfo.origActivity?.shortClassName)
        }
        return stringBuilder.toString()
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