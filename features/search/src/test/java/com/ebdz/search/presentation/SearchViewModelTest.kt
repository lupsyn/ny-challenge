package com.ebdz.search.presentation

import com.ebdz.domain.model.Repository
import com.ebdz.domain.usecase.GetListOfRepositoriesUseCase
import com.ebdz.search.mapper.RepositoryMapper
import com.ebdz.test.CoroutineTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import com.ebdz.search.model.Repository as ViewRepository

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {
    @Mock
    private lateinit var getListOfRepositoriesUseCase: GetListOfRepositoriesUseCase

    @Mock
    private lateinit var repositoryMapper: RepositoryMapper

    private lateinit var underTest: SearchViewModel

    private
    val repository = Repository(
        id = "Id",
        name = "name",
        openGraphImageUrl = "openGraphImageUrl",
        stargazerCount = 0,
        url = "url",
        shortDescriptionHTML = "shortDescriptionHTML"
    )

    private val viewRpository = ViewRepository(
        id = "Id",
        name = "name",
        openGraphImageUrl = "openGraphImageUrl",
        stargazerCount = 0,
        url = "url",
        shortDescriptionHTML = "shortDescriptionHTML"
    )

    @Before
    fun setup() {
        underTest = SearchViewModel(getListOfRepositoriesUseCase, repositoryMapper)
    }

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    @Test
    fun `when load account then loaded state is emitted`() {
        val searchString = "toSearch"
        val flowObserve = underTest.searchState
        runTest {
            given(getListOfRepositoriesUseCase.invoke(searchString)).willReturn(listOf(repository))

            given(repositoryMapper.toView(repository)).willReturn(viewRpository)

            underTest.onSearchTextChanged(searchString)
            underTest.onLaunchSearch()

            val expectedState = SearchState.Loaded(listOf(viewRpository))

            assertEquals(expectedState, flowObserve.value)
        }
    }

    @Test
    fun `should return error in case of repository fails`() {
        val searchString = "123"
        val flowObserve = underTest.searchState
        val anError = Throwable("Generic Error")

        runTest {
            given(getListOfRepositoriesUseCase.invoke(searchString)).willAnswer { throw anError }

            underTest.onSearchTextChanged(searchString)
            underTest.onLaunchSearch()

            val expectedState = SearchState.Error(anError)

            assertEquals(expectedState, flowObserve.value)
        }
    }
}
