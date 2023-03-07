package com.example.heartdisease

import java.util.HashMap

class HeartDisease {

    init {
        HeartDiseaseAllInstances.add(this)
    }

    companion object {
        var HeartDiseaseAllInstances = ArrayList<HeartDisease>()
        fun createHeartDisease(): HeartDisease {
            return HeartDisease()
        }
        
        var HeartDiseaseIndex: HashMap<String, HeartDisease> = HashMap<String, HeartDisease>()
        
        fun createByPKHeartDisease(idx: String): HeartDisease {
            var result: HeartDisease? = HeartDiseaseIndex[idx]
            if (result != null) { return result }
                  result = HeartDisease()
                  HeartDiseaseIndex.put(idx,result)
                  result.id = idx
                  return result
        }
        
		fun killHeartDisease(idx: String?) {
            val rem = HeartDiseaseIndex[idx] ?: return
            val remd = ArrayList<HeartDisease>()
            remd.add(rem)
            HeartDiseaseIndex.remove(idx)
            HeartDiseaseAllInstances.removeAll(remd)
        }        
    }

    var id = ""  /* identity */
    var age = 0 
    var sex = 0 
    var cp = 0 
    var trestbps = 0 
    var chol = 0 
    var fbs = 0 
    var restecg = 0 
    var thalach = 0 
    var exang = 0 
    var oldpeak = 0 
    var slope = 0 
    var ca = 0 
    var thal = 0 
    var outcome = ""  /* derived */

}
