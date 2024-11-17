package com.example.myapplication

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.database.Cursor
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Timer
import java.util.TimerTask


class MainActivity : AppCompatActivity() {

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val allsongsuri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val selection = MediaStore.Audio.Media.IS_MUSIC + " != 0"
        lateinit var STAR: Array<String>
        var song_name: String = "ss";
        val cursor: Cursor? = getContentResolver().query(allsongsuri, STAR, selection, null, null)
       if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    song_name = cursor
                        .getString(
                            cursor
                                .getColumnIndex(MediaStore.Audio.Media.DISPLAY_NAME)
                        )
                    val song_id = cursor.getInt(
                        cursor
                            .getColumnIndex(MediaStore.Audio.Media._ID)
                    )

                    val fullpath =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DATA))
                    val Duration =
                        cursor.getString(cursor.getColumnIndex(MediaStore.Audio.Media.DURATION))

                    Log.d(
                        TAG,
                        "Song Name ::$song_name Song Id :$song_id fullpath ::$fullpath Duration ::$Duration"
                    )
                } while (cursor.moveToNext())
            }
            cursor.close()
        }
        Timer().schedule(object : TimerTask() {
            override fun run() {
                val intent = Intent()
                intent.setClass(this@MainActivity, RootActivity::class.java)
                intent.putExtra("sn", song_name)
                startActivity(intent)
                finish()
                Log.d(
                    "MainActivity:",
                    "onCreate: waiting 5 seconds for MainActivity... loading PrimaryActivity.class"
                )
            }
        }, 5000)


    }
}