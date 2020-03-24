package com.douzone.container.soundsystem;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer {
	// wiring01: 바이너리 주입(CGLib) 최근 방식, 가장 좋은 방식이다.
//	@Inject(자바 표준 Wiring annotation)
//	@Autowired(Wiring annotation)
	
	@Autowired
	@Qualifier("highSchoolRapper3Final")
	private CompactDisc cd;
	
	public CDPlayer() {
		
	}
	
	// wiring02 : 생성자 주입
	//@Autowired
	public CDPlayer(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	// wiring03 : setter 사용	
	// @Autowired
	public void setCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	// wiring04 : setter 사용	
//	@Autowired
	public void insertCompactDisc(@Qualifier("highSchoolRapper3Final") CompactDisc cd) {
		this.cd = cd;
	}
	
	public void play() {
		cd.play();
	}

}
