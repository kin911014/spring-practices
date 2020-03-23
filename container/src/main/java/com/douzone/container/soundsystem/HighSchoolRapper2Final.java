package com.douzone.container.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class HighSchoolRapper2Final implements CompactDisc {
	private String title = "붕붕";
	private String artist = "김하온";
	
	@Override
	public void play() {
		System.out.println("Playing " + title + "by " + artist);
	}

}
