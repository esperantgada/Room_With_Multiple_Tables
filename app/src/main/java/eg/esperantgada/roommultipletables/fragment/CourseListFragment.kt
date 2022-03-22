package eg.esperantgada.roommultipletables.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import eg.esperantgada.roommultipletables.R
import eg.esperantgada.roommultipletables.adapter.CourseAdapter
import eg.esperantgada.roommultipletables.databinding.FragmentCourseListBinding
import eg.esperantgada.roommultipletables.viewmodel.AllItemsViewModel
import eg.esperantgada.roommultipletables.viewmodel.SortedItemsViewModel
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CourseListFragment : Fragment() {

    private var _binding : FragmentCourseListBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CourseAdapter

    private val sortedItemsViewModel : SortedItemsViewModel by activityViewModels()
    private val allItemsViewModel : AllItemsViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentCourseListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = CourseAdapter()
        binding.recyclerView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            allItemsViewModel.courses.collectLatest {
                adapter.submitData(viewLifecycleOwner.lifecycle, it)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)

        val search = menu.findItem(R.id.search)

        val searchView = search.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null){
                    binding.recyclerView.scrollToPosition(0)
                    sortedItemsViewModel.setQuery(query)
                    sortedItemsViewModel.sortedCourseList.observe(viewLifecycleOwner){
                        adapter.submitData(viewLifecycleOwner.lifecycle, it)
                    }
                    searchView.clearFocus()
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}