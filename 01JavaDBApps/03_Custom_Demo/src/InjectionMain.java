

import java.util.Scanner;

public class InjectionMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String statement = "SELECT * FROM users WHERE username = '%s' AND password = '%s'";
        String username = scanner.nextLine();
        String password = scanner.nextLine();

        System.out.printf(statement, username, password);


    }
}


