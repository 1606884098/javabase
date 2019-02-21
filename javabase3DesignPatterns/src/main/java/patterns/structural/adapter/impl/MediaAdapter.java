package patterns.structural.adapter.impl;


import patterns.structural.adapter.AdvanceMediaPlayer;
import patterns.structural.adapter.MediaPlayer;

public class MediaAdapter implements MediaPlayer {

	AdvanceMediaPlayer advanceMusicPlayer;
	
	public MediaAdapter(String audioType){
		
		if(audioType.equalsIgnoreCase("vlc")){
			advanceMusicPlayer=new VlcPlayer();
		}else if(audioType.equalsIgnoreCase("mp4")){
			advanceMusicPlayer=new Mp4Player();
		}
	}
	
	@Override
	public void paly(String audioType, String fileName) {

		if(audioType.equalsIgnoreCase("vlc")){
			advanceMusicPlayer.palyVlc(fileName);
		}else if(audioType.equalsIgnoreCase("mp4")){
			advanceMusicPlayer.palyMp4(fileName);
		}
	}

	
}
