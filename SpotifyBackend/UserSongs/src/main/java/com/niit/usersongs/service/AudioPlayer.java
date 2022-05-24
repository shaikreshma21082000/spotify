package com.niit.usersongs.service;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

public class AudioPlayer{

    int response;
    String status="EMPTY";
    long currentFrame=0;
    Clip clip;

    public void playMusic(String link) {
        Scanner sc = new Scanner(System.in);
        try {
            AudioInputStream audioInput= AudioSystem.getAudioInputStream(new File(link));
            clip=AudioSystem.getClip();
            clip.open(audioInput);
            if(status.equalsIgnoreCase("PLAYING"))
            {
                System.out.println("song is already playing");
            }
            else{
                clip.start();
                status = "PLAYING";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause(){
        if(status.equalsIgnoreCase("PAUSED") ||  status.equalsIgnoreCase("FINISHED") ) {
            System.out.println("SONG IS ALREADY PAUSED OR STOPPED");
        }else{
            currentFrame= clip.getMicrosecondPosition();
            clip.stop();
            status="PAUSED";
        }
    }

    public void resume(){
        if(status.equalsIgnoreCase("PLAYING") || status.equalsIgnoreCase("FINISHED") )
        {
            System.out.println("AUDIO IS ALREADY PLAYING OR STOPPED");
        }
        else{
            clip.setMicrosecondPosition(currentFrame);
            clip.start();
            status="PLAYING";

        }
    }

    public void restart(){
        if(status.equalsIgnoreCase("FINISHED")){
            clip.setMicrosecondPosition(0);
            clip.start();
            status="PLAYING";
        }
        else{
        clip.setMicrosecondPosition(0);
        status="PLAYING";
        }
    }

    public void stop(){
        clip.stop();
        status="FINISHED";
    }
}