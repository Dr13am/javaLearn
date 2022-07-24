@Component
@Slf4j
public class Consumer {

    @JmsListener(destination = "activemq-demo.queue")
    public void receiveMsgFromQueue(String text) {
        log.info("queue 接收到消息 : "+text);
    }

    @JmsListener(destination = "activemq-demo.topic",containerFactory="jmsListenerContainerTopic")
    public void receiveMsgFromTopic(String text) {
        log.info("topic 接收到消息 : "+text);
    }
}
