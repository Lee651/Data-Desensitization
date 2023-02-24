package top.rectorlee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lee
 * @description
 * @date 2022-12-06 14:40:11
 */
@SpringBootApplication
@MapperScan("top.rectorlee.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
