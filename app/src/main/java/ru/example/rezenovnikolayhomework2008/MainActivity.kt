package ru.example.rezenovnikolayhomework2008

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_VALUE = "value_ext"
    }

    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        Log.d(TAG, "onActivityResult: $result")
        result ?: return@registerForActivityResult

        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.extras?.let { extras ->
                Log.d(TAG, "onActivityResult: ${extras.getString(EXTRA_VALUE)}")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).buildSomething()

        savedInstanceState?.let { handleState(it) }

        Log.d(TAG, "onCreate: $this")
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.standard_btn).setOnClickListener {
            launcher.launch(Intent(this, StandardActivity::class.java))
        }
        findViewById<Button>(R.id.single_top_btn).setOnClickListener {
            startActivity(Intent(this, SingleTopActivity::class.java))
        }
        findViewById<Button>(R.id.single_task_btn).setOnClickListener {
            startActivity(Intent(this, SingleTaskActivity::class.java))
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("state_user_age", 38)
        outState.putString("state_user_name", "Nikolay Rrezenov")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        handleState(savedInstanceState)
    }

    private fun handleState(savedInstanceState: Bundle) {
        val age = savedInstanceState.getInt("state_user_age", -1)
        val name = savedInstanceState.getString("state_user_name")
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

// https://otus.ru/polls/45929/