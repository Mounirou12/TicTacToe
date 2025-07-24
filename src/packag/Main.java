package packag;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        new Frame();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ton mon: ");
        String name = scanner.nextLine();
        System.out.println(name);
        scanner.close();
    }

}
