public class Rotor {
    private String rotorValues;   
    private final String initialValues; 
    private final char startChar; 

    public Rotor(String rotorConfig, char startChar) {
        this.rotorValues = rotorConfig;
        this.initialValues = rotorConfig;
        this.startChar = startChar;

        while (rotorValues.charAt(0) != startChar) {
            rotate();
        }
    }

    public boolean rotate() {
        rotorValues = rotorValues.charAt(rotorValues.length() - 1) + rotorValues.substring(0, rotorValues.length() - 1);
        return rotorValues.equals(initialValues);
    }

    public int indexOf(char c) {
        return rotorValues.indexOf(c);
    }

    public char charAt(int index) {
        return rotorValues.charAt(index);
    }
}