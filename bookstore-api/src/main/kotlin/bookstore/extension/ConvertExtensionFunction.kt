package bookstore.extension

import bookstore.controller.request.customer.CustomerCreateRequest
import bookstore.controller.request.customer.CustomerUpdateRequest
import bookstore.model.CustomerModel

fun CustomerCreateRequest.toCustomerModel(): CustomerModel {
    return CustomerModel(name = this.name, email = this.email)
}

fun CustomerUpdateRequest.toCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id, this.name, this.email)
}
