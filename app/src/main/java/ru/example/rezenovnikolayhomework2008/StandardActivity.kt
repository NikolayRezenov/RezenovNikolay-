package ru.example.rezenovnikolayhomework2008


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Switch
import kotlin.math.log

private const val TAG = "StandardActivity"

class StandardActivity : AppCompatActivity() {

    private var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: $this")
        setContentView(R.layout.activity_main)

        findViewById<Switch>(R.id.isFavorite).setOnCheckedChangeListener { compoundButton, isChecked ->
            isFavorite = isChecked
        }

        findViewById<Button>(R.id.standard_btn).setOnClickListener {
//            startActivity(Intent(this, StandardActivity::class.java))
            setResult(RESULT_OK, Intent().putExtra(MainActivity.EXTRA_VALUE, "Standard")
                .putExtra("user", User("name")))

            finish()
        }
        findViewById<Button>(R.id.single_top_btn).setOnClickListener {
            startActivity(Intent(this, SingleTopActivity::class.java))
        }
        findViewById<Button>(R.id.single_task_btn).setOnClickListener {
            startActivity(Intent(this, SingleTaskActivity::class.java))
        }
//        setResult(RESULT_CANCELED)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: $this")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: $this")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: $this")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: $this")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: $this")
    }
}