package gr.ece.ntua.bitsTeam.model.jparepos;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.ece.ntua.bitsTeam.model.User;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> { 
	
	T findByEmail(String email);
}