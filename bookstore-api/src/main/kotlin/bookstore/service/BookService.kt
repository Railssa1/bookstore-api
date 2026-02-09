package bookstore.service

import bookstore.enums.BookStatus
import bookstore.model.BookModel
import bookstore.model.CustomerModel
import bookstore.repository.BookRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
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

    fun getAll(pageable: Pageable): Page<BookModel> {
        return bookRepository.findAll(pageable)
    }

    fun getActive(pageable: Pageable): Page<BookModel> {
        return bookRepository.findByStatus(BookStatus.ATIVO, pageable)
    }

    fun delete(id: Int) {
        val book = getById(id)
        book.status = BookStatus.CANCELADO

        update(book)
    }

    fun update(book: BookModel) {
        bookRepository.save(book)
    }

    fun findByCustomer(customer: CustomerModel) {
        val books = bookRepository.findByCustomer(customer)

        for(book in books) {
            book.status = BookStatus.DELETADO
        }

        bookRepository.saveAll(books)
    }

}