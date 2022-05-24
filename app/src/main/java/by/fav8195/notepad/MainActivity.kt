package by.fav8195.notepad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import by.fav8195.notepad.databinding.ActivityMainBinding
import by.fav8195.notepad.db.MyDbManager


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding//adding Binding
    val myDbManager = MyDbManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)//adding Binding
        setContentView(binding.root)//setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDb()
    }

    fun onclickNew(view: View) {
        val i = Intent(this, EditActivity::class.java)
        startActivity(i)
    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDb()
    }
}