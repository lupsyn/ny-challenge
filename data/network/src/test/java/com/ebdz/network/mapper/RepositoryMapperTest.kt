package com.ebdz.network.mapper

import android.text.Spannable
import com.ebdz.network.GetStarredRepositoriesFromOrganizationNameQuery
import com.ebdz.repository.model.Repository
import junit.framework.TestCase.assertEquals
import okhttp3.HttpUrl.Companion.toHttpUrlOrNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class RepositoryMapperTest {
    private lateinit var underTest: RepositoryMapper

    @Mock
    private lateinit var spanString: Spannable

    @Before
    fun setup() {
        underTest = RepositoryMapper()
    }

    @Test
    fun shouldMapRepositoryCorrectly() {
        val stub = GetStarredRepositoriesFromOrganizationNameQuery.OnRepository(
            id = "id",
            name = "name",
            openGraphImageUrl = "http://www.anImage.it".toHttpUrlOrNull()!!,
            stargazerCount = 0,
            url = "http://www.google.it".toHttpUrlOrNull()!!,
            shortDescriptionHTML = spanString
        )

        given(spanString.toString()).willReturn("test")

        val result = Repository(
            id = "id",
            name = "name",
            openGraphImageUrl = "http://www.animage.it/",
            stargazerCount = 0,
            url = "http://www.google.it/",
            shortDescriptionHTML = "test"
        )

        val toCheck = underTest.toRepository(stub)

        assertEquals(toCheck, result)
    }
}
