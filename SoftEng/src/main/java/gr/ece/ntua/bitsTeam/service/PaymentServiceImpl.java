package gr.ece.ntua.bitsTeam.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.Payment;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.PaymentRepository;

public class PaymentServiceImpl {

	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public String executePayment(String email, Integer activityPoints) {
		Parent parent = parentRepository.findByEmail(email);
		Integer oldBalance = parent.getBalance();
		parent.setBalance(oldBalance + activityPoints);
		parentRepository.save(parent);
		
		Payment payment = new Payment(parent, new Date(), activityPoints);
		paymentRepository.save(payment);

		
		
		
		return "success";
	}
	
}
