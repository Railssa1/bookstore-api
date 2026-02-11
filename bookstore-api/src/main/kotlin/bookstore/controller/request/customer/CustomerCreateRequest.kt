package bookstore.controller.request.customer

import bookstore.validation.EmailAvaible
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty

data class CustomerCreateRequest (
    @field: NotEmpty(message = "O campo name deve ser preenchido")
    var name: String,

    @field: Email(message = "O e-mail deve ser válido")
    @EmailAvaible
    var email: String
)