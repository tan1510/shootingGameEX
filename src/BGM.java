/**
 * 
 * @author tachibana
 *
 */
import java.applet.*;
import java.net.*;
import java.util.ArrayList;
public class BGM {
	private URL url;
	private AudioClip audioClip;
	private ArrayList<URL> urlList = new ArrayList<URL>();
	
	public BGM(){
		try {
			url = new URL("/resources/BGM/");
		}catch (MalformedURLException ex) {
			System.err.println(ex);
		}
		audioClip = Applet.newAudioClip(url);
	}
	
	public void play(){
		audioClip.play();
		audioClip.loop();
	}

}
