package com.liusbl.listbinderssample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.liusbl.listbinderssample.multi.MultiActivity
import com.liusbl.listbinderssample.single.SingleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        singleViewTypeExampleButton.setOnClickListener {
            val intent = SingleActivity.createIntent(this@MainActivity)
            startActivity(intent)
        }
        findViewById<View>(R.id.multiViewTypeExampleButton).setOnClickListener {
            val intent = Intent(this@MainActivity, MultiActivity::class.java)
            startActivity(intent)
        }
    }
}