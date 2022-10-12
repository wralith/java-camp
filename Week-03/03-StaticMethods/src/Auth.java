public class Auth {
    public void RequestLogin(LoginCredentials credentials) {
        if (CredentialValidator.isValid(credentials)) {
            System.out.printf("Login request with username `%s` sended to auth service\n",
                    credentials.getUsername());
        } else {
            System.out.println("Invalid request");
        }
    }
}
