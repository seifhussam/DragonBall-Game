package dragonball.view;
import static javax.sound.sampled.AudioFormat.Encoding.PCM_SIGNED;

import javax.sound.sampled.*;

import static javax.sound.sampled.AudioSystem.getAudioInputStream;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.sound.sampled.DataLine.Info;

public class AudioFilePlayer implements Serializable {
	static AudioFilePlayer player;
    public static void main(String[] args) {
    	
    	Runnable soundRun = new Runnable() {
			   public void run() {
			    while(true){
				   AudioFilePlayer.PlayThemeMusic();
			    }
			   }
			 };
			 
		Thread sound = new Thread(soundRun) ;
		sound.start();
		    	
    	
    	try {
			mute();
			System.out.println("hilo");
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public static void PlaySound(){
    	 player = new AudioFilePlayer ();
    	 player.play("attack.wav");  	 
    }
    
    
    
    public static void mute() throws LineUnavailableException{
    	DataLine.Info info = null;
        Clip clip = (Clip) AudioSystem.getLine(info);

        FloatControl gainControl = (FloatControl) clip
            .getControl(FloatControl.Type.MASTER_GAIN);
        double gain = .5D; // number between 0 and 1 (loudest)
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);

        BooleanControl muteControl = (BooleanControl) clip
            .getControl(BooleanControl.Type.MUTE);
        muteControl.setValue(true);

       // muteControl.setValue(false);
    
        AudioFilePlayer.ButtonPressed();
    
    }
    
    public static void PlayThemeMusic(){
    	 player = new AudioFilePlayer ();
    	 player.play("theme.wav");  	 
    }
    
    public static void ButtonPressed(){
    	 player = new AudioFilePlayer ();
   	 player.play("button.wav");  	
    }

    public void play(String filePath) {
        final File file = new File(filePath);

        try (final AudioInputStream in = getAudioInputStream(file)) {

            final AudioFormat outFormat = getOutFormat(in.getFormat());
            final Info info = new Info(SourceDataLine.class, outFormat);

            try (final SourceDataLine line =
                     (SourceDataLine) AudioSystem.getLine(info)) {

                if (line != null) {
                    line.open(outFormat);
                    line.start();
                    stream(getAudioInputStream(outFormat, in), line);
                    line.drain();
                    line.stop();
                }
            }

        } catch (UnsupportedAudioFileException 
               | LineUnavailableException 
               | IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();

        final float rate = inFormat.getSampleRate();
        return new AudioFormat(PCM_SIGNED, rate,16, ch, ch * 2, rate, false);
    }

    private void stream(AudioInputStream in, SourceDataLine line) 
        throws IOException {
        final byte[] buffer = new byte[4096];
        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
            line.write(buffer, 0, n);
        }
    }
}
