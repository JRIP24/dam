package com.example.so;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int REWIND_TIME = 5000;
    public static int FASTFORWARD_TIME = 5000;
    public static int UPDATE_SEEKBAR = 100;
    private static final String PLAY_TIME = "play_time";

    private int mCurrentPosition = 0;

    Button btPlay;
    Button btStop;
    Button btRewind;
    Button btFastForward;

    SeekBar seekBarProgres;
    SeekBar seekBarVolume;
    Handler handler = new Handler(Looper.getMainLooper());
    AudioManager audioManager;

    MediaPlayer mediaPlayer;


    public class UpdateSeekBarProgress implements Runnable{

        @Override
        public void run() {
            if (mediaPlayer != null){
                seekBarProgres.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this, UPDATE_SEEKBAR);
            }
        }
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (mediaPlayer != null){
            if (mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
            outState.putInt(PLAY_TIME, mediaPlayer.getCurrentPosition());
        }
    }

    @Override
    protected void onStop() {
        releaseMediaplayer();//Comentamos esta línea si queremos que siga sonando
        super.onStop();
    }

    private void releaseMediaplayer() {
        if (mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hook
        btPlay = findViewById(R.id.btPlay);
        btStop = findViewById(R.id.btStop);
        btRewind = findViewById(R.id.btRewind);
        btFastForward = findViewById(R.id.btFastForward);

        seekBarProgres = findViewById(R.id.seekBarProgres);
        seekBarVolume = findViewById(R.id.seekBarVolume);

        mediaPlayer = MediaPlayer.create(this, R.raw.gasolina_dy);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        seekBarProgres.setMax(mediaPlayer.getDuration());

        seekBarVolume.setMax(audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC));
        seekBarVolume.setProgress(audioManager.getStreamVolume(AudioManager.STREAM_MUSIC));

        if (savedInstanceState != null){
            mCurrentPosition = savedInstanceState.getInt(PLAY_TIME);
            mediaPlayer.seekTo(mCurrentPosition);
        }


        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio();
            }
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pauseAudio();
            }
        });

        btFastForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fastForward();
            }
        });

        btRewind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rewind();
            }
        });

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                seekBarProgres.setProgress(0);
                mediaPlayer.reset();
                mediaPlayer.release();
                mediaPlayer = null;
                Toast.makeText(MainActivity.this, "Song has finished", Toast.LENGTH_SHORT).show();
            }
        });

        seekBarProgres.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Hay 2 formas de cambiar el seekBar
                //1 from mediaplayer
                //2 from user

                if (fromUser){
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }

    private void rewind() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        if (currentPosition - REWIND_TIME > 0){
            mediaPlayer.seekTo(currentPosition - REWIND_TIME);
        }
    }

    private void fastForward() {
        int currentPosition = mediaPlayer.getCurrentPosition();
        int duration = mediaPlayer.getDuration();
        if (currentPosition + FASTFORWARD_TIME < duration){
            mediaPlayer.seekTo(currentPosition + FASTFORWARD_TIME);
        }
    }

    public void playAudio(){

        if (mediaPlayer != null){
            mediaPlayer.start();
        } else {
            mediaPlayer = MediaPlayer.create(this,R.raw.gasolina_dy);
            mediaPlayer.start();
        }

        UpdateSeekBarProgress updateSeekBarProgress = new UpdateSeekBarProgress();
        handler.post(updateSeekBarProgress);


    }

    public void pauseAudio(){
        mediaPlayer.pause();
    }
}