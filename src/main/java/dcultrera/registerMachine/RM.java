package dcultrera.registerMachine;

import java.util.ArrayList;
import java.util.List;

public class RM {
    private ArrayList<Instruction> instructionList;
    private ArrayList<Integer> registers;

    public RM(List<Instruction> instructionList) {
        this.instructionList = new ArrayList<>(instructionList);
    }

    public void execute() {
        // Begin with instruction 0
        // Case split:

        Instruction i = instructionList.get(0);
        switch (i.getType()) {
            case ADD:
                break;
            case SUB:
                break;
            case HALT:
                break;
            case EXIT:
                break;
        }
    }
}
