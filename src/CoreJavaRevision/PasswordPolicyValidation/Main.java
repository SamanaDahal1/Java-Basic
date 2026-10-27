package CoreJavaRevision.PasswordPolicyValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner src = new Scanner(System.in);
            System.out.print("Create Username: ");
            String userName = src.nextLine();
            System.out.print("Create Password: ");
            String password = src.nextLine();
            PasswordValidation passwordValidation = new PasswordValidation(password,new User(userName));
            passwordValidation.validation();

    }
}
