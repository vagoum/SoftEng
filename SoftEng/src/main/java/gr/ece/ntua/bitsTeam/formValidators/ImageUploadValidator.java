package gr.ece.ntua.bitsTeam.formValidators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageUploadValidator implements Validator {
	public static final String PNG_MIME_TYPE = "image/png";
	public static final String JPG_MIME_TYPE = "image/jpg";
	public static final long TWO_MB_IN_BYTES = 2000000;

	@Override
	public boolean supports(Class<?> clazz) {
		return MultipartFile.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MultipartFile file = (MultipartFile) target;
		if (file.isEmpty()) {
			errors.rejectValue("file", "upload.file.required");
		} else if (!PNG_MIME_TYPE.equalsIgnoreCase(file.getContentType()) && !JPG_MIME_TYPE.equalsIgnoreCase(file.getContentType())) {
			errors.rejectValue("file", "upload.invalid.file.type");
		}

		else if (file.getSize() > TWO_MB_IN_BYTES) {
			errors.rejectValue("file", "upload.exceeded.file.size");
		}

	}

}