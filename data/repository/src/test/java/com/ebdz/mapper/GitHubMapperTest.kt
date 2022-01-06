package com.ebdz.mapper

import com.ebdz.repository.mapper.GitHubMapper
import com.ebdz.repository.model.Repository
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test

import com.ebdz.domain.model.Repository as DomainRepository

class GitHubMapperTest {
    private lateinit var underTest: GitHubMapper

    @Before
    fun setup() {
        underTest = GitHubMapper()
    }

    @Test
    fun `should return view account`() {
        val repo = Repository(
            id = "Id",
            name = "name",
            openGraphImageUrl = "openGraphImageUrl",
            stargazerCount = 0,
            url = "url",
            shortDescriptionHTML = "shortDescriptionHTML"
        )

        val expectedValue = DomainRepository(
            id = "Id",
            name = "name",
            openGraphImageUrl = "openGraphImageUrl",
            stargazerCount = 0,
            url = "url",
            shortDescriptionHTML = "shortDescriptionHTML"
        )

        val mappedValue = underTest.toDomain(repo)

        assertEquals(expectedValue, mappedValue)
    }
}
