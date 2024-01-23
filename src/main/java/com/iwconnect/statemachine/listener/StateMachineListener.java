package com.iwconnect.statemachine.listener;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Configuration
public class StateMachineListener extends StateMachineListenerAdapter {
    @Override
    public void stateChanged(State from, State to) {
        System.out.printf("Transitioned from %s to %s%n", from == null ?
                "endpoint" : from.getId(), to.getId());
    }
}
