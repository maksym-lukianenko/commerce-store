package com.estore.converter

import java.sql.Date
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter(autoApply = true)
class LocalDateConverter : AttributeConverter<LocalDate, Date> {

    override fun convertToDatabaseColumn(attribute: LocalDate?): Date? {
        return if (attribute != null) Date.valueOf(attribute) else null
    }

    override fun convertToEntityAttribute(dbData: Date?): LocalDate? = dbData?.toLocalDate()
}