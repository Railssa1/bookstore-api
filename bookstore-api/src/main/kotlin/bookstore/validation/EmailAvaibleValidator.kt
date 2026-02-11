package bookstore.validation

import bookstore.service.CustomerService
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import kotlin.reflect.KClass

class EmailAvaibleValidator(
    var customerService: CustomerService
): ConstraintValidator<EmailAvaible, String> {

    override fun isValid(
        value: String?,
        context: ConstraintValidatorContext?
    ): Boolean {
        if(value.isNullOrEmpty()){
            return false
        }

        return customerService.emailAvailable(value)
    }

}
