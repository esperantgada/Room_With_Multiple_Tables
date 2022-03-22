package eg.esperantgada.roommultipletables.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import eg.esperantgada.roommultipletables.adapter.StudentsByCourseNameAdapter
import eg.esperantgada.roommultipletables.databinding.FragmentAllStudentsByCourseNameBinding
import eg.esperantgada.roommultipletables.viewmodel.AllItemsByNameViewModel


class AllStudentsByCourseNameFragment : Fragment() {

    private var _binding : FragmentAllStudentsByCourseNameBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllItemsByNameViewModel by activityViewModels()

    private lateinit var adapter : StudentsByCourseNameAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAllStudentsByCourseNameBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = StudentsByCourseNameAdapter()
        binding.recyclerView.adapter = adapter

        viewModel.studentsByCourseName.observe(viewLifecycleOwner){
            for (student in it){
                adapter.submitList(student.students)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}