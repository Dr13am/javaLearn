import java.util.concurrent.CountDownLatch;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    public final CountDownLatch latch = new CountDownLatch(1);

    @KafkaListener(topics = "${kafka.topic}")
    public void listen(String foo) {
        System.out.println("Received: " + foo);
        this.latch.countDown();
    }

}

