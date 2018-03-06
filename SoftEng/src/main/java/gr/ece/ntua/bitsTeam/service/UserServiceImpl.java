package gr.ece.ntua.bitsTeam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gr.ece.ntua.bitsTeam.model.PasswordResetToken;
import gr.ece.ntua.bitsTeam.model.Role;
import gr.ece.ntua.bitsTeam.model.User;
import gr.ece.ntua.bitsTeam.model.jparepos.PasswordTokenRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
    @SuppressWarnings("rawtypes")
	@Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordTokenRepository passwordTokenRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    
	@SuppressWarnings("unchecked")
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
    
    @SuppressWarnings("unchecked")
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
	
	public void createPasswordResetTokenForUser(User user, String token) {
	    PasswordResetToken myToken = new PasswordResetToken(token, user);
	    passwordTokenRepository.save(myToken);
	}
	
	@SuppressWarnings("unchecked")
	public void changeUserPassword(User user, String password) {
	    user.setPassword(bCryptPasswordEncoder.encode(password));
	    userRepository.save(user);
	}
	
	@Override
    public boolean checkIfValidOldPassword(User user, String oldPassword) {
        return bCryptPasswordEncoder.matches(oldPassword, user.getPassword());
	}
}
