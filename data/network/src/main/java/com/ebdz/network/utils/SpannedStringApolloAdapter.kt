package com.ebdz.network.utils

import android.text.Html
import android.text.Spanned
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonReader.Token.STRING
import com.apollographql.apollo3.api.json.JsonWriter

/**
 * An Apollo adapter for converting between URI types to HttpUrl.
 */
object SpannedStringApolloAdapter : Adapter<Spanned> {
    override fun fromJson(
        reader: JsonReader,
        customScalarAdapters: CustomScalarAdapters
    ): Spanned {
        return when (reader.peek()) {
            STRING -> Html.fromHtml(reader.nextString()!!)
            else -> throw IllegalArgumentException("Value wasn't a string!")
        }
    }

    override fun toJson(
        writer: JsonWriter,
        customScalarAdapters: CustomScalarAdapters,
        value: Spanned
    ) {
        writer.value(value.toString())
    }
}
