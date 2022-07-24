@Component
@Slf4j
public class Producer {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    public void sendMsgToQueue(String msg) {
        log.info("发送消息内容 :" + msg);
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

    public void sendMsgToTopic(String msg) {
        log.info("发送消息内容 :" + msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}

