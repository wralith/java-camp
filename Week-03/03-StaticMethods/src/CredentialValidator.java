public class CredentialValidator {
    public static boolean isValid(LoginCredentials credentials) {
        if (!checkLength(credentials.getUsername()) || !checkLength(credentials.getEmail())
                || !checkLength(credentials.getPassword())) {
            return false;
        }

        if (!credentials.getEmail().contains("@")) {
            return false;
        }

        return true;
    }

    private static boolean checkLength(String s) {
        if (s.length() < 5) {
            return false;
        }
        return true;
    }
}
