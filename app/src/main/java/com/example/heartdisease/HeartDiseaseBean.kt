package com.example.heartdisease

import android.content.Context
import java.lang.Exception

class HeartDiseaseBean(c: Context) {

    private var model: ModelFacade = ModelFacade.getInstance(c)

    private var id = ""
    private var age = ""
    private var dage = 0
    private var sex = ""
    private var dsex = 0
    private var cp = ""
    private var dcp = 0
    private var trestbps = ""
    private var dtrestbps = 0
    private var chol = ""
    private var dchol = 0
    private var fbs = ""
    private var dfbs = 0
    private var restecg = ""
    private var drestecg = 0
    private var thalach = ""
    private var dthalach = 0
    private var exang = ""
    private var dexang = 0
    private var oldpeak = ""
    private var doldpeak = 0
    private var slope = ""
    private var dslope = 0
    private var ca = ""
    private var dca = 0
    private var thal = ""
    private var dthal = 0
    private var outcome = ""

    private var errors = ArrayList<String>()
    private var checkParameter = "is not exist"

    fun setId(idx: String) {
	 id = idx
    }
    
    fun setAge(agex: String) {
	 age = agex
    }
    
    fun setSex(sexx: String) {
	 sex = sexx
    }
    
    fun setCp(cpx: String) {
	 cp = cpx
    }
    
    fun setTrestbps(trestbpsx: String) {
	 trestbps = trestbpsx
    }
    
    fun setChol(cholx: String) {
	 chol = cholx
    }
    
    fun setFbs(fbsx: String) {
	 fbs = fbsx
    }
    
    fun setRestecg(restecgx: String) {
	 restecg = restecgx
    }
    
    fun setThalach(thalachx: String) {
	 thalach = thalachx
    }
    
    fun setExang(exangx: String) {
	 exang = exangx
    }
    
    fun setOldpeak(oldpeakx: String) {
	 oldpeak = oldpeakx
    }
    
    fun setSlope(slopex: String) {
	 slope = slopex
    }
    
    fun setCa(cax: String) {
	 ca = cax
    }
    
    fun setThal(thalx: String) {
	 thal = thalx
    }
    
    fun setOutcome(outcomex: String) {
	 outcome = outcomex
    }
    


    fun resetData() {
	  id = ""
	  age = ""
	  sex = ""
	  cp = ""
	  trestbps = ""
	  chol = ""
	  fbs = ""
	  restecg = ""
	  thalach = ""
	  exang = ""
	  oldpeak = ""
	  slope = ""
	  ca = ""
	  thal = ""
	  outcome = ""
    }
    
    fun isCreateHeartDiseaseError(): Boolean {
	        
	        errors.clear()
	        
          if (id != "") {
	//validate
}
	         else {
	               errors.add("id cannot be empty")
	         }
	    try {
	          dage = age.toInt()
	        } catch (e: Exception) {
	        	errors.add("age is not a Int")
	        }
    try {
	          dsex = sex.toInt()
	        } catch (e: Exception) {
	        	errors.add("sex is not a Int")
	        }
    try {
	          dcp = cp.toInt()
	        } catch (e: Exception) {
	        	errors.add("cp is not a Int")
	        }
    try {
	          dtrestbps = trestbps.toInt()
	        } catch (e: Exception) {
	        	errors.add("trestbps is not a Int")
	        }
    try {
	          dchol = chol.toInt()
	        } catch (e: Exception) {
	        	errors.add("chol is not a Int")
	        }
    try {
	          dfbs = fbs.toInt()
	        } catch (e: Exception) {
	        	errors.add("fbs is not a Int")
	        }
    try {
	          drestecg = restecg.toInt()
	        } catch (e: Exception) {
	        	errors.add("restecg is not a Int")
	        }
    try {
	          dthalach = thalach.toInt()
	        } catch (e: Exception) {
	        	errors.add("thalach is not a Int")
	        }
    try {
	          dexang = exang.toInt()
	        } catch (e: Exception) {
	        	errors.add("exang is not a Int")
	        }
    try {
	          doldpeak = oldpeak.toInt()
	        } catch (e: Exception) {
	        	errors.add("oldpeak is not a Int")
	        }
    try {
	          dslope = slope.toInt()
	        } catch (e: Exception) {
	        	errors.add("slope is not a Int")
	        }
    try {
	          dca = ca.toInt()
	        } catch (e: Exception) {
	        	errors.add("ca is not a Int")
	        }
    try {
	          dthal = thal.toInt()
	        } catch (e: Exception) {
	        	errors.add("thal is not a Int")
	        }

	        return errors.size > 0
	    }
	    
	    fun createHeartDisease() {
	        model.createHeartDisease(HeartDiseaseVO(id, dage, dsex, dcp, dtrestbps, dchol, dfbs, drestecg, dthalach, dexang, doldpeak, dslope, dca, dthal, outcome))
	        resetData()
	    }
	   
     fun editHeartDisease() {
		     model.editHeartDisease(HeartDiseaseVO(id, dage, dsex, dcp, dtrestbps, dchol, dfbs, drestecg, dthalach, dexang, doldpeak, dslope, dca, dthal, outcome))
		     resetData()
		 }
		       
		 fun isEditHeartDiseaseError(allHeartDiseaseids: List<String>): Boolean {
       
       errors.clear()
			
			if (!allHeartDiseaseids.contains(id)) {
				errors.add("id" + checkParameter)
		    }
          if (id != "") {
	//validate
}
	         else {
	               errors.add("id cannot be empty")
	         }
    try {
	          dage = age.toInt()
	        } catch (e: Exception) {
	        	errors.add("age is not a Int")
	        }
    try {
	          dsex = sex.toInt()
	        } catch (e: Exception) {
	        	errors.add("sex is not a Int")
	        }
    try {
	          dcp = cp.toInt()
	        } catch (e: Exception) {
	        	errors.add("cp is not a Int")
	        }
    try {
	          dtrestbps = trestbps.toInt()
	        } catch (e: Exception) {
	        	errors.add("trestbps is not a Int")
	        }
    try {
	          dchol = chol.toInt()
	        } catch (e: Exception) {
	        	errors.add("chol is not a Int")
	        }
    try {
	          dfbs = fbs.toInt()
	        } catch (e: Exception) {
	        	errors.add("fbs is not a Int")
	        }
    try {
	          drestecg = restecg.toInt()
	        } catch (e: Exception) {
	        	errors.add("restecg is not a Int")
	        }
    try {
	          dthalach = thalach.toInt()
	        } catch (e: Exception) {
	        	errors.add("thalach is not a Int")
	        }
    try {
	          dexang = exang.toInt()
	        } catch (e: Exception) {
	        	errors.add("exang is not a Int")
	        }
    try {
	          doldpeak = oldpeak.toInt()
	        } catch (e: Exception) {
	        	errors.add("oldpeak is not a Int")
	        }
    try {
	          dslope = slope.toInt()
	        } catch (e: Exception) {
	        	errors.add("slope is not a Int")
	        }
    try {
	          dca = ca.toInt()
	        } catch (e: Exception) {
	        	errors.add("ca is not a Int")
	        }
    try {
	          dthal = thal.toInt()
	        } catch (e: Exception) {
	        	errors.add("thal is not a Int")
	        }

       return errors.size > 0
   }
       
   fun deleteHeartDisease() {
       model.deleteHeartDisease(id)
       resetData()
   }
   
   fun isDeleteHeartDiseaseError(allHeartDiseaseids: List<String>): Boolean {
        errors.clear()
			 if (!allHeartDiseaseids.contains(id)) {
			    errors.add("id" + checkParameter)
        }
        return errors.size > 0
		}    

   	fun isSearchHeartDiseaseError(allHeartDiseaseages: List<String>): Boolean {
        errors.clear()
        if (!allHeartDiseaseages.contains(age)) {
            errors.add("age" + checkParameter)
        }
        return errors.size > 0
    }
    
		fun isSearchHeartDiseaseIdError(allHeartDiseaseIds: List<String>): Boolean {
    	   errors.clear()
   	       if (!allHeartDiseaseIds.contains(id)) {
    	       errors.add("id" + checkParameter)
    	   }
           return errors.size > 0
    }

    fun errors(): String {
        return errors.toString()
    }



}

