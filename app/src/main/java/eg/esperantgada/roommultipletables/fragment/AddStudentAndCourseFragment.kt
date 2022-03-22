package eg.esperantgada.roommultipletables.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import eg.esperantgada.roommultipletables.R
import eg.esperantgada.roommultipletables.databinding.FragmentAddStudentAndCourseBinding
import eg.esperantgada.roommultipletables.viewmodel.InsertItemViewModel

@AndroidEntryPoint
class AddStudentAndCourseFragment : Fragment() {

    private var _binding : FragmentAddStudentAndCourseBinding? = null
    private val binding get() = _binding!!

    private val viewModel : InsertItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAddStudentAndCourseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveStudentCourseButton.setOnClickListener {
            if (isUserInputValid()){
                viewModel.insertNewStudentAndCourse(
                    binding.studentName.text.toString(),
                    binding.studentCourseName.text.toString()
                )

                clearUserInput()
                showSnackBar()

                findNavController().navigate(R.id.action_addStudentAndCourseFragment_to_studentAndCourseListFragment)
            }else{
                showToast()
            }
        }
    }

    private fun isUserInputValid() : Boolean = viewModel.isUserInputValid(
        binding.studentName.text.toString(),
        binding.studentCourseName.text.toString()
    )

    private fun showSnackBar(){
        Snackbar.make(binding.saveStudentCourseButton, "Student and Course added successfully", Snackbar.LENGTH_LONG)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .show()
    }

    private fun showToast(){
        Toast.makeText(requireContext(), "Missing value! Please add values", Toast.LENGTH_LONG)
            .show()
    }

    private fun clearUserInput(){
        binding.studentCourseName.text?.clear()
        binding.studentName.text?.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}