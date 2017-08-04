package com.estore.exception

class ItemNotFoundException : RuntimeException {

    constructor(message: String, e: Exception?) : super(message, e)
    constructor(message: String) : super(message)
    constructor(e: Exception) : super(e)
}