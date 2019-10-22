package serg.demo.safe.taxi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@MessageMapping
public class ButtonController {

    @Autowired
    private SimpMessagingTemplate brokerMessagingTemplate;

    @GetMapping("/show")
    @SendTo("/topic/greetings")
    public String showButton(String a) {
        brokerMessagingTemplate.convertAndSend("/topic/greetings", "show");
        return "show";
    }

    @GetMapping("/yes")
    @SendTo("/topic/greetings")
    public String assumeYesPressed() {
        brokerMessagingTemplate.convertAndSend("/topic/greetings", "yes");
        return "yes";
    }

    @GetMapping("/no")
    @SendTo("/topic/greetings")
    public String assumeNoPressed() {
        brokerMessagingTemplate.convertAndSend("/topic/greetings", "no");
        return "no";
    }



}
