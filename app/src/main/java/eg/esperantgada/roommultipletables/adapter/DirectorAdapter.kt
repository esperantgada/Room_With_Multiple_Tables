package eg.esperantgada.roommultipletables.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import eg.esperantgada.roommultipletables.databinding.DirectorListItemBinding
import eg.esperantgada.roommultipletables.entities.Director

class DirectorAdapter : PagingDataAdapter<Director, DirectorAdapter.DirectorViewHolder> (DiffCallback){

    class DirectorViewHolder(private val binding: DirectorListItemBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(director: Director){
            binding.directorName.text = director.directorName
            binding.schoolName.text = director.schoolName
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): DirectorViewHolder {
        val inflatedLayout = DirectorListItemBinding.inflate(LayoutInflater.from(
            parent.context), parent, false)

        return DirectorViewHolder(inflatedLayout)
    }


    override fun onBindViewHolder(holder: DirectorViewHolder, position: Int) {
        val currentDirector = getItem(position)

        if (currentDirector != null){
            holder.bind(currentDirector)
        }
    }



    companion object DiffCallback : DiffUtil.ItemCallback<Director>(){
        override fun areItemsTheSame(
            oldItem: Director,
            newItem: Director
        ): Boolean = oldItem.directorName == newItem.directorName

        override fun areContentsTheSame(
            oldItem: Director,
            newItem: Director
        ): Boolean = oldItem == newItem

    }
}