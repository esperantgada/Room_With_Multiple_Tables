package eg.esperantgada.roommultipletables.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint
import eg.esperantgada.roommultipletables.R
import eg.esperantgada.roommultipletables.databinding.FragmentAddSchoolBinding
import eg.esperantgada.roommultipletables.notification.Notification
import eg.esperantgada.roommultipletables.viewmodel.InsertItemViewModel
import eg.esperantgada.roommultipletables.worker.SchoolWorker
import java.util.concurrent.TimeUnit


@AndroidEntryPoint
class AddSchoolFragment : Fragment() {

    private var _binding : FragmentAddSchoolBinding? = null
    private val binding get() = _binding!!

    private val viewModel : InsertItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentAddSchoolBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.saveSchoolButton.setOnClickListener {
            if (isUserInputValid()){
                viewModel.insertNewSchool(
                    binding.schoolName.text.toString(),
                    binding.schoolLocation.text.toString()
                )

                val workQuest = OneTimeWorkRequestBuilder<SchoolWorker>()
                    .setInitialDelay(50, TimeUnit.SECONDS)
                    .setInputData(workDataOf(
                        "title" to "Add school",
                        "message" to "A new school is added : ${binding.schoolName.text.toString()}"
                    )).build()

                WorkManager.getInstance().enqueue(workQuest)

               // Notification(requireContext()).onCreateNotification("Add school", "A new school is added")
                clearUserInput()
                showSnackBar()

                findNavController().navigate(R.id.action_addSchoolFragment_to_schoolListFragment)
            }else{
                showToast()
            }
        }
    }

    private fun isUserInputValid() : Boolean = viewModel.isUserInputValid(
        binding.schoolName.text.toString(),
        binding.schoolLocation.text.toString()
    )

    private fun showSnackBar(){
        Snackbar.make(binding.saveSchoolButton, "School added successfully", Snackbar.LENGTH_LONG)
            .setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
            .show()
    }

    private fun showToast(){
        Toast.makeText(requireContext(), "Missing value! Please add values", Toast.LENGTH_LONG)
            .show()
    }

    private fun clearUserInput(){
        binding.schoolName.text?.clear()
        binding.schoolLocation.text?.clear()
    }


    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}