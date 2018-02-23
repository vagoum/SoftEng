package gr.ece.ntua.bitsTeam.service;

import gr.ece.ntua.bitsTeam.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
}
