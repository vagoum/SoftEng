package gr.ece.ntua.bitsTeam.formValidators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import gr.ece.ntua.bitsTeam.model.ActivityDetails;

@Component
public class ActivityValidator implements Validator {

   @Override
   public boolean supports(Class<?> clazz) {
      return ActivityDetails.class.equals(clazz);
   }

   @Override
   public void validate(Object obj, Errors err) {

      ValidationUtils.rejectIfEmpty(err, "name", "activitydetails.name.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "cost", "activitydetails.cost.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "ticketNumber", "activitydetails.ticketNumber.empty");
      ValidationUtils.rejectIfEmptyOrWhitespace(err, "date", "activitydetails.date.empty");
    
   }

}
