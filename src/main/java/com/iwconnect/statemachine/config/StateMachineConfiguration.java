package com.iwconnect.statemachine.config;

import com.iwconnect.statemachine.enums.StateEnums;
import com.iwconnect.statemachine.listener.StateMachineListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
@EnableStateMachine
public class StateMachineConfiguration extends StateMachineConfigurerAdapter<String, String> {

    @Bean
    public StateMachineListener customStateMachineListener() {
        return new StateMachineListener();
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<String, String> config)
            throws Exception {
        config
                .withConfiguration()
                .autoStartup(false)
                .listener(customStateMachineListener());
    }

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states) throws Exception {
        states
                .withStates()
                .initial(StateEnums.START)
                .end(StateEnums.END)
                .states(
                        new HashSet<>(Arrays.asList(
                                StateEnums.STAGE1,
                                StateEnums.STAGE2,
                                StateEnums.STAGE3,
                                StateEnums.STAGE4
                        )));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<String, String> transitions) throws Exception {
        transitions.withExternal()
                .source(StateEnums.START).target(StateEnums.STAGE1)
                .event("Event 1")
                .and()
                .withExternal()
                .source(StateEnums.STAGE1).target(StateEnums.STAGE2)
                .event("Event 2")
                .and()
                .withExternal()
                .source(StateEnums.STAGE2).target(StateEnums.STAGE3)
                .event("Event 3")
                .and()
                .withExternal()
                .source(StateEnums.STAGE3).target(StateEnums.STAGE4)
                .event("Event 4")
                .and()
                .withExternal()
                .source(StateEnums.STAGE4).target(StateEnums.END)
                .event("end");
    }



}
