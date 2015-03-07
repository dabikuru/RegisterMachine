package dcultrera.registerMachine;


public class Instruction {
    private InstrType type;
    private int[] body;


    public Instruction(String body) throws InstructionFormatException {
        /* example program:
            L0  -   1   1   2
            L1  +   0   0
            L2  -   2   3   4
            L3  +   0   2
            L4  H
         */

        String[] args = body.split("\t");

        String type = args[1];

        switch (type) {
            case "+":
                this.type = InstrType.ADD;


                break;
            case "-":
                this.type = InstrType.SUB;
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
}