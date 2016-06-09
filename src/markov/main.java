package markov;

import java.io.File;
import java.io.FileNotFoundException;

public class main {

    public static void main(String[] args) throws FileNotFoundException {

        String programString = "programs/double_a.markov";
    	String[] inputs = {"aaaaa", "aa", "B", "CAT", "cat"};
    	
        MarkovMachine machine = MarkovMachineLoader.loadMachine(new File(programString));
        String[] outputs = machine.process(inputs, false);
        
        for(int i = 0; i < inputs.length; i++) {
        	System.out.println(machine.getName() + "(" + inputs[i] + ") = " + outputs[i]);
        }
    }
    
}
