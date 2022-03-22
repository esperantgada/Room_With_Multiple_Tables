package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.StudentListItemBinding
import eg.esperantgada.roommultipletables.entities.Student

class StudentAdapter : PagingDataAdapter<Student, StudentAdapter.StudentViewHolder>(DiffCallback){

    class StudentViewHolder(private val binding: StudentListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(student: Student){
            binding.studentName.text = student.studentName
            binding.studentSemester.text = student.semester.toString()
            binding.studentSchoolName.text = student.schoolName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): StudentViewHolder {
        val inflatedLayout = StudentListItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return StudentViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val currentStudent = getItem(position)

        if (currentStudent != null){
            holder.bind(currentStudent)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Student>(){
        override fun areItemsTheSame(
            oldItem: Student,
            newItem: Student
        ): Boolean = oldItem.studentName == newItem.studentName

        override fun areContentsTheSame(
            oldItem: Student,
            newItem: Student
        ): Boolean = oldItem == newItem

    }
}