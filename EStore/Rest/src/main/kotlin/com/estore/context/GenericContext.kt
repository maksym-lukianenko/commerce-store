package com.estore.context

import com.estore.user.entity.User
import java.util.*

interface GenericContext {

    val locale: Locale
    val user: User
}