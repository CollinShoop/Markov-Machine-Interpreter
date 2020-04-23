package com.cshoop.markov;

import com.cshoop.markov.executor.Executor;
import com.cshoop.markov.machine.MarkovMachine;
import com.cshoop.markov.machine.MarkovMachineLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class RunCmd {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Not enough arguments. Usage looks like <program_file> <inputs ...>");
            System.exit(1);
        }
        try {
            MarkovMachine machineFromFile = MarkovMachineLoader.loadMachine(new File(args[0]));
            List<String> inputs = Arrays.asList(Arrays.copyOfRange(args, 1, args.length));
            new Executor(machineFromFile, inputs).run();
        } catch (FileNotFoundException e) {
            System.err.println("Given <program_file> arg '" + args[0] + "' can't be read: " + e.getMessage());
            System.exit(1);
        }
    }

}
