package patterns.structural.adapter.impl;


import patterns.structural.adapter.MediaPlayer;

public class AudioPlayer implements MediaPlayer {

	MediaAdapter mediaAdapter;
	
	@Override
	public void paly(String audioType, String fileName) {

		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("播放MP3------"+fileName);
		}else if(audioType.equalsIgnoreCase("vlc")||audioType.equalsIgnoreCase("mp4")){
			mediaAdapter=new MediaAdapter(audioType);
			mediaAdapter.paly(audioType, fileName);
		}else{
			System.out.println("无法播放格式----"+audioType);
		}
	}

}
