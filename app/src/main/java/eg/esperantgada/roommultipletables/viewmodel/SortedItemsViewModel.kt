package eg.esperantgada.roommultipletables.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import eg.esperantgada.roommultipletables.repository.SortedItemsRepository
import eg.esperantgada.roommultipletables.utils.Constants
import javax.inject.Inject

@HiltViewModel
class SortedItemsViewModel @Inject constructor(
    state : SavedStateHandle,
    private val sortedItemsRepository: SortedItemsRepository) : ViewModel(){

    private val searchQuery = state.getLiveData(Constants.CURRENT_QUERY, Constants.CURRENT_QUERY)

    fun setQuery(query : String){
        searchQuery.value = query
    }


    val sortedSchoolList = searchQuery.switchMap { newQuery ->
        sortedItemsRepository.getSortedSchools(newQuery).cachedIn(viewModelScope)
    }

    val sortedDirectorList = searchQuery.switchMap { newQuery ->
        sortedItemsRepository.getSortedDirector(newQuery).cachedIn(viewModelScope)
    }

    val sortedCourseList = searchQuery.switchMap { newQuery ->
        sortedItemsRepository.getSortedCourses(newQuery).cachedIn(viewModelScope)
    }

    val sortedStudentList = searchQuery.switchMap { newQuery ->
        sortedItemsRepository.getSortedStudents(newQuery).cachedIn(viewModelScope)
    }

    val sortedStudentAndCourseList = searchQuery.switchMap { newQuery ->
        sortedItemsRepository.getSortedStudentsAndCourses(newQuery).cachedIn(viewModelScope)
    }

}