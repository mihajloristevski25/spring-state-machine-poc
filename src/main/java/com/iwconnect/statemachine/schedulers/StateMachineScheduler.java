package com.iwconnect.statemachine.schedulers;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class StateMachineScheduler {

    private final StateMachine<String, String> stateMachine;


    public StateMachineScheduler(StateMachine<String, String> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Scheduled(fixedRate = 5000)
    public void startStateMachine() {
        stateMachine.start();
        stateMachine.sendEvent("Event 1");
        stateMachine.sendEvent("Event 2");
        stateMachine.sendEvent("Event 3");
        stateMachine.sendEvent("Event 4");
        stateMachine.sendEvent("end");
    }
}
