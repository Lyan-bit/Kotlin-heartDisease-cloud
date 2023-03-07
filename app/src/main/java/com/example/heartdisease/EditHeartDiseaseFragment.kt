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


class EditHeartDiseaseFragment : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {
	private lateinit var root: View
	private lateinit var myContext: Context
	private lateinit var model: ModelFacade
	
	private lateinit var heartDiseaseBean: HeartDiseaseBean
	
	private lateinit var editHeartDiseaseSpinner: Spinner
	private var allHeartDiseaseids: List<String> = ArrayList()

	private lateinit var searchHeartDiseaseButton : Button	
	private lateinit var editHeartDiseaseButton : Button
	private lateinit var cancelHeartDiseaseButton : Button	

	private lateinit var idTextField: EditText
	private var idData = ""
	private lateinit var ageTextField: EditText
	private var ageData = ""
	private lateinit var sexTextField: EditText
	private var sexData = ""
	private lateinit var cpTextField: EditText
	private var cpData = ""
	private lateinit var trestbpsTextField: EditText
	private var trestbpsData = ""
	private lateinit var cholTextField: EditText
	private var cholData = ""
	private lateinit var fbsTextField: EditText
	private var fbsData = ""
	private lateinit var restecgTextField: EditText
	private var restecgData = ""
	private lateinit var thalachTextField: EditText
	private var thalachData = ""
	private lateinit var exangTextField: EditText
	private var exangData = ""
	private lateinit var oldpeakTextField: EditText
	private var oldpeakData = ""
	private lateinit var slopeTextField: EditText
	private var slopeData = ""
	private lateinit var caTextField: EditText
	private var caData = ""
	private lateinit var thalTextField: EditText
	private var thalData = ""
	private lateinit var outcomeTextView: TextView
	private var outcomeData = ""

    companion object {
        fun newInstance(c: Context): EditHeartDiseaseFragment {
            val fragment = EditHeartDiseaseFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.myContext = c
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		root = inflater.inflate(R.layout.editheartdisease_layout, container, false)
		model = ModelFacade.getInstance(myContext)

		editHeartDiseaseSpinner = root.findViewById(R.id.crudHeartDiseaseSpinner)
		Log.i("model",model.listHeartDisease().toString())
		Log.i("model",model.allHeartDiseaseIds().toString())

		allHeartDiseaseids = model.allHeartDiseaseIds()
		val editHeartDiseaseAdapter =
		ArrayAdapter(myContext, android.R.layout.simple_spinner_item, allHeartDiseaseids)
		editHeartDiseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
		editHeartDiseaseSpinner.adapter = editHeartDiseaseAdapter

		editHeartDiseaseSpinner.onItemSelectedListener = this
		
		heartDiseaseBean = HeartDiseaseBean(myContext)
		searchHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseSearch)
		searchHeartDiseaseButton.setOnClickListener(this)
		editHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseOK)
		editHeartDiseaseButton.setOnClickListener(this)
		cancelHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseCancel)
		cancelHeartDiseaseButton.setOnClickListener(this)

		idTextField = root.findViewById(R.id.crudHeartDiseaseidField)
		ageTextField = root.findViewById(R.id.crudHeartDiseaseageField)
		sexTextField = root.findViewById(R.id.crudHeartDiseasesexField)
		cpTextField = root.findViewById(R.id.crudHeartDiseasecpField)
		trestbpsTextField = root.findViewById(R.id.crudHeartDiseasetrestbpsField)
		cholTextField = root.findViewById(R.id.crudHeartDiseasecholField)
		fbsTextField = root.findViewById(R.id.crudHeartDiseasefbsField)
		restecgTextField = root.findViewById(R.id.crudHeartDiseaserestecgField)
		thalachTextField = root.findViewById(R.id.crudHeartDiseasethalachField)
		exangTextField = root.findViewById(R.id.crudHeartDiseaseexangField)
		oldpeakTextField = root.findViewById(R.id.crudHeartDiseaseoldpeakField)
		slopeTextField = root.findViewById(R.id.crudHeartDiseaseslopeField)
		caTextField = root.findViewById(R.id.crudHeartDiseasecaField)
		thalTextField = root.findViewById(R.id.crudHeartDiseasethalField)
		outcomeTextView = root.findViewById(R.id.crudHeartDiseaseoutcomeView)

		return root
	}
	
	override fun onItemSelected(parent: AdapterView<*>, v: View?, position: Int, id: Long) {
		if (parent === editHeartDiseaseSpinner) {
			idTextField.setText(allHeartDiseaseids[position])
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
		R.id.crudHeartDiseaseSearch-> {
			crudHeartDiseaseSearch()
		}			
		R.id.crudHeartDiseaseOK-> {
			crudHeartDiseaseOK()
		}
		R.id.crudHeartDiseaseCancel-> {
			crudHeartDiseaseCancel()
		}
	  }
    }
    
	private fun crudHeartDiseaseSearch() {
		idData = idTextField.text.toString()
		heartDiseaseBean.setId(idData)
		
		if (heartDiseaseBean.isSearchHeartDiseaseIdError(allHeartDiseaseids)) {
			Log.w(javaClass.name, heartDiseaseBean.errors())
			Toast.makeText(myContext, "Errors: " + heartDiseaseBean.errors(), Toast.LENGTH_LONG).show()
		} else {
			val selectedItem = model.getHeartDiseaseByPK(idData)
				idTextField.setText(selectedItem?.id.toString())
				ageTextField.setText(selectedItem?.age.toString())
				sexTextField.setText(selectedItem?.sex.toString())
				cpTextField.setText(selectedItem?.cp.toString())
				trestbpsTextField.setText(selectedItem?.trestbps.toString())
				cholTextField.setText(selectedItem?.chol.toString())
				fbsTextField.setText(selectedItem?.fbs.toString())
				restecgTextField.setText(selectedItem?.restecg.toString())
				thalachTextField.setText(selectedItem?.thalach.toString())
				exangTextField.setText(selectedItem?.exang.toString())
				oldpeakTextField.setText(selectedItem?.oldpeak.toString())
				slopeTextField.setText(selectedItem?.slope.toString())
				caTextField.setText(selectedItem?.ca.toString())
				thalTextField.setText(selectedItem?.thal.toString())
				outcomeTextView.text = selectedItem?.outcome.toString()
				Toast.makeText(myContext, "search HeartDisease is done!", Toast.LENGTH_LONG).show()
		}
	}

	private fun crudHeartDiseaseOK() {
		idData = idTextField.text.toString()
			heartDiseaseBean.setId(idData)
		ageData = ageTextField.text.toString()
			heartDiseaseBean.setAge(ageData)
		sexData = sexTextField.text.toString()
			heartDiseaseBean.setSex(sexData)
		cpData = cpTextField.text.toString()
			heartDiseaseBean.setCp(cpData)
		trestbpsData = trestbpsTextField.text.toString()
			heartDiseaseBean.setTrestbps(trestbpsData)
		cholData = cholTextField.text.toString()
			heartDiseaseBean.setChol(cholData)
		fbsData = fbsTextField.text.toString()
			heartDiseaseBean.setFbs(fbsData)
		restecgData = restecgTextField.text.toString()
			heartDiseaseBean.setRestecg(restecgData)
		thalachData = thalachTextField.text.toString()
			heartDiseaseBean.setThalach(thalachData)
		exangData = exangTextField.text.toString()
			heartDiseaseBean.setExang(exangData)
		oldpeakData = oldpeakTextField.text.toString()
			heartDiseaseBean.setOldpeak(oldpeakData)
		slopeData = slopeTextField.text.toString()
			heartDiseaseBean.setSlope(slopeData)
		caData = caTextField.text.toString()
			heartDiseaseBean.setCa(caData)
		thalData = thalTextField.text.toString()
			heartDiseaseBean.setThal(thalData)
		outcomeData = outcomeTextView.text.toString()
			heartDiseaseBean.setOutcome(outcomeData)

		if (heartDiseaseBean.isEditHeartDiseaseError(allHeartDiseaseids)) {
			Log.w(javaClass.name, heartDiseaseBean.errors())
			Toast.makeText(myContext, "Errors: " + heartDiseaseBean.errors(), Toast.LENGTH_LONG).show()
		} else {
		heartDiseaseBean.editHeartDisease()
		Toast.makeText(myContext, "HeartDisease edited!", Toast.LENGTH_LONG).show()
		}
	}

	private fun crudHeartDiseaseCancel() {
		heartDiseaseBean.resetData()
		idTextField.setText("")
		ageTextField.setText("")
		sexTextField.setText("")
		cpTextField.setText("")
		trestbpsTextField.setText("")
		cholTextField.setText("")
		fbsTextField.setText("")
		restecgTextField.setText("")
		thalachTextField.setText("")
		exangTextField.setText("")
		oldpeakTextField.setText("")
		slopeTextField.setText("")
		caTextField.setText("")
		thalTextField.setText("")
		outcomeTextView.text = "" 
	}
	
		 
}
