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
            return when (position) {
                0 -> { 
                    CreateHeartDiseaseFragment.newInstance(mContext) 
                }            1 -> { 
                    ListHeartDiseaseFragment.newInstance(mContext) 
                }            2 -> { 
                    EditHeartDiseaseFragment.newInstance(mContext) 
                }            3 -> { 
                    DeleteHeartDiseaseFragment.newInstance(mContext) 
                }            4 -> { 
                    SearchHeartDiseaseByAgeageFragment.newInstance(mContext) 
                }            5 -> { 
                    ClassifyHeartDiseaseFragment.newInstance(mContext) 
                }
                else -> CreateHeartDiseaseFragment.newInstance(mContext) 
             }
    }

    override fun getPageTitle(position: Int): CharSequence {
        return TABTITLES[position]
    }

    override fun getCount(): Int {
        return 6
    }
}
