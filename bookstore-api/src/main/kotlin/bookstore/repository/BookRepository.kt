package bookstore.repository

import bookstore.enums.BookStatus
import bookstore.model.BookModel
import bookstore.model.CustomerModel
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface BookRepository: JpaRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus, pageable: Pageable): Page<BookModel>
    fun findByCustomer(customer: CustomerModel): List<BookModel>
}