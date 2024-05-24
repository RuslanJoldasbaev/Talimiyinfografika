package uz.appe.talimiyinfografika.ui.subject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.SubjectData
import uz.appe.talimiyinfografika.databinding.ItemBooksBinding
import uz.appe.talimiyinfografika.databinding.ItemMenuBinding

class SubjectAdapter() :
    ListAdapter<SubjectData, SubjectAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<SubjectData>() {
            override fun areItemsTheSame(oldItem: SubjectData, newItem: SubjectData) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: SubjectData, newItem: SubjectData) =
                oldItem.id == newItem.id
        }
    ) {

    inner class ViewHolder(private val binding: ItemBooksBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)

            binding.tvName.text = d.name

            binding.root.setOnClickListener {
                onClick.invoke(d)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemBooksBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    private var onClick: (SubjectData) -> Unit = {}
    fun setOnItemClickListener(onClick: (SubjectData) -> Unit) {
        this.onClick = onClick
    }
}