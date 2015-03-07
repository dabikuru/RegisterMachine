package dcultrera.registerMachine;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ProgramLoader {
    public static List<Instruction> loadProgram(String filename) throws IOException, InstructionFormatException {
        List<Instruction> program = new ArrayList<>();


        try {
            for (String line : Files.readAllLines(Paths.get(filename))) {
                Instruction i = new Instruction(line);
                program.add(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException();
        }

        return program;
    }
}
