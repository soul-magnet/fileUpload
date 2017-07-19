package finra.test.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@EnableAutoConfiguration
@ComponentScan
public class ApplicationFileUpload  {

    public static void main(final String[] args) {
        SpringApplication.run(ApplicationFileUpload.class, args);
    }

}
