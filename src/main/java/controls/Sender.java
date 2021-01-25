package controls;

import models.Obj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import java.util.Date;
import java.util.Random;

@Controller
@Component
@EnableScheduling
public class Sender {
    @Autowired private KafkaTemplate<String, Obj> kafkaTemplate;



    @Scheduled(initialDelay=0,fixedDelay = 10000)
    public void send () {
        System.out.println("Im gonna send them");
        int countOfTheNeededObjects;
        //calculating the number of objects we have to create for the following 1 seconds:
        {
            countOfTheNeededObjects=(int)(Math.random()*9)+2;
        }
        //creating objects and sending them for kafka
        {
            for(int i=0;i<countOfTheNeededObjects;i++) {
                Obj object;
                //creating object
                {
                    object=new Obj((int)(Math.random()*100)+1,new Date());
                }
                //sending the object for kafka
                {
                    kafkaTemplate.send("objects container",object);
                }
            }
        }
    }
}
