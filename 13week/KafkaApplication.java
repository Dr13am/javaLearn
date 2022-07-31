import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import com.wen.kafka.CommonConfiguration;
import com.wen.kafka.ConfigProperties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
@Import({ CommonConfiguration.class, ConfigProperties.class })
@EnableKafka
public class KafkaApplication {

    public static void main(String[] args) throws Exception {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(KafkaApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
        Producer producer = context.getBean(Producer.class);
        producer.send("stupid");
        context.getBean(Consumer.class).latch.await(10, TimeUnit.SECONDS);
        context.close();
    }

}
