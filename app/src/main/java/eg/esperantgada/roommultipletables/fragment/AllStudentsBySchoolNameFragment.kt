package eg.esperantgada.roommultipletables.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import eg.esperantgada.roommultipletables.adapter.StudentsBySchoolNameAdapter
import eg.esperantgada.roommultipletables.databinding.FragmentAllStudentsBySchoolNameBinding
import eg.esperantgada.roommultipletables.viewmodel.AllItemsByNameViewModel

class AllStudentsBySchoolNameFragment : Fragment() {

    private var _binding : FragmentAllStudentsBySchoolNameBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllItemsByNameViewModel by activityViewModels()

    private lateinit var adapter : StudentsBySchoolNameAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAllStudentsBySchoolNameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StudentsBySchoolNameAdapter()

        binding.recyclerView.adapter = adapter

        viewModel.studentsBySchoolName.observe(viewLifecycleOwner){
            for (item in it){
                adapter.submitList(item.students)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}