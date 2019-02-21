package patterns.structural.adapter.impl;


import patterns.structural.adapter.AdvanceMediaPlayer;

public class Mp4Player implements AdvanceMediaPlayer {

	@Override
	public void palyVlc(String fileName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void palyMp4(String fileName) {
		
		System.out.println("播放MP4--------"+fileName);
	}

}
