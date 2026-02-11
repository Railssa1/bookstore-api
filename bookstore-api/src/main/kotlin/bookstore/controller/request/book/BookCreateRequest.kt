package bookstore.controller.request.book

import com.fasterxml.jackson.annotation.JsonAlias
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal

data class BookCreateRequest(
    @field: NotEmpty(message = "O campo name deve ser preenchido")
    var name: String,

    @field: NotNull(message = "O campo price deve ser preenchido")
    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int,
)