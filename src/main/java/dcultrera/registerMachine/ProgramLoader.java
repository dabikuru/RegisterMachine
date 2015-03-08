package dcultrera.registerMachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProgramLoader {
    public static List<Instruction> loadProgram(String filename) throws IOException, InstructionFormatException {
        List<Instruction> program = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get(filename))) {
            Instruction i = new Instruction(line);
            program.add(i);
        }

        return program;
    }

    public static int[][] loadRegisters(String filename) throws IOException {
        ArrayList<int[]> allRegisters = new ArrayList<>();

        for (String line : Files.readAllLines(Paths.get(filename))) {
            String[] regsAsString = line.split("\\s+");

            int[] regsAsInt = new int[regsAsString.length];
            for (int i=0; i<regsAsInt.length; i++) {
                regsAsInt[i] = Integer.parseInt(regsAsString[i]);
            }

            allRegisters.add(regsAsInt);
        }
        return allRegisters.toArray(new int[allRegisters.size()][]);
    }
}
