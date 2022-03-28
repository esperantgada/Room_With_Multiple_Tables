package eg.esperantgada.roommultipletables.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.entities.Student
import eg.esperantgada.roommultipletables.relationships.StudentAndCourseTogether
import eg.esperantgada.roommultipletables.repository.InsertItemRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertItemViewModel @Inject constructor(
    private val insertItemRepository: InsertItemRepository) : ViewModel(){

    /**
     * Methods used to insert a school in the database
     */
    private fun insertSchool(school : School){
        viewModelScope.launch {
            insertItemRepository.insertSchool(school)
        }
    }


    private fun getSchoolInstance(schoolName : String, location : String) : School {
        return School(
            schoolName = schoolName,
            schoolLocation = location
         )
    }

    fun insertNewSchool(schoolName : String, location: String){
        val newSchool = getSchoolInstance(schoolName, location)
        insertSchool(newSchool)
    }


    /**
     * Methods used to insert a director in the database
     */
    private fun insertDirector(director: Director){
        viewModelScope.launch {
            insertItemRepository.insertDirector(director)
        }
    }


    private fun getDirectorInstance(directorName : String, schoolName: String) : Director {
        return Director(
            directorName = directorName,
            schoolName = schoolName
        )
    }

    fun insertNewDirector(directorName : String, schoolName: String){
        val newDirector = getDirectorInstance(directorName, schoolName)
        insertDirector(newDirector)
    }


    /**
     * Methods to insert a course into the database
     */

    private fun insertCourse(course: Course){
        viewModelScope.launch {
            insertItemRepository.insertCourse(course)
        }
    }


    private fun getCourseInstance(courseName : String, duration : String) : Course {
        return Course(
            courseName = courseName,
            courseDuration = duration
        )
    }

    fun insertNewCourse(courseName : String, duration: String){
        val newCourse = getCourseInstance(courseName, duration)
        insertCourse(newCourse)
    }


    /**
     * Methods used to insert a student in the database
     */

    private fun insertStudent(student: Student){
        viewModelScope.launch {
            insertItemRepository.insertStudent(student)
        }
    }

    private fun getStudentInstance(
        studentName : String,
        semester : String,
        schoolName: String) : Student {

        return Student(
            studentName = studentName,
            semester = semester.toInt(),
            schoolName = schoolName
        )
    }

    fun insertNewStudent(studentName: String, semester: String, schoolName: String){
        val newStudent = getStudentInstance(studentName, semester, schoolName)
        insertStudent(newStudent)
    }


    /**
     * Methods used to insert a combination of student and course in the database
     */

    private fun insertStudentAndCourse(studentAndCourseTogether: StudentAndCourseTogether){
        viewModelScope.launch {
            insertItemRepository.insertStudentAndCourse(studentAndCourseTogether)
        }
    }

    private fun getStudentAndCourseInstance(
        studentName: String,
        courseName: String) : StudentAndCourseTogether {

        return StudentAndCourseTogether(
            studentName = studentName,
            courseName = courseName
        )
    }

    fun insertNewStudentAndCourse(studentName: String, courseName: String){
        val newStudentAndCourse = getStudentAndCourseInstance(studentName, courseName)

        insertStudentAndCourse(newStudentAndCourse)
    }



    /**
     * Checks if the input for all methods that take two strings parameters is valid
     */
    fun isUserInputValid(name : String, string: String) : Boolean = name.isNotBlank() && string.isNotBlank()


    /**
     * Checks if student info are valid
     */
    fun isStudentInfoValid(studentName: String, semester: String, schoolName: String) : Boolean =
        studentName.isNotBlank() && semester.isNotBlank() && schoolName.isNotBlank()


}