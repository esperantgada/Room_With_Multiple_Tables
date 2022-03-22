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
import eg.esperantgada.roommultipletables.databinding.FragmentAddCourseBinding
import eg.esperantgada.roommultipletables.viewmodel.InsertItemViewModel


@AndroidEntryPoint
class AddCourseFragment : Fragment() {

    private val viewModel : InsertItemViewModel by activityViewModels()

    private var _binding : FragmentAddCourseBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAddCourseBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.saveCourseButton.setOnClickListener {

            if (isUserInputValid()){
                viewModel.insertNewCourse(
                    binding.courseName.text.toString(),
                    binding.courseDuration.text.toString()
                )

                clearUserInput()

                showSnackBar()
                findNavController().navigate(R.id.action_addCourseFragment_to_courseListFragment)
            }else{
                showToast()
            }
        }

    }


    private fun isUserInputValid() : Boolean = viewModel.isUserInputValid(
        binding.courseName.text.toString(),
        binding.courseDuration.text.toString()
    )

    private fun showSnackBar(){
        Snackbar.make(binding.saveCourseButton, "Course added successfully", Snackbar.LENGTH_LONG)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .show()
    }

    private fun showToast(){
        Toast.makeText(requireContext(), "Missing value! Please add values", Toast.LENGTH_LONG)
            .show()
    }

    private fun clearUserInput(){
        binding.courseName.text?.clear()
        binding.courseDuration.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}