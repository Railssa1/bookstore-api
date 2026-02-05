package bookstore.controller.response.book

import bookstore.enums.CustomerStatus

data class CustomerResponse (
    val id: Int?,
    val name: String,
    val email: String,
    val status: CustomerStatus
)