public class Enigma {

    private final String[] rotorConfigurations = {
        "#GNUAHOVBIPWCJQXDKRYELSZFMT",
        "#EJOTYCHMRWAFKPUZDINSXBGLQV",
        "#BDFHJLNPRTVXZACEGIKMOQSUWY",
        "#NWDKHGXZVRIFJBLMAOPSCYUTQE",
        "#TGOWHLIFMCSZYRVXQABUPEJKND"
    };

    private Rotor[] rotors; 

    public Enigma(int id1, int id2, int id3, String start) {
        rotors = new Rotor[3]; 

        rotors[0] = new Rotor(rotorConfigurations[id1 - 1], start.charAt(0));  // Inner rotor
        rotors[1] = new Rotor(rotorConfigurations[id2 - 1], start.charAt(1));  // Middle rotor
        rotors[2] = new Rotor(rotorConfigurations[id3 - 1], start.charAt(2));  // Outer rotor
    }

    public String encrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            char firstPass = rotors[0].charAt(rotors[0].indexOf(c));
            char secondPass = rotors[1].charAt(rotors[1].indexOf(firstPass));
            char thirdPass = rotors[2].charAt(rotors[2].indexOf(secondPass));

            result.append(thirdPass);
            rotate();
        }

        return result.toString();
    }

    public String decrypt(String message) {
        StringBuilder result = new StringBuilder();

        for (char c : message.toCharArray()) {
            int thirdPassIndex = rotors[2].indexOf(c);
            char secondPass = rotors[1].charAt(thirdPassIndex);
            int secondPassIndex = rotors[1].indexOf(secondPass);
            char firstPass = rotors[0].charAt(secondPassIndex);

            result.append(firstPass);

            rotate();
        }

        return result.toString();
    }

    private void rotate() {
        if (rotors[0].rotate()) {
            if (rotors[1].rotate()) {
                rotors[2].rotate();
            }
        }
    }
}