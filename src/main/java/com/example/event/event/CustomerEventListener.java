package com.example.event.event;

import com.example.event.model.event.CustomerEventModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@Slf4j
public class CustomerEventListener {

    @EventListener
    public void eventHandler(CustomerEventModel model) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
                Runnable runner = new Runnable(){
                    @Override
                    public void run() {
                        log.info("first event {} time start {}", model, LocalTime.now());
                    }
                };
                runner.run();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();

    }

    @EventListener
    public void secondEventHandler(CustomerEventModel model) {
        log.info("second event {} time start {}", model, LocalTime.now());
    }

    @EventListener(classes = {ContextStoppedEvent.class})
    public void eventStoppedHandler() {
        log.info("event is closed");
    }
}
