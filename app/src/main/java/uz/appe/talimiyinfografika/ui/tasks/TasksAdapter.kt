package uz.appe.talimiyinfografika.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import uz.appe.talimiyinfografika.data.models.CategoryData
import uz.appe.talimiyinfografika.data.models.TasksData
import uz.appe.talimiyinfografika.databinding.ItemBooksBinding
import uz.appe.talimiyinfografika.databinding.ItemMenuBinding

class TasksAdapter() :
    ListAdapter<TasksData, TasksAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<TasksData>() {
            override fun areItemsTheSame(oldItem: TasksData, newItem: TasksData) =
                oldItem == newItem

            override fun areContentsTheSame(oldItem: TasksData, newItem: TasksData) =
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

    private var onClick: (TasksData) -> Unit = {}
    fun setOnItemClickListener(onClick: (TasksData) -> Unit) {
        this.onClick = onClick
    }
}