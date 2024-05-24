package uz.appe.talimiyinfografika.ui.subject

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentSubjectBinding
import uz.appe.talimiyinfografika.presentation.MainViewModel
import uz.appe.talimiyinfografika.ui.menu.CategoryAdapter
import uz.appe.talimiyinfografika.ui.menu.MenuFragmentDirections

class SubjectFragment : Fragment(R.layout.fragment_subject) {

    private lateinit var binding: FragmentSubjectBinding
    private val adapter = SubjectAdapter()
    private val mainViewModel: MainViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSubjectBinding.bind(view)

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
                SubjectFragmentDirections.actionSubjectFragmentToSubjectInnerFragment(
                    it.id,
                    it.name
                )
            )
        }
    }

    private fun initObservers() {
        mainViewModel.allSubjectLiveData.observe(requireActivity()) {
            adapter.submitList(it)
        }

        MainScope().launch {
            mainViewModel.getAllSubject()
        }
    }
}