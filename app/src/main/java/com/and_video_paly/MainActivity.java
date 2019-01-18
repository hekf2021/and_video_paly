package com.and_video_paly;

import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.MediaController.MediaPlayerControl;
import android.widget.VideoView;

import java.io.File;

public class MainActivity extends AppCompatActivity implements MediaPlayerControl {
    private VideoView videoView;
    private MediaController control;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView)this.findViewById(R.id.videoView);
        control = new MediaController(this);
        videoView.setMediaController(control);
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
            File file = Environment.getExternalStorageDirectory();
            File videoFile = new File(file,"a.3gp");
            Uri uri = Uri.fromFile(videoFile);
            videoView.setVideoURI(uri);
        }
    }

    @Override
    public void start() {
        videoView.start();
    }

    @Override
    public void pause() {
        if(videoView.isPlaying()) {
            videoView.pause();
        }
    }

    @Override
    public int getDuration() {
        return videoView.getDuration();
    }

    @Override
    public int getCurrentPosition() {
        return videoView.getCurrentPosition();
    }

    @Override
    public void seekTo(int pos) {
        videoView.seekTo(pos);
    }

    @Override
    public boolean isPlaying() {
        return videoView.isPlaying();
    }

    @Override
    public int getBufferPercentage() {
        return videoView.getBufferPercentage();
    }

    @Override
    public boolean canPause() {
        return videoView.canPause();
    }

    @Override
    public boolean canSeekBackward() {
        return videoView.canSeekBackward();
    }

    @Override
    public boolean canSeekForward() {
        return videoView.canSeekForward();
    }

    @Override
    public int getAudioSessionId() {
        return videoView.getAudioSessionId();
    }
}
