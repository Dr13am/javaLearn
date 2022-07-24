@RestController
@Slf4j
public class ActiveMQController {

    @Autowired
    Producer producer;

    @RequestMapping("/sendQueue")
    @ResponseBody
    public String sendQueue(String msg) {
        producer.sendMsgToQueue(msg);
        return "success";
    }

    @RequestMapping("/sendTopic")
    @ResponseBody
    public String sendTopic(String msg) {
        producer.sendMsgToTopic(msg);
        return "success";
    }
}
