package dcultrera.registerMachine;

import java.io.IOException;
import java.util.List;

public class Main {

    /**
     *
     * @param args <program file> <register file>
     */
    public static void main(String[] args) {
        String progFile = args[0];
        String regFile = args[1];

        try {
            List<Instruction> instructions = ProgramLoader.loadProgram(progFile);
            int[][] allRegs = ProgramLoader.loadRegisters(regFile);

            RM machine = new RM(instructions);

            for (int[] i : allRegs) {
                machine.setRegisters(i);
                machine.eval();
                System.out.println(machine.getResult());
            }

        } catch (IOException | InstructionFormatException e) {
            e.printStackTrace();
        }

    }
}
