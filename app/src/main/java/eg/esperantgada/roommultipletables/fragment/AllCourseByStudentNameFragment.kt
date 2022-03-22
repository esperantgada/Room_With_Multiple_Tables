package eg.esperantgada.roommultipletables.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import eg.esperantgada.roommultipletables.adapter.CourseByStudentNameAdapter
import eg.esperantgada.roommultipletables.databinding.FragmentAllCourseByStudentNameBinding
import eg.esperantgada.roommultipletables.viewmodel.AllItemsByNameViewModel

const val TAG = "AllCourseByStudentNameFragment"

@AndroidEntryPoint
class AllCourseByStudentNameFragment : Fragment() {

    private var _binding : FragmentAllCourseByStudentNameBinding? = null
    private val binding get() = _binding!!

    private val viewModel : AllItemsByNameViewModel by activityViewModels()

    private lateinit var adapter : CourseByStudentNameAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentAllCourseByStudentNameBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("LongLogTag")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CourseByStudentNameAdapter()
        binding.apply {
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.setHasFixedSize(true)
        }

        viewModel.setName(enteredName = "Esperant")

        viewModel.coursesByStudentName.observe(viewLifecycleOwner){
            for (course in it){
                adapter.submitList(course.courses)
            }
            Log.d(TAG, "ESPERANT IS A COMPETENT JUNIOR KOTLIN ANDROID DEVELOPER ")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}
