package me.yemss.julius;

import java.util.Scanner;

public class Julius {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phrase to encrypt");
        String plain = sc.nextLine();
        System.out.println("Enter key");
        int key = requestInt(sc);

        StringBuilder build = new StringBuilder();

        for(char character : plain.toCharArray()) {
            if (character == ' ')
                build.append(' ');
            else {
                int newCodepoint = character + key;
                while (newCodepoint < 97)
                    newCodepoint += 26;
                while(newCodepoint > 122)
                    newCodepoint -= 26;
                build.append(Character.toChars(newCodepoint));
            }
        }
        System.out.println(build.toString());
    }

    private static int requestInt(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Enter a valid number!");
            return requestInt(scanner);
        }
    }

}
