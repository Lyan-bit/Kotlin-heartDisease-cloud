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
import java.util.*

class CreateHeartDiseaseFragment : Fragment(), View.OnClickListener {
	private lateinit var root: View
	private lateinit var myContext: Context
	
	private lateinit var heartDiseaseBean: HeartDiseaseBean
	
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

    private lateinit var createHeartDiseaseButton: Button
	private lateinit var cancelHeartDiseaseButton: Button

		  		
    companion object {
        fun newInstance(c: Context): CreateHeartDiseaseFragment {
            val fragment = CreateHeartDiseaseFragment()
            val args = Bundle()
            fragment.arguments = args
            fragment.myContext = c
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
		root = inflater.inflate(R.layout.createheartdisease_layout, container, false)

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
		
		heartDiseaseBean = HeartDiseaseBean(myContext)

		createHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseOK)
		createHeartDiseaseButton.setOnClickListener(this)

		cancelHeartDiseaseButton = root.findViewById(R.id.crudHeartDiseaseCancel)
		cancelHeartDiseaseButton.setOnClickListener(this)
		
	    return root
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
				crudHeartDiseaseOK()
			}
			R.id.crudHeartDiseaseCancel-> {
				crudHeartDiseaseCancel()
			}
		}
	}

	private fun crudHeartDiseaseOK () {
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

			if (heartDiseaseBean.isCreateHeartDiseaseError()) {
				Log.w(javaClass.name, heartDiseaseBean.errors())
				Toast.makeText(myContext, "Errors: " + heartDiseaseBean.errors(), Toast.LENGTH_LONG).show()
			} else {
					heartDiseaseBean.createHeartDisease()
					Toast.makeText(myContext, "HeartDisease created!", Toast.LENGTH_LONG).show()
			}
	}

	private fun crudHeartDiseaseCancel () {
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
