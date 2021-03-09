/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Korisnik
 */
public class SoundManager {
    
    public static void playSound(String fileName) throws MalformedURLException, UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        File f = new File(fileName);
        AudioInputStream audioin = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        if(clip.isRunning())
        {
            
        }
        else
        {
        clip.open(audioin);
        clip.start();
    }
    }
}
