package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.AllDirectorsBySchoolNameListItemBinding
import eg.esperantgada.roommultipletables.relationships.SchoolAndDirector

class DirectorsBySchoolNameAdapter : PagingDataAdapter<SchoolAndDirector, DirectorsBySchoolNameAdapter.DirectorViewHolder>(DiffCallback) {

    class DirectorViewHolder(private val binding: AllDirectorsBySchoolNameListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(schoolAndDirector: SchoolAndDirector){
            binding.directorName.text = schoolAndDirector.director.directorName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): DirectorViewHolder {
        val inflatedLayout = AllDirectorsBySchoolNameListItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return DirectorViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: DirectorViewHolder, position: Int) {
        val currentDirector = getItem(position)

        if (currentDirector != null){
            holder.bind(currentDirector)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<SchoolAndDirector>(){
        override fun areItemsTheSame(
            oldItem: SchoolAndDirector,
            newItem: SchoolAndDirector
        ): Boolean = oldItem.director.directorName == newItem.director.directorName

        override fun areContentsTheSame(
            oldItem: SchoolAndDirector,
            newItem: SchoolAndDirector
        ): Boolean = oldItem == newItem

    }
}