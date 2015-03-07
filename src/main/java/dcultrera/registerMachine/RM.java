package dcultrera.registerMachine;

import java.util.ArrayList;
import java.util.List;

public class RM {
    static final int MAXREG = 500;

    private ArrayList<Instruction> instructionList;
    private int[] registers = new int[MAXREG];

    public RM(List<Instruction> instructionList) {
        this.instructionList = new ArrayList<>(instructionList);
    }

    public int[] getRegisters() {
        return registers;
    }

    public int getResult() {
        return registers[0];
    }

    public void setRegister(int regVal, int regNo) {
        this.registers[regNo] = regVal;
    }

    public void setRegisters(int[] registers) {
        System.arraycopy(registers, 0, this.registers, 0, registers.length);
    }

    public void eval() {
        Instruction i = instructionList.get(0);

        while (i.getType() != InstrType.HALT && i.getType() != InstrType.EXIT)
            switch (i.getType()) {
                case ADD:
                    registers[i.getRegister()]++;
                    i = instructionList.get(i.getFirstJump());
                    break;
                case SUB:
                    if (registers[i.getRegister()] > 0) {
                        registers[i.getRegister()]--;
                        i = instructionList.get(i.getFirstJump());
                    } else {
                        i = instructionList.get(i.getSecondJump());
                    }
                    break;
            }
    }
}
