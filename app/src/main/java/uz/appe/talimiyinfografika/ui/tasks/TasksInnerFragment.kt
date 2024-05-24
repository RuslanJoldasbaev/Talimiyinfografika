package uz.appe.talimiyinfografika.ui.tasks

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentTaskInnerBinding
import uz.appe.talimiyinfografika.ui.subject.SubjectInnerFragmentArgs

class TasksInnerFragment : Fragment(R.layout.fragment_task_inner) {

    private lateinit var binding: FragmentTaskInnerBinding
    private val navArgs by navArgs<TasksInnerFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTaskInnerBinding.bind(view)

        binding.arrBack.setOnClickListener {
            findNavController().popBackStack()
        }

        val id = navArgs.id
        val name = navArgs.name

        Log.d("TTT", id.toString())

        binding.apply {
            when (id) {
                1 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("1-amaliy .pdf")
                }

                2 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("3-amaliy.pdf")
                }

                3 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("4-amaliy.pdf")
                }

                4 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("5-amaliy.pdf")
                }

                5 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("6-amaliy.pdf")
                }

                6 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("7-amaliy.pdf")
                }

                7 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("8-amaliy..pdf")
                }

                8 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("9-amaliy.pdf")
                }

                9 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("10-amaliy.pdf")
                }

                10 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("11-amaliy.pdf")
                }

                11 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("12-amaliy.pdf")
                }

                12 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("13-amaliy.pdf")
                }

                13 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("14-amaliy.pdf")
                }

                14 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("15-amaliy.pdf")
                }

            }
        }
    }

    private fun showPdfFromAssets(pdfName: String) {
        binding.pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .load()
    }
}