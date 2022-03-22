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
import eg.esperantgada.roommultipletables.databinding.FragmentAddStudentBinding
import eg.esperantgada.roommultipletables.viewmodel.InsertItemViewModel

@AndroidEntryPoint
class AddStudentFragment : Fragment() {

    private var _binding : FragmentAddStudentBinding? = null
    private val binding get() = _binding!!

    private val viewModel : InsertItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAddStudentBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveStudentButton.setOnClickListener {
            if (isStudentInfoValid()){
                viewModel.insertNewStudent(
                    binding.studentName.text.toString(),
                    binding.studentSemester.text.toString(),
                    binding.studentSchoolName.text.toString()
                )
                clearUserInput()
                showSnackBar()

                findNavController().navigate(R.id.action_addStudentFragment_to_studentListFragment)
            }else{
                showToast()
            }
        }
    }

    private fun isStudentInfoValid() : Boolean = viewModel.isStudentInfoValid(
        binding.studentName.text.toString(),
        binding.studentSemester.text.toString(),
        binding.studentSchoolName.text.toString()
    )

    private fun showSnackBar(){
        Snackbar.make(binding.saveStudentButton, "Student added successfully", Snackbar.LENGTH_LONG)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .show()
    }

    private fun showToast(){
        Toast.makeText(requireContext(), "Missing value! Please add values", Toast.LENGTH_LONG)
            .show()
    }


    private fun clearUserInput(){
        binding.studentName.text?.clear()
        binding.studentSemester.text?.clear()
        binding.studentSchoolName.text?.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}