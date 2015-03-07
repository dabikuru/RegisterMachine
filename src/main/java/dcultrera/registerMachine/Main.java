package dcultrera.registerMachine;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filename = args[0];

        //regmachine.jar -p sum.csv [-r x.csv | -m 1 2 3 ... ]
        try {
            List<Instruction> instructions = ProgramLoader.loadProgram(filename);
            int[] regs = {0, 1, 2};

            RM machine = new RM(instructions);
            machine.setRegisters(regs);

            machine.eval();
            System.out.println(machine.getResult());

        } catch (IOException | InstructionFormatException e) {
            e.printStackTrace();
        }

    }
}
