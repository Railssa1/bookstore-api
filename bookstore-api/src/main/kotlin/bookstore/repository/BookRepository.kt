package bookstore.repository

import bookstore.enums.BookStatus
import bookstore.model.BookModel
import org.springframework.data.repository.CrudRepository

interface BookRepository: CrudRepository<BookModel, Int> {
    fun findByStatus(status: BookStatus): List<BookModel>
}