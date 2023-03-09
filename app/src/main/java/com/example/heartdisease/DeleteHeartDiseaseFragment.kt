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

class DeleteHeartDiseaseFragment : Fragment(), View.OnClickListener, AdapterView.OnItemSelectedListener {
	private lateinit var root: View
	private lateinit var myContext: Context
	private lateinit var model: ModelFacade
	
	private lateinit var heartDiseaseBean: HeartDiseaseBean
	
	private lateinit var deleteHeartDiseaseSpinner: Spinner
	private var allHeartDiseaseids: List<String> = ArrayList()
	private lateinit var idTextField: EditText
	private var idData = ""
	private lateinit var deleteHeartDiseaseButton : Button
	private lateinit var cancelHeartDiseaseButton : Button	
	
    companion object {
        fun newInstance(c: Context): DeleteHeartDiseaseFragment {
            val fragment = DeleteHeartDiseaseFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.myContext = c
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		root = inflater.inflate(R.layout.deleteheartdisease_layout, container, false)
	    return root
	}
	
	override fun onResume() {
		super.onResume()
		model = ModelFacade.getInstance(myContext)
		heartDiseaseBean = HeartDiseaseBean(myContext)

		idTextField = root.findViewById(R.id.crudHeartDiseaseidField)
		deleteHeartDiseaseSpinner = root.findViewById(R.id.crudHeartDiseaseSpinner)
		Log.i("model",model.listHeartDisease().toString())
		Log.i("model",model.allHeartDiseaseIds().toString())

		allHeartDiseaseids = model.allHeartDiseaseIds()
		val deleteHeartDiseaseAdapter =
		ArrayAdapter(myContext, android.R.layout.simple_spinner_item, allHeartDiseaseids)
		deleteHeartDiseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
		deleteHeartDiseaseSpinner.adapter = deleteHeartDiseaseAdapter
		deleteHeartDiseaseSpinner.onItemSelectedListener = this

		deleteHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseOK)
		deleteHeartDiseaseButton.setOnClickListener(this)
		cancelHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseCancel)
		cancelHeartDiseaseButton.setOnClickListener(this)
	}
	
	override fun onItemSelected(parent: AdapterView<*>, v: View?, position: Int, id: Long) {
		if (parent === deleteHeartDiseaseSpinner) {
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
		R.id.crudHeartDiseaseOK-> {
			deleteHeartDiseaseOK()
		}
		R.id.crudHeartDiseaseCancel-> {
			deleteHeartDiseaseCancel()
		}
	  }
    }

	private fun deleteHeartDiseaseOK() {
		idData = idTextField.text.toString()
		heartDiseaseBean.setId(idData)
		if (heartDiseaseBean.isDeleteHeartDiseaseError(allHeartDiseaseids)) {
			Log.w(javaClass.name, heartDiseaseBean.errors())
			Toast.makeText(myContext, "Errors: " + heartDiseaseBean.errors(), Toast.LENGTH_LONG).show()
		} else {
		heartDiseaseBean.deleteHeartDisease()
		Toast.makeText(myContext, "heartDisease is deleted!", Toast.LENGTH_LONG).show()
		}
	}

	private fun deleteHeartDiseaseCancel() {
		heartDiseaseBean.resetData()
		idTextField.setText("")
	}
		 
}
