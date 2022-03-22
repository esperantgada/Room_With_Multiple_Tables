package eg.esperantgada.roommultipletables.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import eg.esperantgada.roommultipletables.repository.AllItemsRepository
import javax.inject.Inject

@HiltViewModel
class AllItemsViewModel @Inject constructor(
    private val allItemsRepository: AllItemsRepository) : ViewModel() {

    /**
     * Gets all schools from the database
     */

    val schools = allItemsRepository.getAllSchools().cachedIn(viewModelScope)


    /**
     * Gets all directors from the database
     */
    val directors = allItemsRepository.getAllDirector().cachedIn(viewModelScope)


    /**
     * Gets all courses from the database
     */
    val courses = allItemsRepository.getAllCourses().cachedIn(viewModelScope)

    /**
     * Gets all students from the database
     */
    val students = allItemsRepository.getAllStudents().cachedIn(viewModelScope)


    /**
     * Gets all students and courses
     */
    val studentAndCourses = allItemsRepository.getAllStudentsAndCourses().cachedIn(viewModelScope)

}