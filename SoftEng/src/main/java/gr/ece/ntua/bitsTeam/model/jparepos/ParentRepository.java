package gr.ece.ntua.bitsTeam.model.jparepos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gr.ece.ntua.bitsTeam.model.User;

@Repository
public interface ParentRepository  extends JpaRepository<User, Long> {

}
