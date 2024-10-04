import java.util.Scanner;

public class MorseCodeDecoder {

    public static void main(String[] args) {

        MorseTree morseTree = new MorseTree();
        morseTree.buildTree();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código Morse a ser decodificado (use '/' para espaços entre palavras):");
        String morseInput = scanner.nextLine();

        String decodedMessage = morseTree.decodeMorse(morseInput);
        System.out.println("Mensagem decodificada: " + decodedMessage);

        System.out.println("\nEstrutura da Árvore Morse:");
        morseTree.printTree();

        scanner.close();
    }
}
