package com.cshoop.markov;

import com.cshoop.markov.executor.Executor;
import com.cshoop.markov.machine.MarkovMachine;
import com.cshoop.markov.machine.MarkovMachineLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        List<String> inputs = Arrays.asList("aaaaa", "aa", "B", "CAT", "cat");
        String programString = "programs/double_a.markov";
        MarkovMachine machine = MarkovMachineLoader.loadMachine(new File(programString));

        new Executor(machine, inputs).run();
    }
    
}
