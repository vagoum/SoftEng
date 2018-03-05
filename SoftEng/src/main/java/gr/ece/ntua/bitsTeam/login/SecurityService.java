package gr.ece.ntua.bitsTeam.login;

import gr.ece.ntua.bitsTeam.model.User;

public interface SecurityService {
    String findLoggedInUsername();

    void autologin(String email, String password);
    
    public String validatePasswordResetToken(long id, String token);
    
    
}
