package gr.ece.ntua.bitsTeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gr.ece.ntua.bitsTeam.model.Role;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.RoleRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getUserId() == null) {
        	
        	user.setBlocked(false);
        	user.setResetPassword(false);
        	
        	Role role = new Role();
        	role.setEmail(user.getEmail());
        	role.setAuthority("ROLE_UNAUTH");
        	role.setUser(user);
        	user.getRoles().add(role);
        	userRepository.save(user);
        }
    }
    
    @Override
    public void save(User user, String authority) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        if (user.getUserId() == null) {
        	

        	Role role = new Role();
        	role.setEmail(user.getEmail());
        	role.setAuthority(authority);
        	role.setUser(user);
        	user.getRoles().add(role);
        	userRepository.save(user);
        }
    }

	@Override
	public User findByEmail(String email) {
        return userRepository.findByEmail(email);

	}
}
