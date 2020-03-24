package cconfig.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {

	@Bean
	public Avengers avengers() {
		return new Avengers();
	}
	
	
//	// DI01 주입01: Bean 생성메소드 직접 호출
//	@Bean
//	public DVDPlayer dvdplayer() {
//		return new DVDPlayer(avengers());
//	}
//	
	// DI02 주입02: 파라미터로 Bean 전달하기: 생성자주입
	@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}
	
	// DI03 주입03: 파라미터로 Bean 전달하기: setter주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		 DVDPlayer dvdPlayer = new DVDPlayer(dvd);
		 dvdPlayer.setDvd(dvd);
		 
		 return dvdPlayer;
	}
	
	// DI04 주입04: 같은 타입이 생성된 경우
	@Bean(name="dvdPlayer04")
	public DVDPlayer dvdPlayer04(DigitalVideoDisc dvd) {
		DVDPlayer dvdPlayer = new DVDPlayer(dvd);
		dvdPlayer.setDvd(dvd);
		
		return dvdPlayer;
	}
	
}
