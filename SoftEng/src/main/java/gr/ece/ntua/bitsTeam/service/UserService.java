package gr.ece.ntua.bitsTeam.service;

import gr.ece.ntua.bitsTeam.model.User;

public interface UserService {
    void save(User user);
    void save(User user, String authority);

    User findByEmail(String email);
}
