package com.example.heartdisease

import java.util.ArrayList

class HeartDiseaseVO  {

   var id: String = ""
     var age: Int = 0
     var sex: Int = 0
     var cp: Int = 0
     var trestbps: Int = 0
     var chol: Int = 0
     var fbs: Int = 0
     var restecg: Int = 0
     var thalach: Int = 0
     var exang: Int = 0
     var oldpeak: Int = 0
     var slope: Int = 0
     var ca: Int = 0
     var thal: Int = 0
     var outcome: String = ""

    constructor() {
    	//constructor
    }

    constructor(idx: String, 
        agex: Int, 
        sexx: Int, 
        cpx: Int, 
        trestbpsx: Int, 
        cholx: Int, 
        fbsx: Int, 
        restecgx: Int, 
        thalachx: Int, 
        exangx: Int, 
        oldpeakx: Int, 
        slopex: Int, 
        cax: Int, 
        thalx: Int, 
        outcomex: String
        ) {
        this.id = idx
        this.age = agex
        this.sex = sexx
        this.cp = cpx
        this.trestbps = trestbpsx
        this.chol = cholx
        this.fbs = fbsx
        this.restecg = restecgx
        this.thalach = thalachx
        this.exang = exangx
        this.oldpeak = oldpeakx
        this.slope = slopex
        this.ca = cax
        this.thal = thalx
        this.outcome = outcomex
    }

    constructor (x: HeartDisease) {
        id = x.id
        age = x.age
        sex = x.sex
        cp = x.cp
        trestbps = x.trestbps
        chol = x.chol
        fbs = x.fbs
        restecg = x.restecg
        thalach = x.thalach
        exang = x.exang
        oldpeak = x.oldpeak
        slope = x.slope
        ca = x.ca
        thal = x.thal
        outcome = x.outcome
    }

    override fun toString(): String {
        return "id = $id,age = $age,sex = $sex,cp = $cp,trestbps = $trestbps,chol = $chol,fbs = $fbs,restecg = $restecg,thalach = $thalach,exang = $exang,oldpeak = $oldpeak,slope = $slope,ca = $ca,thal = $thal,outcome = $outcome"
    }

    fun toStringList(list: List<HeartDiseaseVO>): List<String> {
        val res: MutableList<String> = ArrayList()
        for (i in list.indices) {
            res.add(list[i].toString())
        }
        return res
    }
    
}
