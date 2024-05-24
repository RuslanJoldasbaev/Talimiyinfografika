package uz.appe.talimiyinfografika.ui.tasks

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentTaskBinding
import uz.appe.talimiyinfografika.presentation.MainViewModel
import uz.appe.talimiyinfografika.ui.subject.SubjectAdapter
import uz.appe.talimiyinfografika.ui.subject.SubjectFragmentDirections

class TasksFragment : Fragment(R.layout.fragment_task) {

    private lateinit var binding: FragmentTaskBinding
    private val adapter = TasksAdapter()
    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTaskBinding.bind(view)

        setupData()
        setupListeners()
        initObservers()

    }

    private fun setupData() {
        binding.rcView.adapter = adapter
    }

    private fun setupListeners() {

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }

        adapter.setOnItemClickListener {
            findNavController().navigate(
                TasksFragmentDirections.actionTasksFragmentToTasksInnerFragment(it.id, it.name)
            )
        }
    }

    private fun initObservers() {
        mainViewModel.allTasksLiveData.observe(requireActivity()) {
            adapter.submitList(it)
        }

        MainScope().launch {
            mainViewModel.getAllTasks()
        }
    }
}