package CoreJavaRevision.PasswordPolicyValidation;

import java.util.regex.Pattern;

public class PasswordValidation {
    boolean valid = true;
    final String password;
    User user;

    PasswordValidation(String password, User user) {
        this.password = password;
        this.user = user;
    }


    boolean checkLength(String password) {
        if (password.length() < 8) {
            return false;
        }
        return true;
    }

    boolean checkUpperCase(String password) {
        char c = 'Z';
        for (int i = 0; i < password.length(); i++) {
            c = password.charAt(i);
            if (Character.isUpperCase(c)) {
               return true;
            }
        }
        return false;
    }

    boolean checkLowerCase(String password) {
        char s = 'z';
        for (int i = 0; i < password.length(); i++) {
            s = password.charAt(i);
            if (Character.isLowerCase(s)) {
                return true;
            }
        }
        return false;

    }

    boolean checkDigit(String password) {
        char a = 'z';
        for (int k = 0; k < password.length(); k++) {
            a = password.charAt(k);
        if (Character.isDigit(a)) {
            return true;
        }}
        return false;
    }
    boolean checkSpecialChar(String password){
        boolean hasSpecialChar = Pattern.compile("[^a-zA-Z0-9]").matcher(password).find();
        if (!hasSpecialChar) {
            return false;
        }
        return true;
    }
    boolean checkSpace(String password){
        char space = 'z';
        for (int l = 0; l < password.length(); l++) {
            space = password.charAt(l);
        if (Character.isSpaceChar(space)) {
            return true;
        }}
        return false;
    }
    boolean checkSimilarity (String password){
        if (password.toLowerCase().contains(user.userName.toLowerCase())) {
            return false;
        }
        return true;
    }

    public void validation() {
            if (!checkLength(password)) {
                System.out.println("Password must contain minimum 8 character");
                valid = false;
            }
            if (!checkUpperCase(password)) {
                System.out.println("Password must contain atleast 1 Uppercase letter");
                valid = false;
            }
            if (!checkLowerCase(password)) {
                System.out.println("Password must contain atleast 1 Lowercase letter");
                valid = false;
            }
            if (!checkDigit(password)) {
                System.out.println("Password must contain atleast 1 Digit");
                valid = false;
            }
            if (!checkSpecialChar(password)) {
                System.out.println("Password must contain atleast 1 Special Character");
                valid = false;
            }
            if (!checkSpace(password)) {
                System.out.println("Password must not contain space");
                valid = false;
            }
            if (!checkSimilarity(password)) {
                System.out.println("Password must not contain username");
                valid = false;
            }
            if (valid) {
                System.out.println("Account Created");
            }
    }

}