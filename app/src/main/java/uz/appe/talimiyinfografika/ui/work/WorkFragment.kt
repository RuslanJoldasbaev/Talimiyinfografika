package uz.appe.talimiyinfografika.ui.work

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.databinding.FragmentWorkBinding

class WorkFragment : Fragment(R.layout.fragment_work) {

    private lateinit var binding: FragmentWorkBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentWorkBinding.bind(view)

        binding.tvTitle.text = "Ish daturi"
        showPdfFromAssets("инфограф узб силлабус.pdf")
    }

    private fun showPdfFromAssets(pdfName: String) {
        binding.pdfView.fromAsset(pdfName)
            .password(null)
            .defaultPage(0)
            .load()
    }
}