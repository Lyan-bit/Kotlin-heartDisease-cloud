package com.example.heartdisease
	
import android.os.Bundle
import android.widget.*
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater
import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.heartdisease.* 
import java.lang.Exception

class ClassifyHeartDiseaseFragment : Fragment(), View.OnClickListener , AdapterView.OnItemSelectedListener {
	private lateinit var root: View
	private lateinit var myContext: Context
	private lateinit var model: ModelFacade
			
	private lateinit var classifyHeartDiseaseBean: ClassifyHeartDiseaseBean
	
	private lateinit var classifyHeartDisease: Button
	private lateinit var cancelClassifyHeartDisease: Button
	private lateinit var classifyHeartDiseaseResult: TextView

	private lateinit var classifyHeartDiseaseheartDiseaseSpinner: Spinner
	private var classifyHeartDiseaseheartDiseaseListItems: List<String> = ArrayList()
	private lateinit var classifyHeartDiseaseheartDiseaseAdapter: ArrayAdapter<String>
	private var classifyHeartDiseaseheartDiseaseData = "" 
		  		
    companion object {
        fun newInstance(c: Context): ClassifyHeartDiseaseFragment {
            val fragment = ClassifyHeartDiseaseFragment()
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
		root = inflater.inflate(R.layout.classifyheartdisease_layout, container, false)
        model = ModelFacade.getInstance(myContext)
        
		classifyHeartDiseaseheartDiseaseSpinner = root.findViewById(R.id.classifyHeartDiseaseHeartDiseaseSpinner)
		Log.i("model",model.listHeartDisease().toString())
		Log.i("model",model.allHeartDiseaseIds().toString())
		classifyHeartDiseaseheartDiseaseListItems = model.allHeartDiseaseIds() 
		classifyHeartDiseaseheartDiseaseAdapter = ArrayAdapter(myContext, android.R.layout.simple_spinner_item, classifyHeartDiseaseheartDiseaseListItems) 
		classifyHeartDiseaseheartDiseaseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item) 
		classifyHeartDiseaseheartDiseaseSpinner.adapter = classifyHeartDiseaseheartDiseaseAdapter 
		classifyHeartDiseaseheartDiseaseSpinner.onItemSelectedListener = this 


		classifyHeartDiseaseResult = root.findViewById(R.id.classifyHeartDiseaseResult)
		classifyHeartDiseaseBean = ClassifyHeartDiseaseBean(myContext)

        classifyHeartDisease = root.findViewById(R.id.classifyHeartDiseaseOK)
        classifyHeartDisease.setOnClickListener(this)
	
        cancelClassifyHeartDisease = root.findViewById(R.id.classifyHeartDiseaseCancel)
        cancelClassifyHeartDisease.setOnClickListener(this)
        
			
	    return root
	}

	override fun onClick(v: View?) {
        val imm = myContext.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        try {
            if (v != null) {
                imm.hideSoftInputFromWindow(v?.windowToken, 0)
            }
        } catch (e: Exception) {
        	 e.message
        }

		when (v?.id) {
			
			R.id.classifyHeartDiseaseOK-> {
				 classifyHeartDiseaseOK()
			}
			R.id.classifyHeartDiseaseCancel-> {
				 classifyHeartDiseaseCancel()
			}
			
		}
		
	}
	
	private fun classifyHeartDiseaseOK () {
				classifyHeartDiseaseBean.setHeartDisease(classifyHeartDiseaseheartDiseaseData)

	    if (classifyHeartDiseaseBean.isClassifyHeartDiseaseError()) {
	       Log.w(javaClass.name, classifyHeartDiseaseBean.errors())
	       Toast.makeText(myContext, "Errors: " + classifyHeartDiseaseBean.errors(), Toast.LENGTH_LONG).show()
	    } else {
	       classifyHeartDiseaseResult.text = classifyHeartDiseaseBean.classifyHeartDisease().toString()
	       Toast.makeText(myContext, "done!", Toast.LENGTH_LONG).show()
	    }
	}
	
	private fun classifyHeartDiseaseCancel () {
	    classifyHeartDiseaseBean.resetData()
	    classifyHeartDiseaseResult.text = ""

	}
	

    override fun onItemSelected(parent: AdapterView<*>, v: View?, position: Int, id: Long) {
	 	if (parent === classifyHeartDiseaseheartDiseaseSpinner) {
	 	    classifyHeartDiseaseheartDiseaseData = classifyHeartDiseaseheartDiseaseListItems[position]
	 	}
	 	    }
	 	
	 	    override fun onNothingSelected(parent: AdapterView<*>) {
	 	    	//onNothingSelected
	 	    }

}
