package uz.appe.talimiyinfografika.ui.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import uz.appe.talimiyinfografika.R
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.databinding.ItemMenuBinding

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.TopicViewHolder>() {

    inner class TopicViewHolder(private val binding: ItemMenuBinding) : ViewHolder(binding.root) {
        fun bind(categoryData: CategoryData) {
            binding.apply {
                tvName.text = categoryData.name
                val id = root.context.resources.getIdentifier(
                    categoryData.image,
                    "drawable",
                    root.context.packageName
                )
                ivImage.setImageResource(id)
            }
            binding.card.setOnClickListener {
                onItemClick.invoke(categoryData.id, adapterPosition)
            }
        }
    }

    var models = listOf<CategoryData>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = models.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_menu, parent, false)
        val binding = ItemMenuBinding.bind(v)
        return TopicViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.bind(models[position])
    }

    private var onItemClick: (id: Int, position: Int) -> Unit = { _, _ -> }
    fun setOnItemClickListener(onItemClick: (id: Int, position: Int) -> Unit) {
        this.onItemClick = onItemClick
    }
}