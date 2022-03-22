package eg.esperantgada.roommultipletables.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import eg.esperantgada.roommultipletables.adapter.DirectorsBySchoolNameAdapter
import eg.esperantgada.roommultipletables.databinding.FragmentAllDirectorsBySchoolNameBinding
import eg.esperantgada.roommultipletables.viewmodel.AllItemsByNameViewModel

class AllDirectorsBySchoolNameFragment : Fragment() {

    private var _binding : FragmentAllDirectorsBySchoolNameBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllItemsByNameViewModel by activityViewModels()

    private lateinit var adapter : DirectorsBySchoolNameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAllDirectorsBySchoolNameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DirectorsBySchoolNameAdapter()
        viewModel.directorsBySchoolName.observe(viewLifecycleOwner){
            adapter.submitData(viewLifecycleOwner.lifecycle, it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}