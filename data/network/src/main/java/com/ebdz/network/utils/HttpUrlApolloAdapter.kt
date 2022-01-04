package com.ebdz.network.utils

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonReader.Token.STRING
import com.apollographql.apollo3.api.json.JsonWriter
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

/**
 * An Apollo adapter for converting between URI types to HttpUrl.
 */
object HttpUrlApolloAdapter : Adapter<HttpUrl> {
    override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters): HttpUrl {
        return when (reader.peek()) {
            STRING -> reader.nextString()!!.toHttpUrl()
            else -> throw IllegalArgumentException("Value wasn't a string!")
        }
    }

    override fun toJson(
        writer: JsonWriter,
        customScalarAdapters: CustomScalarAdapters,
        value: HttpUrl
    ) {
        writer.value(value.toString())
    }
}
