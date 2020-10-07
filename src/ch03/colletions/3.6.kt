package ch03.colletions

import java.lang.IllegalArgumentException

fun main() {
    val user: User = User(100001, "", "")
    saveUser(user)
}

class User(val id: Int, val name: String, val address: String)

    fun User.validateBeforeSave() {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException(
                    "Can't save user $id: empty $fieldName")
            }
        }
        validate(name, "Name")
        validate(address, "Address")
    }

fun saveUser(user: User) {
    user.validateBeforeSave()
}
   /*
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
            "Can't save user $user.id: empty Name"
        )
        if (user.address.isEmpty()) {
            throw IllegalArgumentException(
                "Can't save user $user.id: empty Address"
            )
        }
    }
    */