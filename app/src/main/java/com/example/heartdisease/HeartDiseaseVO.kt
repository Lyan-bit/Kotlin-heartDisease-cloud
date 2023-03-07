package com.example.heartdisease

import java.util.ArrayList

class HeartDiseaseVO  {

    private var id: String = ""
    private var age: Int = 0
    private var sex: Int = 0
    private var cp: Int = 0
    private var trestbps: Int = 0
    private var chol: Int = 0
    private var fbs: Int = 0
    private var restecg: Int = 0
    private var thalach: Int = 0
    private var exang: Int = 0
    private var oldpeak: Int = 0
    private var slope: Int = 0
    private var ca: Int = 0
    private var thal: Int = 0
    private var outcome: String = ""

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
    
    fun getId(): String {
        return id
    }
    
    fun getAge(): Int {
        return age
    }
    
    fun getSex(): Int {
        return sex
    }
    
    fun getCp(): Int {
        return cp
    }
    
    fun getTrestbps(): Int {
        return trestbps
    }
    
    fun getChol(): Int {
        return chol
    }
    
    fun getFbs(): Int {
        return fbs
    }
    
    fun getRestecg(): Int {
        return restecg
    }
    
    fun getThalach(): Int {
        return thalach
    }
    
    fun getExang(): Int {
        return exang
    }
    
    fun getOldpeak(): Int {
        return oldpeak
    }
    
    fun getSlope(): Int {
        return slope
    }
    
    fun getCa(): Int {
        return ca
    }
    
    fun getThal(): Int {
        return thal
    }
    
    fun getOutcome(): String {
        return outcome
    }
    

    fun setId(x: String) {
    	id = x
    }
    
    fun setAge(x: Int) {
    	age = x
    }
    
    fun setSex(x: Int) {
    	sex = x
    }
    
    fun setCp(x: Int) {
    	cp = x
    }
    
    fun setTrestbps(x: Int) {
    	trestbps = x
    }
    
    fun setChol(x: Int) {
    	chol = x
    }
    
    fun setFbs(x: Int) {
    	fbs = x
    }
    
    fun setRestecg(x: Int) {
    	restecg = x
    }
    
    fun setThalach(x: Int) {
    	thalach = x
    }
    
    fun setExang(x: Int) {
    	exang = x
    }
    
    fun setOldpeak(x: Int) {
    	oldpeak = x
    }
    
    fun setSlope(x: Int) {
    	slope = x
    }
    
    fun setCa(x: Int) {
    	ca = x
    }
    
    fun setThal(x: Int) {
    	thal = x
    }
    
    fun setOutcome(x: String) {
    	outcome = x
    }
    
}
