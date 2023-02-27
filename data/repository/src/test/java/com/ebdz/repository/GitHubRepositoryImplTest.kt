package com.ebdz.repository

import com.ebdz.repository.datasource.GitHubNetworkDataSource
import com.ebdz.repository.mapper.GitHubMapper
import com.ebdz.repository.model.Repository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class GitHubRepositoryImplTest {

    private lateinit var underTest: GitHubRepositoryImpl

    @Mock
    private lateinit var networkDataSource: GitHubNetworkDataSource

    @Mock
    private lateinit var domainMapper: GitHubMapper

    @Mock
    private lateinit var repository: Repository

    @Mock
    private lateinit var domainRepository: com.ebdz.domain.model.Repository

    @Before
    fun setup() {
        underTest = GitHubRepositoryImpl(
            networkDataSource = networkDataSource,
            domainMapper = domainMapper
        )
    }

    @Test
    fun `should hit network once called`() {
        val stringSearch = "123"

        runBlocking {
            given(domainMapper.toDomain(repository)).willReturn(domainRepository)
            given(networkDataSource.getListOfRepositoriesByOrganizationName(stringSearch)).willReturn(
                listOf(repository)
            )

            val returnValue = underTest.getListOfRepositoriesByOrganizationName(stringSearch)

            assertEquals(returnValue, listOf(domainRepository))
            verify(networkDataSource).getListOfRepositoriesByOrganizationName(stringSearch)
        }
    }
}
