package bookstore.controller

import bookstore.controller.request.book.BookCreateRequest
import bookstore.controller.request.book.BookUpdateRequest
import bookstore.controller.response.customer.BookResponse
import bookstore.extension.toBookModel
import bookstore.extension.toBookResponse
import bookstore.service.BookService
import bookstore.service.CustomerService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(
    val bookService: BookService,
    val customerService: CustomerService
) {

    @PostMapping
    fun create(@RequestBody book: BookCreateRequest) {
        val customer = customerService.getById(book.customerId)
        bookService.create(book.toBookModel(customer))
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Int): BookResponse {
        return bookService.getById(id).toBookResponse()
    }

    @GetMapping
    fun getAll(@PageableDefault(page = 0, size = 10) pageable: Pageable): Page<BookResponse> {
        return bookService.getAll(pageable).map { it.toBookResponse() }
    }

    @GetMapping("/active")
    fun getActive(@PageableDefault(page = 0, size = 0) pageable: Pageable): Page<BookResponse> {
        return bookService.getActive(pageable).map { it.toBookResponse() }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: Int) = bookService.delete(id)

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody book: BookUpdateRequest) {
        val bookSaved = bookService.getById(id)
        bookService.update(book.toBookModel(bookSaved))
    }


}