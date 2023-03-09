package com.example.heartdisease

import org.json.JSONObject
import java.lang.Exception
import org.json.JSONArray
import kotlin.collections.ArrayList

class HeartDiseaseDAO {

    companion object {

        fun getURL(command: String?, pars: ArrayList<String>, values: ArrayList<String>): String {
            var res = "base url for the data source"
            if (command != null) {
                res += command
            }
            if (pars.size == 0) {
                return res
            }
            res = "$res?"
            for (item in pars.indices) {
                val par = pars[item]
                val vals = values[item]
                res = "$res$par=$vals"
                if (item < pars.size - 1) {
                    res = "$res&"
                }
            }
            return res
        }

        fun isCached(id: String?): Boolean {
            HeartDisease.HeartDiseaseIndex.get(id) ?: return false
            return true
        }

        fun getCachedInstance(id: String): HeartDisease? {
            return HeartDisease.HeartDiseaseIndex.get(id)
        }

      fun parseCSV(line: String?): HeartDisease? {
          if (line == null) {
              return null
          }
          val line1vals: ArrayList<String> = Ocl.tokeniseCSV(line)
          var heartDiseasex: HeartDisease? = HeartDisease.HeartDiseaseIndex.get(line1vals[0])
          if (heartDiseasex == null) {
              heartDiseasex = HeartDisease.createByPKHeartDisease(line1vals[0])
          }
          heartDiseasex.id = line1vals[0].toString()
          heartDiseasex.age = line1vals[1].toInt()
          heartDiseasex.sex = line1vals[2].toInt()
          heartDiseasex.cp = line1vals[3].toInt()
          heartDiseasex.trestbps = line1vals[4].toInt()
          heartDiseasex.chol = line1vals[5].toInt()
          heartDiseasex.fbs = line1vals[6].toInt()
          heartDiseasex.restecg = line1vals[7].toInt()
          heartDiseasex.thalach = line1vals[8].toInt()
          heartDiseasex.exang = line1vals[9].toInt()
          heartDiseasex.oldpeak = line1vals[10].toInt()
          heartDiseasex.slope = line1vals[11].toInt()
          heartDiseasex.ca = line1vals[12].toInt()
          heartDiseasex.thal = line1vals[13].toInt()
          heartDiseasex.outcome = line1vals[14].toString()
          return heartDiseasex
      }


        fun parseJSON(obj: JSONObject?): HeartDisease? {
            return if (obj == null) {
                null
            } else try {
                val id = obj.getString("id")
                var heartDiseasex: HeartDisease? = HeartDisease.HeartDiseaseIndex.get(id)
                if (heartDiseasex == null) {
                    heartDiseasex = HeartDisease.createByPKHeartDisease(id)
                }
                heartDiseasex.id = obj.getString("id")
                heartDiseasex.age = obj.getInt("age")
                heartDiseasex.sex = obj.getInt("sex")
                heartDiseasex.cp = obj.getInt("cp")
                heartDiseasex.trestbps = obj.getInt("trestbps")
                heartDiseasex.chol = obj.getInt("chol")
                heartDiseasex.fbs = obj.getInt("fbs")
                heartDiseasex.restecg = obj.getInt("restecg")
                heartDiseasex.thalach = obj.getInt("thalach")
                heartDiseasex.exang = obj.getInt("exang")
                heartDiseasex.oldpeak = obj.getInt("oldpeak")
                heartDiseasex.slope = obj.getInt("slope")
                heartDiseasex.ca = obj.getInt("ca")
                heartDiseasex.thal = obj.getInt("thal")
                heartDiseasex.outcome = obj.getString("outcome")
                heartDiseasex
            } catch (e: Exception) {
                null
            }
        }

      fun makeFromCSV(lines: String?): ArrayList<HeartDisease> {
          val result: ArrayList<HeartDisease> = ArrayList<HeartDisease>()
          if (lines == null) {
              return result
          }
          val rows: ArrayList<String> = Ocl.parseCSVtable(lines)
          for (item in rows.indices) {
              val row = rows[item]
              if (row == null || row.trim { it <= ' ' }.length == 0) {
                  //trim
              } else {
                  val x: HeartDisease? = parseCSV(row)
                  if (x != null) {
                      result.add(x)
                  }
              }
          }
          return result
      }


        fun parseJSONArray(jarray: JSONArray?): ArrayList<HeartDisease>? {
            if (jarray == null) {
                return null
            }
            val res: ArrayList<HeartDisease> = ArrayList<HeartDisease>()
            val len = jarray.length()
            for (i in 0 until len) {
                try {
                    val x = jarray.getJSONObject(i)
                    if (x != null) {
                        val y: HeartDisease? = parseJSON(x)
                        if (y != null) {
                            res.add(y)
                        }
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            return res
        }


        fun writeJSON(x: HeartDisease): JSONObject? {
            val result = JSONObject()
            try {
                result.put("id", x.id)
                result.put("age", x.age)
                result.put("sex", x.sex)
                result.put("cp", x.cp)
                result.put("trestbps", x.trestbps)
                result.put("chol", x.chol)
                result.put("fbs", x.fbs)
                result.put("restecg", x.restecg)
                result.put("thalach", x.thalach)
                result.put("exang", x.exang)
                result.put("oldpeak", x.oldpeak)
                result.put("slope", x.slope)
                result.put("ca", x.ca)
                result.put("thal", x.thal)
                result.put("outcome", x.outcome)
            } catch (e: Exception) {
                return null
            }
            return result
        }


        fun parseRaw(obj: Any?): HeartDisease? {
             if (obj == null) {
                 return null
            }
            try {
                val map = obj as HashMap<String, Object>
                val id: String = map["id"].toString()
                var heartDiseasex: HeartDisease? = HeartDisease.HeartDiseaseIndex.get(id)
                if (heartDiseasex == null) {
                    heartDiseasex = HeartDisease.createByPKHeartDisease(id)
                }
                heartDiseasex.id = map["id"].toString()
                heartDiseasex.age = (map["age"] as Long?)!!.toLong().toInt()
                heartDiseasex.sex = (map["sex"] as Long?)!!.toLong().toInt()
                heartDiseasex.cp = (map["cp"] as Long?)!!.toLong().toInt()
                heartDiseasex.trestbps = (map["trestbps"] as Long?)!!.toLong().toInt()
                heartDiseasex.chol = (map["chol"] as Long?)!!.toLong().toInt()
                heartDiseasex.fbs = (map["fbs"] as Long?)!!.toLong().toInt()
                heartDiseasex.restecg = (map["restecg"] as Long?)!!.toLong().toInt()
                heartDiseasex.thalach = (map["thalach"] as Long?)!!.toLong().toInt()
                heartDiseasex.exang = (map["exang"] as Long?)!!.toLong().toInt()
                heartDiseasex.oldpeak = (map["oldpeak"] as Long?)!!.toLong().toInt()
                heartDiseasex.slope = (map["slope"] as Long?)!!.toLong().toInt()
                heartDiseasex.ca = (map["ca"] as Long?)!!.toLong().toInt()
                heartDiseasex.thal = (map["thal"] as Long?)!!.toLong().toInt()
                heartDiseasex.outcome = map["outcome"].toString()
                return heartDiseasex
            } catch (e: Exception) {
                return null
            }
        }

        fun writeJSONArray(es: ArrayList<HeartDisease>): JSONArray {
            val result = JSONArray()
            for (i in 0 until es.size) {
                val ex: HeartDisease = es[i]
                val jx = writeJSON(ex)
                if (jx == null) {
                    //null
                } else {
                    try {
                        result.put(jx)
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }
            return result
        }
    }
}
