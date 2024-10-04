import java.util.HashMap;
import java.util.Map;

class MorseNode {
    char letter;
    MorseNode left;
    MorseNode right;

    MorseNode() {
        this.letter = '\0';
    }

    MorseNode(char letter) {
        this.letter = letter;
    }
}

class MorseTree {
    private MorseNode root;
    private Map<Character, String> morseMap;

    public MorseTree() {
        root = new MorseNode();
        morseMap = new HashMap<>();
        initializeMorseMap();
    }

    private void initializeMorseMap() {
        morseMap.put('A', ".-"); morseMap.put('B', "-...");
        morseMap.put('C', "-.-."); morseMap.put('D', "-..");
        morseMap.put('E', "."); morseMap.put('F', "..-.");
        morseMap.put('G', "--."); morseMap.put('H', "....");
        morseMap.put('I', ".."); morseMap.put('J', ".---");
        morseMap.put('K', "-.-"); morseMap.put('L', ".-..");
        morseMap.put('M', "--"); morseMap.put('N', "-.");
        morseMap.put('O', "---"); morseMap.put('P', ".--.");
        morseMap.put('Q', "--.-"); morseMap.put('R', ".-.");
        morseMap.put('S', "..."); morseMap.put('T', "-");
        morseMap.put('U', "..-"); morseMap.put('V', "...-");
        morseMap.put('W', ".--"); morseMap.put('X', "-..-");
        morseMap.put('Y', "-.--"); morseMap.put('Z', "--..");
        morseMap.put('1', ".----"); morseMap.put('2', "..---");
        morseMap.put('3', "...--"); morseMap.put('4', "....-");
        morseMap.put('5', "....."); morseMap.put('6', "-....");
        morseMap.put('7', "--..."); morseMap.put('8', "---..");
        morseMap.put('9', "----."); morseMap.put('0', "-----");
    }

    public void buildTree() {
        for (Map.Entry<Character, String> entry : morseMap.entrySet()) {
            insert(entry.getKey(), entry.getValue());
        }
    }

    private void insert(char letter, String morseCode) {
        MorseNode current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                if (current.left == null) {
                    current.left = new MorseNode();
                }
                current = current.left;
            } else if (symbol == '-') {
                if (current.right == null) {
                    current.right = new MorseNode();
                }
                current = current.right;
            }
        }
        current.letter = letter;
    }

    public char morseToChar(String morseCode) {
        MorseNode current = root;
        for (char symbol : morseCode.toCharArray()) {
            if (symbol == '.') {
                current = current.left;
            } else if (symbol == '-') {
                current = current.right;
            }
            if (current == null) {
                return '?';
            }
        }
        return current.letter != '\0' ? current.letter : '?';
    }

    public String decodeMorse(String morseMessage) {
        String[] morseLetters = morseMessage.split(" ");
        StringBuilder decodedMessage = new StringBuilder();

        for (String morseLetter : morseLetters) {
            if (morseLetter.equals("/")) {
                decodedMessage.append(' ');
            } else {
                decodedMessage.append(morseToChar(morseLetter));
            }
        }
        return decodedMessage.toString();
    }

    public void printTree() {
        printTreeHelper(root, 0);
    }

    private void printTreeHelper(MorseNode node, int level) {
        if (node == null) return;

        if (node.letter != '\0') {
            System.out.println("  ".repeat(level) + node.letter);
        }
        if (node.left != null) {
            System.out.println("  ".repeat(level) + "Esquerda:");
            printTreeHelper(node.left, level + 1);
        }
        if (node.right != null) {
            System.out.println("  ".repeat(level) + "Direita:");
            printTreeHelper(node.right, level + 1);
        }
    }
}
