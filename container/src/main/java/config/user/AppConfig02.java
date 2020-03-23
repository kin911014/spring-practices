package config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.user.User;

// 설정파일이라는것을 표시하는 어노테이션
@Configuration
public class AppConfig02 {
	
	@Bean
	public User user() {
		return new User("마이콜");
	}
}
