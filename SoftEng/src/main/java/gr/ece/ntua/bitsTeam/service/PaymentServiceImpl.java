package gr.ece.ntua.bitsTeam.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gr.ece.ntua.bitsTeam.model.Parent;
import gr.ece.ntua.bitsTeam.model.Payment;
import gr.ece.ntua.bitsTeam.model.jparepos.ParentRepository;
import gr.ece.ntua.bitsTeam.model.jparepos.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private ParentRepository parentRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Transactional
	public String executePayment(String email, Integer activityPoints) {
		String status = "fail";
		Parent parent = parentRepository.findByEmail(email);
		if ((parent.getPointsToReward() < 100) && (parent.getPointsToReward() + activityPoints >= 100)) {
			status = "reward:" + ((parent.getPointsToReward() + activityPoints)/100)*15;
			parent.setBalance(parent.getBalance() + activityPoints + ((parent.getPointsToReward() + activityPoints)/100)*15);
			parent.setPointsToReward((parent.getBalance() + activityPoints) % 100);
			
		}
		else {
			parent.setBalance(parent.getBalance() + activityPoints);
			parent.setPointsToReward(parent.getPointsToReward() + activityPoints);
			status = "success";
		}
		parentRepository.save(parent);
		
		Payment payment = new Payment(parent, new Date(), activityPoints);
		paymentRepository.save(payment);
		return status;
	}
	
}
