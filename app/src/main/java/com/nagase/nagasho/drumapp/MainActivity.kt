package com.nagase.nagasho.drumapp

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    private lateinit var mSoundPool: SoundPool
    private lateinit var mSoundID : Array<Int?>

    private val mSoundResource = arrayOf(
        R.raw.drum_sound,
        R.raw.guitar_sound,
        R.raw.piano_sound,
        R.raw.symbal,
        R.raw.bibura
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()
        mSoundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(mSoundResource.size)
            .build()
        mSoundID = arrayOfNulls(mSoundResource.size)

        for (i in 0..(mSoundResource.size-1)){
            mSoundID[i]=mSoundPool.load(applicationContext,mSoundResource[i],0)
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        mSoundPool.release()
    }
    fun drum(View: View){
        if (mSoundID[0] != null){
            mSoundPool.play(mSoundID[0] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }
    fun piano(View: View){
        if (mSoundID[0] != null){
            mSoundPool.play(mSoundID[2] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }
    fun guitar(View:View){
        if (mSoundID[0] != null){
            mSoundPool.play(mSoundID[1] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }
    fun symbal(view:View){
        if (mSoundID[0] != null){
            mSoundPool.play(mSoundID[3] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }
    fun bibura(view:View){
        if (mSoundID[0] != null){
            mSoundPool.play(mSoundID[4] as Int, 1.0F,1.0F,0,0,1.0F)
        }
    }

}