package com.example.heartdisease

import com.google.firebase.database.*
import kotlin.collections.ArrayList

class FirebaseDB() {

    var database: DatabaseReference? = null

    companion object {
        private var instance: FirebaseDB? = null
        fun getInstance(): FirebaseDB {
            return instance ?: FirebaseDB()
        }
    }

    init {
        connectByURL("https://heartdisease-c4065-default-rtdb.europe-west1.firebasedatabase.app/")
    }

    fun connectByURL(url: String) {
        database = FirebaseDatabase.getInstance(url).reference
        if (database == null) {
            return
        }
        val heartDiseaseListener: ValueEventListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get instances from the cloud database
                val heartDiseases = dataSnapshot.value as HashMap<String, Object>?
                if (heartDiseases != null) {
                    val keys = heartDiseases.keys
                    for (key in keys) {
                        val x = heartDiseases[key]
                        HeartDiseaseDAO.parseRaw(x)
                    }
                    // Delete local objects which are not in the cloud:
                    val locals = ArrayList<HeartDisease>()
                    locals.addAll(HeartDisease.HeartDiseaseAllInstances)
                    for (x in locals) {
                        if (keys.contains(x.id)) {
                            //check
                        } else {
                            HeartDisease.killHeartDisease(x.id)
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
            	//onCancelled
            }
        }
        database!!.child("heartDiseases").addValueEventListener(heartDiseaseListener)
    }

    fun persistHeartDisease(ex: HeartDisease) {
        val evo = HeartDiseaseVO(ex)
        val key = evo.getId()
        if (database == null) {
            return
        }
        database!!.child("heartDiseases").child(key).setValue(evo)
    }

    fun deleteHeartDisease(ex: HeartDisease) {
        val key: String = ex.id
        if (database == null) {
            return
        }
        database!!.child("heartDiseases").child(key).removeValue()
    }
}
