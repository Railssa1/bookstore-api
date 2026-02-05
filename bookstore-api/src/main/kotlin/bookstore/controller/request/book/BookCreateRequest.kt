package bookstore.controller.request.book

import com.fasterxml.jackson.annotation.JsonAlias
import java.math.BigDecimal

data class BookCreateRequest(
    var name: String,

    var price: BigDecimal,

    @JsonAlias("customer_id")
    var customerId: Int,
)