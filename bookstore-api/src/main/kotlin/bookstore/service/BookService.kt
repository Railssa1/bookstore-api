package bookstore.service

import bookstore.enums.BookStatus
import bookstore.model.BookModel
import bookstore.repository.BookRepository
import org.springframework.stereotype.Service

@Service
class BookService(
    val bookRepository: BookRepository
) {

    fun create(book: BookModel) {
        bookRepository.save(book)
    }

    fun getById(id: Int): BookModel {
        return bookRepository.findById(id).get()
    }

    fun getAll(): List<BookModel> {
        return bookRepository.findAll().toList()
    }

    fun getActive(): List<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO)
    }

    fun delete(id: Int) {
        val book = getById(id)
        book.status = BookStatus.CANCELADO

        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

}