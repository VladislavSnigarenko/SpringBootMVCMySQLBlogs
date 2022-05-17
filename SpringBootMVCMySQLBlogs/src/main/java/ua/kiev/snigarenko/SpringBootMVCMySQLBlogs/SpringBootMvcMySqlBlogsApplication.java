package ua.kiev.snigarenko.SpringBootMVCMySQLBlogs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ua.kiev.snigarenko.SpringBootMVCMySQLBlogs.repository.PostRepository;

@SpringBootApplication
public class SpringBootMvcMySqlBlogsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMvcMySqlBlogsApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PostRepository postRepository) {
		return (args) -> {
			System.out.println("CommandLineRunner");
		};
	}
}
