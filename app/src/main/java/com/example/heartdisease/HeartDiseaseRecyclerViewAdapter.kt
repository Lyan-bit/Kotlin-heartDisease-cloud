package com.example.heartdisease

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

class HeartDiseaseRecyclerViewAdapter (items: List<HeartDiseaseVO>, listener: ListHeartDiseaseFragment.OnListHeartDiseaseFragmentInteractionListener)
    : RecyclerView.Adapter<HeartDiseaseRecyclerViewAdapter.HeartDiseaseViewHolder>() {

    private var mValues: List<HeartDiseaseVO> = items
    private var mListener: ListHeartDiseaseFragment.OnListHeartDiseaseFragmentInteractionListener = listener
	
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeartDiseaseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewsearchheartdiseasebyage_item, parent, false)
        return HeartDiseaseViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: HeartDiseaseViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.searchHeartDiseaseByAgeIdView.text = " " + mValues[position].id + " "
        holder.searchHeartDiseaseByAgeAgeView.text = " " + mValues[position].age + " "
        holder.searchHeartDiseaseByAgeSexView.text = " " + mValues[position].sex + " "
        holder.searchHeartDiseaseByAgeCpView.text = " " + mValues[position].cp + " "
        holder.searchHeartDiseaseByAgeTrestbpsView.text = " " + mValues[position].trestbps + " "
        holder.searchHeartDiseaseByAgeCholView.text = " " + mValues[position].chol + " "
        holder.searchHeartDiseaseByAgeFbsView.text = " " + mValues[position].fbs + " "
        holder.searchHeartDiseaseByAgeRestecgView.text = " " + mValues[position].restecg + " "
        holder.searchHeartDiseaseByAgeThalachView.text = " " + mValues[position].thalach + " "
        holder.searchHeartDiseaseByAgeExangView.text = " " + mValues[position].exang + " "
        holder.searchHeartDiseaseByAgeOldpeakView.text = " " + mValues[position].oldpeak + " "
        holder.searchHeartDiseaseByAgeSlopeView.text = " " + mValues[position].slope + " "
        holder.searchHeartDiseaseByAgeCaView.text = " " + mValues[position].ca + " "
        holder.searchHeartDiseaseByAgeThalView.text = " " + mValues[position].thal + " "
        holder.searchHeartDiseaseByAgeOutcomeView.text = " " + mValues[position].outcome + " "

        holder.mView.setOnClickListener { mListener.onListHeartDiseaseFragmentInteraction(holder.mItem) }
    }
    
    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class HeartDiseaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var mView: View
        var searchHeartDiseaseByAgeIdView: TextView
        var searchHeartDiseaseByAgeAgeView: TextView
        var searchHeartDiseaseByAgeSexView: TextView
        var searchHeartDiseaseByAgeCpView: TextView
        var searchHeartDiseaseByAgeTrestbpsView: TextView
        var searchHeartDiseaseByAgeCholView: TextView
        var searchHeartDiseaseByAgeFbsView: TextView
        var searchHeartDiseaseByAgeRestecgView: TextView
        var searchHeartDiseaseByAgeThalachView: TextView
        var searchHeartDiseaseByAgeExangView: TextView
        var searchHeartDiseaseByAgeOldpeakView: TextView
        var searchHeartDiseaseByAgeSlopeView: TextView
        var searchHeartDiseaseByAgeCaView: TextView
        var searchHeartDiseaseByAgeThalView: TextView
        var searchHeartDiseaseByAgeOutcomeView: TextView
        lateinit var mItem: HeartDiseaseVO

        init {
            mView = view
            searchHeartDiseaseByAgeIdView = view.findViewById(R.id.searchHeartDiseaseByAgeIdView)
            searchHeartDiseaseByAgeAgeView = view.findViewById(R.id.searchHeartDiseaseByAgeAgeView)
            searchHeartDiseaseByAgeSexView = view.findViewById(R.id.searchHeartDiseaseByAgeSexView)
            searchHeartDiseaseByAgeCpView = view.findViewById(R.id.searchHeartDiseaseByAgeCpView)
            searchHeartDiseaseByAgeTrestbpsView = view.findViewById(R.id.searchHeartDiseaseByAgeTrestbpsView)
            searchHeartDiseaseByAgeCholView = view.findViewById(R.id.searchHeartDiseaseByAgeCholView)
            searchHeartDiseaseByAgeFbsView = view.findViewById(R.id.searchHeartDiseaseByAgeFbsView)
            searchHeartDiseaseByAgeRestecgView = view.findViewById(R.id.searchHeartDiseaseByAgeRestecgView)
            searchHeartDiseaseByAgeThalachView = view.findViewById(R.id.searchHeartDiseaseByAgeThalachView)
            searchHeartDiseaseByAgeExangView = view.findViewById(R.id.searchHeartDiseaseByAgeExangView)
            searchHeartDiseaseByAgeOldpeakView = view.findViewById(R.id.searchHeartDiseaseByAgeOldpeakView)
            searchHeartDiseaseByAgeSlopeView = view.findViewById(R.id.searchHeartDiseaseByAgeSlopeView)
            searchHeartDiseaseByAgeCaView = view.findViewById(R.id.searchHeartDiseaseByAgeCaView)
            searchHeartDiseaseByAgeThalView = view.findViewById(R.id.searchHeartDiseaseByAgeThalView)
            searchHeartDiseaseByAgeOutcomeView = view.findViewById(R.id.searchHeartDiseaseByAgeOutcomeView)
        }

        override fun toString(): String {
            return super.toString() + " " + mItem
        }

    }
}
