package com.ebdz.search.mapper

import com.ebdz.domain.model.Repository
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import com.ebdz.search.model.Repository as ViewRepository


class RepositoryMapperTest {
    private lateinit var underTest: RepositoryMapper

    @Before
    fun setup() {
        underTest = RepositoryMapper()
    }

    @Test
    fun `should return view account`() {
        val account = Repository(
            id = "Id",
            name = "name",
            openGraphImageUrl = "openGraphImageUrl",
            stargazerCount = 0,
            url = "url",
            shortDescriptionHTML = "shortDescriptionHTML"
        )

        val expectedValue = ViewRepository(
            id = "Id",
            name = "name",
            openGraphImageUrl = "openGraphImageUrl",
            stargazerCount = 0,
            url = "url",
            shortDescriptionHTML = "shortDescriptionHTML"
        )

        val mappedValue = underTest.toView(account)

        assertEquals(expectedValue, mappedValue)
    }
}
