package uz.appe.talimiyinfografika.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentMenuBinding
import uz.appe.talimiyinfografika.presentation.MainViewModel

class MenuFragment : Fragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding
    private val adapter = CategoryAdapter()
    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMenuBinding.bind(view)


        setupData()
        setupListeners()
        initObservers()

    }

    private fun setupData() {
        binding.recyclerView.adapter = adapter
    }

    private fun setupListeners() {

        adapter.setOnItemClickListener {
            when (it.id) {
                1 -> {
                    findNavController().navigate(
                        MenuFragmentDirections.actionMenuFragmentToWorkFragment()
                    )
                }
                2 -> {
                    findNavController().navigate(
                        MenuFragmentDirections.actionMenuFragmentToSubjectFragment()
                    )
                }
                3 -> {
                    findNavController().navigate(
                        MenuFragmentDirections.actionMenuFragmentToTasksFragment()
                    )
                }
                4 -> {
                    findNavController().navigate(
                        MenuFragmentDirections.actionMenuFragmentToTestFragment()
                    )
                }
            }
        }
    }

    private fun initObservers() {
        mainViewModel.allCategoryLiveData.observe(requireActivity()) {
            adapter.submitList(it)
        }

        MainScope().launch {
            mainViewModel.getAllCategory()
        }
    }
}