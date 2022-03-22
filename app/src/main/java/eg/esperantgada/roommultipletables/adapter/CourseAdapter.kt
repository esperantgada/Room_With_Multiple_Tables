package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.CourseListItemBinding
import eg.esperantgada.roommultipletables.entities.Course

class CourseAdapter : PagingDataAdapter<Course, CourseAdapter.CourseViewHolder> (DiffCallback) {

    class CourseViewHolder(private val binding: CourseListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

          fun bind(course: Course){
              binding.courseName.text = course.courseName
              binding.courseDuration.text = course.courseDuration
          }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CourseViewHolder {
        val inflatedLayout = CourseListItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return CourseViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
        val currentCourse = getItem(position)

        if (currentCourse != null){
            holder.bind(currentCourse)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Course>(){
        override fun areItemsTheSame(
            oldItem: Course,
            newItem: Course): Boolean = oldItem.courseName == newItem.courseName

        override fun areContentsTheSame(
            oldItem: Course,
            newItem: Course): Boolean = oldItem == newItem

    }
}