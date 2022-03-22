package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.CourseByStudentNameItemBinding
import eg.esperantgada.roommultipletables.entities.Course


class CourseByStudentNameAdapter :
    ListAdapter<Course,
            CourseByStudentNameAdapter.CourseByStudentNameViewHolder>(DiffCallback) {


    class CourseByStudentNameViewHolder(private val binding: CourseByStudentNameItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(course: Course){
            binding.courseName.text = course.courseName
            binding.courseDuration.text = course.courseDuration
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CourseByStudentNameViewHolder {
        val inflatedLayout = CourseByStudentNameItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return CourseByStudentNameViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: CourseByStudentNameViewHolder, position: Int) {
        val currentCourse = getItem(position)
        if (currentCourse != null) {
            holder.bind(currentCourse)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Course>(){
        override fun areItemsTheSame(
            oldItem: Course,
            newItem: Course
        ): Boolean = oldItem.courseName == newItem.courseName

        override fun areContentsTheSame(
            oldItem: Course,
            newItem: Course
        ): Boolean = oldItem == newItem

    }
}
