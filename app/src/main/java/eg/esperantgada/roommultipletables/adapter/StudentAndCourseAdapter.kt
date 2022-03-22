package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.StudentCourseListItemBinding
import eg.esperantgada.roommultipletables.relationships.StudentAndCourseTogether

class StudentAndCourseAdapter : PagingDataAdapter<StudentAndCourseTogether,
        StudentAndCourseAdapter.StudentAndCourseViewHolder>(DiffCallback){

    class StudentAndCourseViewHolder(private val binding: StudentCourseListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(studentAndCourseTogether: StudentAndCourseTogether){
            binding.studentName.text = studentAndCourseTogether.studentName
            binding.courseName.text = studentAndCourseTogether.courseName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): StudentAndCourseViewHolder {
        val inflatedLayout = StudentCourseListItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return StudentAndCourseViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: StudentAndCourseViewHolder, position: Int) {
        val currentStudentAndCourse = getItem(position)

        if (currentStudentAndCourse != null){
            holder.bind(currentStudentAndCourse)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<StudentAndCourseTogether>(){
        override fun areItemsTheSame(
            oldItem: StudentAndCourseTogether,
            newItem: StudentAndCourseTogether
        ): Boolean = oldItem.studentName == newItem.studentName

        override fun areContentsTheSame(
            oldItem: StudentAndCourseTogether,
            newItem: StudentAndCourseTogether
        ): Boolean = oldItem == newItem

    }
}