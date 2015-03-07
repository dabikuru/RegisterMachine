package dcultrera.registerMachine;


public class Instruction {
    private InstrType type;
    private int[] body;


    public Instruction(String instr) throws InstructionFormatException {
        /* example program:
            L0  -   1   1   2
            L1  +   0   0
            L2  -   2   3   4
            L3  +   0   2
            L4  H
         */

        String[] args = instr.split("\\s+");

        String type = args[1];
        this.body = new int[5];

        switch (type) {
            case "+":
                this.type = InstrType.ADD;
                this.body[0] = Integer.parseInt(args[2]);
                this.body[1] = Integer.parseInt(args[3]);
                break;
            case "-":
                this.type = InstrType.SUB;
                this.body[0] = Integer.parseInt(args[2]);
                this.body[1] = Integer.parseInt(args[3]);
                this.body[2] = Integer.parseInt(args[4]);
                break;
            case "H":
                this.type = InstrType.HALT;
                break;
            case "E":
                this.type = InstrType.EXIT;
                break;
            default:
                throw new InstructionFormatException("Invalid instruction type");
        }
    }

    public InstrType getType() {
        return type;
    }

    public int getRegister() {
        return this.body[0];
    }

    public int getFirstJump() {
        return this.body[1];
    }

    public int getSecondJump() {
        return this.body[2];
    }
}