package uz.appe.talimiyinfografika.ui.test

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentTestBinding

class TestFragment : Fragment(R.layout.fragment_test) {

    private lateinit var binding: FragmentTestBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTestBinding.bind(view)

        binding.arrBack.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.tvTitle.text = "Testlar"
        showPdfFromAssets("infografika test 100.pdf")

    }

    private fun showPdfFromAssets(pdfName: String) {
        binding.pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .load()
    }
}