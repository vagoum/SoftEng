package gr.ece.ntua.bitsTeam.model.jparepos;

import javax.transaction.Transactional;

import gr.ece.ntua.bitsTeam.model.Organizer;

@Transactional
public interface OrganizerRepository extends UserRepository<Organizer> {

}
