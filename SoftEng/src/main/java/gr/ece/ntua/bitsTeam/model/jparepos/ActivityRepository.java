package gr.ece.ntua.bitsTeam.model.jparepos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vividsolutions.jts.geom.Geometry;

import gr.ece.ntua.bitsTeam.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
	

}
