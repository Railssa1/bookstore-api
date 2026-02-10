package bookstore.exception

class NotFoundException(
    override val message: String,
    val internalCode: String
): Exception()