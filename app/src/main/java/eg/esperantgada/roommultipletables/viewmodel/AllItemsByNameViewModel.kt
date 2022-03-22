package eg.esperantgada.roommultipletables.viewmodel

import androidx.lifecycle.*
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import eg.esperantgada.roommultipletables.relationships.CourseAndStudent
import eg.esperantgada.roommultipletables.relationships.SchoolAndStudent
import eg.esperantgada.roommultipletables.relationships.StudentAndCourse
import eg.esperantgada.roommultipletables.repository.AllItemsByNameRepository
import eg.esperantgada.roommultipletables.utils.Constants
import javax.inject.Inject

@HiltViewModel
class AllItemsByNameViewModel @Inject constructor(
    state : SavedStateHandle,
    private val allItemsByNameRepository: AllItemsByNameRepository) : ViewModel() {

    private val name = state.getLiveData(Constants.CURRENT_QUERY, Constants.CURRENT_QUERY)

    fun setName(enteredName : String){
        name.value = enteredName
    }


    /**
     * Gets school and its director name when entering the name of the school
     */
    /*fun getSchoolAndDirectorBySchoolName(schoolName: String) {
        viewModelScope.launch {
            schoolRepository.getSchoolAndDirectorBySchoolName(schoolName)
        }
    }*/

    val directorsBySchoolName = allItemsByNameRepository.getDirectorBySchoolName(schoolName = "IFRI").cachedIn(viewModelScope)


    /**
     * Retrieves all students in a school after passing in the school Name as argument
     */
    /*fun getAllStudentsBySchoolName(schoolName: String){
        viewModelScope.launch {
            schoolRepository.getAllStudentsBySchoolName(schoolName)
        }
    }*/

    val studentsBySchoolName : LiveData<List<SchoolAndStudent>> = allItemsByNameRepository.allStudentsBySchoolName.asLiveData()


    /**
     * Gets the list all students who are following a specific course
     */
    /* fun getAllStudentsByCourseName(courseName : String){
         viewModelScope.launch {
             schoolRepository.getAllStudentsByCourseName(courseName)
         }
     }*/

    val studentsByCourseName : LiveData<List<CourseAndStudent>> = allItemsByNameRepository.allStudentsByCourseName.asLiveData()


    /**
     * Retrieves the list of all courses taken by a specific student with his name
     */
    /*val courseByStudentName = name.switchMap { studentName ->
        schoolRepository.getAllCoursesByStudentName(studentName).cachedIn(viewModelScope)
    }*/

    val coursesByStudentName : LiveData<List<StudentAndCourse>> = allItemsByNameRepository.allCourseByStudentName.asLiveData()


}