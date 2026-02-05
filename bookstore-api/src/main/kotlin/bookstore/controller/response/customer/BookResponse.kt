package bookstore.controller.response.customer

import bookstore.enums.BookStatus
import bookstore.model.CustomerModel
import java.math.BigDecimal

data class BookResponse (
    val id: Int?,
    val name: String,
    val price: BigDecimal,
    val customer: CustomerModel?,
    val status: BookStatus?
)