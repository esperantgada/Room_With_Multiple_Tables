package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.AllStudentsBySchoolNameListItemBinding
import eg.esperantgada.roommultipletables.entities.Student
import eg.esperantgada.roommultipletables.relationships.SchoolAndStudent

class StudentsBySchoolNameAdapter : ListAdapter<Student, StudentsBySchoolNameAdapter.StudentViewHolder>(DiffCallback) {

    class StudentViewHolder(private val binding: AllStudentsBySchoolNameListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(student: Student){
            binding.studentName.text = student.studentName
            binding.studentSemester.text = student.semester.toString()
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): StudentViewHolder {
        val inflatedLayout = AllStudentsBySchoolNameListItemBinding.inflate(LayoutInflater.from(
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