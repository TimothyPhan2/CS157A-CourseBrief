package com.CS157AProject.CourseBrief;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.shell.jline.ShellAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.CS157AProject.CourseBrief"}) //,scanBasePackages = {"com.CS157AProject.CourseBrief"} exclude = {ShellAutoConfiguration.class}
@EnableJpaRepositories
public class CourseBriefApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseBriefApplication.class, args);
	}

}
