package bookstore.enums

enum class Errors(val code: String, val message: String) {
    BS001("BS-001", "Invalid request"),
    BS101("BS-101", "book %s not exists"),
    BS102("BS-102","Cannot update book with status %s"),
    BS201("BS-102", "customer %s not exists")
}