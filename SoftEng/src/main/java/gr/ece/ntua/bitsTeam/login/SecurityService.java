package gr.ece.ntua.bitsTeam.login;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String email, String password);
}
