package controller;

import java.util.Scanner;

public class Utilitario {

    private static Scanner leitor = new Scanner(System.in);

    public static String getInputString(String texto) {
        System.out.print(texto);
        String input = leitor.nextLine();
        leitor = new Scanner(System.in); // Cria um novo Scanner para esvaziar o buffer
        return input;
    }

    public static int getInputInt(String texto) {
        System.out.print(texto);
        String valorDigitado = leitor.nextLine();
        leitor = new Scanner(System.in); // Cria um novo Scanner para esvaziar o buffer
        return Integer.parseInt(valorDigitado);
    }

    // Método para fechar o Scanner
    public static void fecharScanner() {
        leitor.close();
    }


    public static String getInputStringChat() {
        String input = leitor.nextLine();
        leitor = new Scanner(System.in); // Cria um novo Scanner para esvaziar o buffer
        return input;
    }


}
