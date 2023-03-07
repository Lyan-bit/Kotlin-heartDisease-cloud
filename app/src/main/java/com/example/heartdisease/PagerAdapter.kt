package com.example.heartdisease

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private val TABTITLES = arrayOf("+HeartDisease", "ListHeartDisease", "EditHeartDisease", "DeleteHeartDisease", "SearchHeartDiseaseByAgeage", "ClassifyHeartDisease")
    }

    override fun getItem(position: Int): Fragment {
        // instantiate a fragment for the page.
        if (position == 0) {
            return CreateHeartDiseaseFragment.newInstance(mContext)    } 
        else if (position == 1) {
            return ListHeartDiseaseFragment.newInstance(mContext)    } 
        else if (position == 2) {
            return EditHeartDiseaseFragment.newInstance(mContext)    } 
        else if (position == 3) {
            return DeleteHeartDiseaseFragment.newInstance(mContext)    } 
        else if (position == 4) {
            return SearchHeartDiseaseByAgeageFragment.newInstance(mContext)    } 
        else if (position == 5) {
            return ClassifyHeartDiseaseFragment.newInstance(mContext)    } 
        return CreateHeartDiseaseFragment.newInstance(mContext) 
    }

    override fun getPageTitle(position: Int): CharSequence {
        return TABTITLES[position]
    }

    override fun getCount(): Int {
        return 6
    }
}
