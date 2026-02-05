package bookstore.controller.request.book

import java.math.BigDecimal

data class BookUpdateRequest (
    val name: String?,
    val price: BigDecimal?
)
