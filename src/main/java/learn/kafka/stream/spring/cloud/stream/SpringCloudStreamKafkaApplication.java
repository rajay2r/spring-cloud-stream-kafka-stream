package learn.kafka.stream.spring.cloud.stream;

import learn.kafka.stream.spring.cloud.stream.messaging.WordCountChannelBindings;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBinding(WordCountChannelBindings.class)
@SpringBootApplication
public class SpringCloudStreamKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudStreamKafkaApplication.class, args);
	}

}
