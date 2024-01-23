package com.iwconnect.statemachine.controller;

import com.iwconnect.statemachine.enums.EndpointEnums;
import com.iwconnect.statemachine.service.StateMachineService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateMachineController {

    private final StateMachineService stateMachineService;

    public StateMachineController(StateMachineService stateMachineService) {
        this.stateMachineService = stateMachineService;
    }

    @PostMapping(EndpointEnums.STATE_MACHINE_URL)
    public String startStateMachine() {
            stateMachineService.startStateMachine();
        return "State machine started";
    }
}
