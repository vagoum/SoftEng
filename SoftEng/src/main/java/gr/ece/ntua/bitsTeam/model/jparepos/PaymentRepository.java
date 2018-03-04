package gr.ece.ntua.bitsTeam.model.jparepos;

import org.springframework.data.jpa.repository.JpaRepository;

import gr.ece.ntua.bitsTeam.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
