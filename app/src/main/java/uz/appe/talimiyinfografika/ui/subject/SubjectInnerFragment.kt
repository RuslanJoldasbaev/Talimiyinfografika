package uz.appe.talimiyinfografika.ui.subject

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentSubjectInnerBinding

class SubjectInnerFragment : Fragment(R.layout.fragment_subject_inner) {

    private lateinit var binding: FragmentSubjectInnerBinding
    private val navArgs by navArgs<SubjectInnerFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSubjectInnerBinding.bind(view)


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
                    showPdfFromAssets("1-maruza.pdf")
                }

                2 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("3-maruza.pdf")
                }

                3 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("4-maruza.pdf")
                }

                4 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("5-maruza.pdf")
                }

                5 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("6-maruza.pdf")
                }

                6 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("7-maruza.pdf")
                }

                7 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("8-maruza.pdf")
                }
                8 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("9-maruza.pdf")
                }
                9 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("10-maruza.pdf")
                }

                10 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("11-maruxa.pdf")
                }
                11 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("12-maruza.pdf")
                }
                12 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("13-maruza.pdf")
                }

                13 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("14-maruza.pdf")
                }

                14 -> {
                    binding.tvTitle.text = name
                    showPdfFromAssets("15-maruza.pdf")
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