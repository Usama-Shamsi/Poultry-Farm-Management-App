package com.example.farm_application_2
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.farm_application_2.Egg
import com.example.farm_application_2.R

class EggRecyclerView(val items: List<Egg>) :
    RecyclerView.Adapter<EggRecyclerView.EggViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EggViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_egg, parent, false)
        return EggViewHolder(view)
    }

    override fun onBindViewHolder(holder: EggViewHolder, position: Int) {
        val eggProduction = items[position]
        holder.bind(eggProduction)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EggViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val batchIdTextView: TextView = itemView.findViewById(R.id.tvBatchIdEgg)
        private val numberOfEggsTextView: TextView = itemView.findViewById(R.id.editTextNumberOfEggs)
        private val dateTextView: TextView = itemView.findViewById(R.id.editTextDateEgg)

        fun bind(eggProduction: Egg) {
            batchIdTextView.text = "Batch ID: ${eggProduction.batchId}"
            numberOfEggsTextView.text = "Number of Eggs: ${eggProduction.numberOfEggs}"
            dateTextView.text = "Date: ${eggProduction.date}"
        }
    }
}

/*package com.example.farm_application_2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EggRecyclerView(val items: List<Egg>) :
    RecyclerView.Adapter<EggAdapterActivity.EggRecordViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EggViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_egg, parent, false)
        return EggViewHolder(view)
    }

    override fun onBindViewHolder(holder: EggViewHolder, position: Int) {
        val eggProduction = items[position]
        holder.bind(eggProduction)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class EggViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val batchIdTextView: TextView = itemView.findViewById(R.id.tvBatchIdEgg)
        private val numberOfEggsTextView: TextView = itemView.findViewById(R.id.editTextNumberOfEggs)
        private val dateTextView: TextView = itemView.findViewById(R.id.editTextDateEgg)

        fun bind(eggProduction: Egg) {
            batchIdTextView.text = "Batch ID: ${eggProduction.batchId}"
            numberOfEggsTextView.text = "Number of Eggs: ${eggProduction.numberOfEggs}"
            dateTextView.text = "Date: ${eggProduction.date}"
        }
    }
}*/
