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
import eg.esperantgada.roommultipletables.databinding.FragmentAddDirectorBinding
import eg.esperantgada.roommultipletables.viewmodel.InsertItemViewModel

@AndroidEntryPoint
class AddDirectorFragment : Fragment() {

    private var _binding : FragmentAddDirectorBinding? = null
    private val binding get() = _binding!!

    private val viewModel : InsertItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddDirectorBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveDirectorButton.setOnClickListener {
            if (isUserInputValid()){
                viewModel.insertNewDirector(
                    binding.directorName.text.toString(),
                    binding.directorSchoolName.text.toString()
                )

                clearUserInput()
                showSnackBar()

                findNavController().navigate(R.id.action_addDirectorFragment_to_directorListFragment)
            }else{
                showToast()
            }
        }
    }

    private fun isUserInputValid() : Boolean = viewModel.isUserInputValid(
        binding.directorName.text.toString(),
        binding.directorSchoolName.text.toString()
    )

    private fun showSnackBar(){
        Snackbar.make(binding.saveDirectorButton, "Director added successfully", Snackbar.LENGTH_LONG)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .show()
    }

    private fun showToast(){
        Toast.makeText(requireContext(), "Missing value! Please enter required values", Toast.LENGTH_LONG)
            .show()
    }

    private fun clearUserInput(){
        binding.directorName.text?.clear()
        binding.directorSchoolName.text?.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}