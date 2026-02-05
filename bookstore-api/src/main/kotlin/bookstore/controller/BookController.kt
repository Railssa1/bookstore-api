package bookstore.controller

import bookstore.controller.request.book.BookCreateRequest
import bookstore.controller.request.book.BookUpdateRequest
import bookstore.extension.toBookModel
import bookstore.service.BookService
import bookstore.service.CustomerService
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
    fun getById(@PathVariable id: Int) = bookService.getById(id)

    @GetMapping
    fun getAll() = bookService.getAll()

    @GetMapping("/active")
    fun getActive() = bookService.getActive()

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