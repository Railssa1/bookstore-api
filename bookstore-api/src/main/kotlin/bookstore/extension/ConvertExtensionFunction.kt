package bookstore.extension

import bookstore.controller.request.book.BookCreateRequest
import bookstore.controller.request.book.BookUpdateRequest
import bookstore.controller.request.customer.CustomerCreateRequest
import bookstore.controller.request.customer.CustomerUpdateRequest
import bookstore.enums.BookStatus
import bookstore.model.BookModel
import bookstore.model.CustomerModel

fun CustomerCreateRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun CustomerUpdateRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id, this.name, this.email)
}

fun BookCreateRequest.toBookModel(customer: CustomerModel): BookModel {
    return BookModel(
        name = this.name,
        price = this.price,
        status = BookStatus.ATIVO,
        customer = customer
    )
}

fun BookUpdateRequest.toBookModel(book: BookModel): BookModel {
    return BookModel(
        id = book.id,
        name = this.name ?: book.name,
        price = this.price ?: book.price,
        status = book.status,
        customer = book.customer
    )
}