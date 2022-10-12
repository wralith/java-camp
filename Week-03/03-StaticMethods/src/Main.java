public class Main {
    public static void main(String[] args) {
        Auth auth = new Auth();

        LoginCredentials invalidByUsername =
                new LoginCredentials("user", "user@user.com", "password");
        LoginCredentials invalidByMissingEmail =
                new LoginCredentials("testuser", "useratuser.com", "password");
        LoginCredentials invalidByPassword =
                new LoginCredentials("testuser", "user@user.com", "pass");
        LoginCredentials validCredentials =
                new LoginCredentials("testuser", "user@user.com", "password");


        auth.RequestLogin(invalidByUsername);
        auth.RequestLogin(invalidByMissingEmail);
        auth.RequestLogin(invalidByPassword);
        auth.RequestLogin(validCredentials);
    }
}
