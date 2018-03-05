package gr.ece.ntua.bitsTeam.service;

import gr.ece.ntua.bitsTeam.model.User;

public interface UserService {
    void save(User user);
    void save(User user, String authority);

    User findByEmail(String email);
    
    void createPasswordResetTokenForUser(User user, String token);
    
    public void changeUserPassword(User user, String password);
    
    public boolean checkIfValidOldPassword(User user, String oldPassword);
}
