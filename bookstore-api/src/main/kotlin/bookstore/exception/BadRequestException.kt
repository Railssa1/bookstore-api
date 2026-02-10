package bookstore.exception

class BadRequestException(
    override val message: String,
    val internalCode: String
): Exception()