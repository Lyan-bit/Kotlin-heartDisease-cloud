package com.example.heartdisease

import android.content.Context
import java.util.*

class ClassifyHeartDiseaseBean(c: Context) {
    private var model: ModelFacade = ModelFacade.getInstance(c)

    private var heartdisease = ""
	private var instanceHeartDisease: HeartDisease? = null
	

    private var errors = ArrayList<String>()

    fun setHeartDisease(heartdiseasex: String) {
        heartdisease = heartdiseasex
    }
    

    fun resetData() {
        heartdisease = ""
    }

    fun isClassifyHeartDiseaseError(): Boolean {
        errors.clear()
        instanceHeartDisease = model.getHeartDiseaseByPK(heartdisease)
        if (instanceHeartDisease == null) {
            errors.add("heartDisease must be a valid HeartDisease id")
        }
        

        return errors.isNotEmpty()
    }

    fun errors(): String {
        return errors.toString()
    }

     fun classifyHeartDisease (): String {
        return model.classifyHeartDisease(instanceHeartDisease!!)
     }
}
