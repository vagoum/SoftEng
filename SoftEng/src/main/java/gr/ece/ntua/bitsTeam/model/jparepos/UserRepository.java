package gr.ece.ntua.bitsTeam.model.jparepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import gr.ece.ntua.bitsTeam.model.User;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> { 
	
	T findByEmail(String email);
	
    @Transactional
	void deleteByEmail(String email);
}