package com.estore.context

import com.estore.user.entity.User
import java.util.*


class StoreRequestContext(override val locale: Locale, override val user: User) : GenericContext