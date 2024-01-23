package com.iwconnect.statemachine.service.impl;

import com.iwconnect.statemachine.service.StateMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.stereotype.Service;

@Service
public class StateMachineServiceImpl implements StateMachineService {

    private final StateMachine<String, String> stateMachine;

    public StateMachineServiceImpl(StateMachine<String, String> stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public void startStateMachine() {
        stateMachine.start();
        stateMachine.sendEvent("Event 1");
        stateMachine.sendEvent("Event 2");
        stateMachine.sendEvent("Event 3");
        stateMachine.sendEvent("Event 4");
        stateMachine.sendEvent("end");
        stateMachine.stop();
    }
}
