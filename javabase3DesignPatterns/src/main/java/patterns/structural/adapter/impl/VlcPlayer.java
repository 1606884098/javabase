package patterns.structural.adapter.impl;


import patterns.structural.adapter.AdvanceMediaPlayer;

public class VlcPlayer implements AdvanceMediaPlayer {

	@Override
	public void palyVlc(String fileName) {

		System.out.println("播放vlc------"+fileName);
	}

	@Override
	public void palyMp4(String fileName) {
		// TODO Auto-generated method stub

	}

}
