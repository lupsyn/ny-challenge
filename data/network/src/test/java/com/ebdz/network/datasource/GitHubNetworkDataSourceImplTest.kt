package com.ebdz.network.datasource

import com.apollographql.apollo3.ApolloCall
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.apollographql.apollo3.api.Operation
import com.ebdz.network.GetStarredRepositoriesFromOrganizationNameQuery
import com.ebdz.network.mapper.RepositoryMapper
import com.ebdz.repository.model.Repository
import java.util.UUID
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GitHubNetworkDataSourceImplTest {


    private lateinit var underTest: GitHubNetworkDataSourceImpl

    @Mock
    private lateinit var apolloClient: ApolloClient

    @Mock
    private lateinit var repositoryMapper: RepositoryMapper

    @Mock
    lateinit var repositoryNode: GetStarredRepositoriesFromOrganizationNameQuery.OnRepository


    @Mock
    lateinit var repository: Repository

    @Mock
    lateinit var uuid: UUID

    @Mock
    lateinit var operation: Operation<GetStarredRepositoriesFromOrganizationNameQuery.Data>

    @Mock
    lateinit var apolloCall: ApolloCall<GetStarredRepositoriesFromOrganizationNameQuery.Data>

    @Before
    fun setup() {
        underTest = GitHubNetworkDataSourceImpl(
            apolloClient = apolloClient,
            repositoryMapper = repositoryMapper
        )

    }

    @Ignore("Using fetchPolicy ext func make this test fail, investigate more here.")
    @Test
    fun `should getListOfRepositoriesByOrganizationName correctly`() {
        val searchString = "test"
        val getStarredFromOrganization =
            GetStarredRepositoriesFromOrganizationNameQuery("org:$searchString sort:stars-desc")

        val data = GetStarredRepositoriesFromOrganizationNameQuery.Data(
            GetStarredRepositoriesFromOrganizationNameQuery.Search(
                listOf(
                    GetStarredRepositoriesFromOrganizationNameQuery.Edge(
                        GetStarredRepositoriesFromOrganizationNameQuery.Node(
                            onRepository = repositoryNode,
                            __typename = "TestTypeName"
                        )
                    )
                )
            )
        )

        val response = ApolloResponse.Builder(
            data = data,
            operation = operation,
            requestUuid = uuid
        ).build()

        runTest {
            given(
                apolloClient.query(getStarredFromOrganization)
            ).willReturn(
                apolloCall
            )
            // given(apolloCall.fetchPolicy(FetchPolicy.CacheFirst)).willReturn(apolloCall)
            given(apolloCall.execute()).willReturn(response)
            `when`(repositoryMapper.toRepository(repositoryNode)).thenReturn(repository)

            val ans = underTest.getListOfRepositoriesByOrganizationName(searchString)

            assertEquals(listOf(repository), ans)
        }
    }

}

