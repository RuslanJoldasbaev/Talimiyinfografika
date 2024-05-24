package uz.appe.talimiyinfografika.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.databinding.ItemMenuBinding

class CategoryAdapter() :
    ListAdapter<CategoryData, CategoryAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<CategoryData>() {
            override fun areItemsTheSame(oldItem: CategoryData, newItem: CategoryData) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: CategoryData, newItem: CategoryData) =
                oldItem.id == newItem.id
        }
    ) {

    inner class ViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val d = getItem(position)

            binding.tvName.text = d.name

            val id = binding.root.context.resources.getIdentifier(
                d.image,
                "drawable",
                binding.root.context.packageName
            )
            binding.ivImage.setImageResource(id)

            binding.root.setOnClickListener {
                onClick.invoke(d)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        ItemMenuBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(position)

    private var onClick: (CategoryData) -> Unit = {}
    fun setOnItemClickListener(onClick: (CategoryData) -> Unit) {
        this.onClick = onClick
    }
}