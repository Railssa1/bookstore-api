package bookstore.controller.request.customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CustomerUpdateRequest (
    @field: NotEmpty(message = "O campo name deve ser preenchido")
    var name: String,

    @field: Email(message = "O e-mail deve ser válido")
    var email: String
)