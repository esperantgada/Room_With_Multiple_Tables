package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.SchoolListItemBinding
import eg.esperantgada.roommultipletables.entities.School

class SchoolAdapter : PagingDataAdapter<School, SchoolAdapter.SchoolViewHolder>(DiffCallback){

    class SchoolViewHolder(private val binding: SchoolListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(school: School){
            binding.schoolName.text = school.schoolName
            binding.schoolLocation.text = school.schoolLocation
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): SchoolViewHolder {
        val inflatedLayout = SchoolListItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return SchoolViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
        val currentSchool = getItem(position)

        if (currentSchool != null){
            holder.bind(currentSchool)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<School>(){
        override fun areItemsTheSame(
            oldItem: School,
            newItem: School
        ): Boolean = oldItem.schoolName == newItem.schoolName

        override fun areContentsTheSame(
            oldItem: School,
            newItem: School
        ): Boolean = oldItem == newItem

    }
}