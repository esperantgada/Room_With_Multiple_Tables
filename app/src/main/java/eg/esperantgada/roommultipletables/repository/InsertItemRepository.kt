package eg.esperantgada.roommultipletables.repository

import eg.esperantgada.roommultipletables.dao.InsertItemDao
import eg.esperantgada.roommultipletables.entities.Course
import eg.esperantgada.roommultipletables.entities.Director
import eg.esperantgada.roommultipletables.entities.School
import eg.esperantgada.roommultipletables.entities.Student
import eg.esperantgada.roommultipletables.relationships.StudentAndCourseTogether
import javax.inject.Inject

class InsertItemRepository @Inject constructor(private val insertItemDao: InsertItemDao) {

    //Takes a school and inserts it into the database
    suspend fun insertSchool(school: School){
        insertItemDao.insertSchool(school)
    }

    //Takes a director and inserts it into the database
    suspend fun insertDirector(director: Director){
        insertItemDao.insertDirector(director)
    }


    //Takes a course and inserts it into the database
    suspend fun insertCourse(course: Course){
        insertItemDao.insertCourse(course)
    }

    //Takes a student and inserts it into the database
    suspend fun insertStudent(student: Student){
        insertItemDao.insertStudent(student)
    }

    //Takes a combination of student and course and insert them into the database
    suspend fun insertStudentAndCourse(studentAndCourseTogether: StudentAndCourseTogether){
        insertItemDao.insertStudentAndCourseTogether(studentAndCourseTogether)
    }

}