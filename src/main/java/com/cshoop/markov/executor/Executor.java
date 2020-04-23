package com.cshoop.markov.executor;

import com.cshoop.markov.machine.MarkovMachine;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Executor {

    private final MarkovMachine machine;
    private final List<String> inputsList;
    private boolean debug = false;


    public void run() {

        inputsList.forEach(input ->  {
            System.out.println(machine.getName() + "(" + input + ") = " + machine.process(input, debug));
        });
    }



}
