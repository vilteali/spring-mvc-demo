package ar.alicode.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StudentCodeConstraintValidator 
	implements ConstraintValidator<StudentCode, String> {
	
	private String codeValidate;
	
	@Override 
	public void initialize(StudentCode myStudentCode) {
		codeValidate = myStudentCode.value();
	}
		
	@Override
	public boolean isValid(String studentCode, ConstraintValidatorContext context) {
		boolean result;
		
		if (studentCode != null) 
			result = studentCode.startsWith(codeValidate);
				result = true;
		
		return result;

	}

}
