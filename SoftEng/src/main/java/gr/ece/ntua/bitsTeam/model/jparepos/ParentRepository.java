package gr.ece.ntua.bitsTeam.model.jparepos;

import javax.transaction.Transactional;

import gr.ece.ntua.bitsTeam.model.Parent;

@Transactional
public interface ParentRepository  extends UserRepository<Parent> {
	
}
