package com.example.heartdisease

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.*
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import java.lang.Exception
import java.util.ArrayList
import androidx.lifecycle.lifecycleScope
import android.util.Base64
import android.graphics.Bitmap
import android.graphics.BitmapFactory

class SearchHeartDiseaseByAgeageFragment : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {
	private lateinit var root: View
	private lateinit var myContext: Context
	private lateinit var model: ModelFacade
	
	private lateinit var heartDiseaseBean: HeartDiseaseBean
	
	private lateinit var searchHeartDiseaseByAgeSpinner: Spinner
	private var allHeartDiseaseages: List<String> = ArrayList()
	
	private lateinit var ageTextField: EditText
	private var ageData = ""
	
	private lateinit var searchHeartDiseaseByAgeButton : Button
	private lateinit var cancelsearchHeartDiseaseByAgeButton : Button		
	
	private lateinit var idTextView: TextView
	private lateinit var ageTextView: TextView
	private lateinit var sexTextView: TextView
	private lateinit var cpTextView: TextView
	private lateinit var trestbpsTextView: TextView
	private lateinit var cholTextView: TextView
	private lateinit var fbsTextView: TextView
	private lateinit var restecgTextView: TextView
	private lateinit var thalachTextView: TextView
	private lateinit var exangTextView: TextView
	private lateinit var oldpeakTextView: TextView
	private lateinit var slopeTextView: TextView
	private lateinit var caTextView: TextView
	private lateinit var thalTextView: TextView
	private lateinit var outcomeTextView: TextView
		
    companion object {
        fun newInstance(c: Context): SearchHeartDiseaseByAgeageFragment {
            val fragment = SearchHeartDiseaseByAgeageFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.myContext = c
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		root = inflater.inflate(R.layout.searchheartdiseasebyageage_layout, container, false)
	    return root
	}
	
	override fun onResume() {
		super.onResume()
		model = ModelFacade.getInstance(myContext)
		heartDiseaseBean = HeartDiseaseBean(myContext)

		searchHeartDiseaseByAgeSpinner = root.findViewById(R.id.searchHeartDiseaseByAgeSpinner)
		
		Log.i("model",model.listHeartDisease().toString())
		Log.i("model",model.allHeartDiseaseIds().toString())

		allHeartDiseaseages = model.searchHeartDiseaseByAge()
		val searchHeartDiseaseByAgeAdapter =
		ArrayAdapter(myContext, android.R.layout.simple_spinner_item, allHeartDiseaseages)
		searchHeartDiseaseByAgeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
		searchHeartDiseaseByAgeSpinner.adapter = searchHeartDiseaseByAgeAdapter
		searchHeartDiseaseByAgeSpinner.onItemSelectedListener = this

		searchHeartDiseaseByAgeButton = root.findViewById(R.id.searchHeartDiseaseByAgeOK)
		searchHeartDiseaseByAgeButton.setOnClickListener(this)
		cancelsearchHeartDiseaseByAgeButton = root.findViewById(R.id.searchHeartDiseaseByAgeCancel)
		cancelsearchHeartDiseaseByAgeButton.setOnClickListener(this)
		
		idTextView = root.findViewById(R.id.searchHeartDiseaseByAgeidView)
		ageTextView = root.findViewById(R.id.searchHeartDiseaseByAgeageView)
		sexTextView = root.findViewById(R.id.searchHeartDiseaseByAgesexView)
		cpTextView = root.findViewById(R.id.searchHeartDiseaseByAgecpView)
		trestbpsTextView = root.findViewById(R.id.searchHeartDiseaseByAgetrestbpsView)
		cholTextView = root.findViewById(R.id.searchHeartDiseaseByAgecholView)
		fbsTextView = root.findViewById(R.id.searchHeartDiseaseByAgefbsView)
		restecgTextView = root.findViewById(R.id.searchHeartDiseaseByAgerestecgView)
		thalachTextView = root.findViewById(R.id.searchHeartDiseaseByAgethalachView)
		exangTextView = root.findViewById(R.id.searchHeartDiseaseByAgeexangView)
		oldpeakTextView = root.findViewById(R.id.searchHeartDiseaseByAgeoldpeakView)
		slopeTextView = root.findViewById(R.id.searchHeartDiseaseByAgeslopeView)
		caTextView = root.findViewById(R.id.searchHeartDiseaseByAgecaView)
		thalTextView = root.findViewById(R.id.searchHeartDiseaseByAgethalView)
		outcomeTextView = root.findViewById(R.id.searchHeartDiseaseByAgeoutcomeView)
		ageTextField = root.findViewById(R.id.searchHeartDiseaseByAgeField)

	}
	
	override fun onItemSelected(parent: AdapterView<*>, v: View?, position: Int, id: Long) {
		if (parent === searchHeartDiseaseByAgeSpinner) {
			ageTextField.setText(allHeartDiseaseages[position])
		}
	}

	override fun onNothingSelected(parent: AdapterView<*>?) {
		//onNothingSelected
	}

	override fun onClick(v: View?) {
	val imm = myContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
	try {
		imm.hideSoftInputFromWindow(v?.windowToken, 0)
		} catch (e: Exception) {
			 e.message
		}

	when (v?.id) {
		R.id.searchHeartDiseaseByAgeOK-> {
			searchHeartDiseaseByAgeOK()
		}
		R.id.searchHeartDiseaseByAgeCancel-> {
			searchHeartDiseaseByAgeCancel()
		}
	  }
    }

	private fun searchHeartDiseaseByAgeOK() {
		ageData = ageTextField.text.toString()
		heartDiseaseBean.setAge(ageData)
		
		if (heartDiseaseBean.isSearchHeartDiseaseError(allHeartDiseaseages)) {
			Log.w(javaClass.name, heartDiseaseBean.errors())
			Toast.makeText(myContext, "Errors: " + heartDiseaseBean.errors(), Toast.LENGTH_LONG).show()
		} else {
				val selectedItem = model.searchHeartDiseaseByAge(ageData.toInt())
				idTextView.text = selectedItem[0].id.toString()
				ageTextView.text = selectedItem[0].age.toString()
				sexTextView.text = selectedItem[0].sex.toString()
				cpTextView.text = selectedItem[0].cp.toString()
				trestbpsTextView.text = selectedItem[0].trestbps.toString()
				cholTextView.text = selectedItem[0].chol.toString()
				fbsTextView.text = selectedItem[0].fbs.toString()
				restecgTextView.text = selectedItem[0].restecg.toString()
				thalachTextView.text = selectedItem[0].thalach.toString()
				exangTextView.text = selectedItem[0].exang.toString()
				oldpeakTextView.text = selectedItem[0].oldpeak.toString()
				slopeTextView.text = selectedItem[0].slope.toString()
				caTextView.text = selectedItem[0].ca.toString()
				thalTextView.text = selectedItem[0].thal.toString()
				outcomeTextView.text = selectedItem[0].outcome.toString()
				Toast.makeText(myContext, "search HeartDisease done!", Toast.LENGTH_LONG).show()
				
		}
	}

	private fun searchHeartDiseaseByAgeCancel() {
		heartDiseaseBean.resetData()
		idTextView.text = ""
		ageTextView.text = ""
		sexTextView.text = ""
		cpTextView.text = ""
		trestbpsTextView.text = ""
		cholTextView.text = ""
		fbsTextView.text = ""
		restecgTextView.text = ""
		thalachTextView.text = ""
		exangTextView.text = ""
		oldpeakTextView.text = ""
		slopeTextView.text = ""
		caTextView.text = ""
		thalTextView.text = ""
		outcomeTextView.text = ""
    }	 
}
