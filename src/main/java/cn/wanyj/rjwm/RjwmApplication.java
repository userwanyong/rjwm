package cn.wanyj.rjwm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class RjwmApplication {

    public static void main(String[] args) {
        SpringApplication.run(RjwmApplication.class, args);
    }

}
