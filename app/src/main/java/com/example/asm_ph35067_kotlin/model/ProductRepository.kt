package com.example.asm_ph35067_kotlin.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object ProductRepository {
    private const val PREFS_NAME = "prod_prefs"
    private const val PRODS_KEY = "prods"

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getProd(): MutableList<ModelProduct> {
        val prodsJson = sharedPreferences.getString(PRODS_KEY, null)
        return if (prodsJson.isNullOrEmpty()) {
            mutableListOf()
        } else {
            gson.fromJson(prodsJson, object : TypeToken<MutableList<ModelProduct>>() {}.type)
        }
    }

    fun addProd(prod: ModelProduct) {
        val prods = getProd()
        prods.add(prod)
        saveProds(prods)
    }

    fun updateProd(prod: ModelProduct): Boolean {
        val prods = getProd()
        val index = prods.indexOfFirst { it.id_prod == prod.id_prod }
        return if (index != -1) {
            prods[index] = prod
            saveProds(prods)
            true
        } else {
            false
        }
    }

    fun deleteProd(id: Int): Boolean {
        val prods = getProd()
        val removed = prods.removeIf { it.id_prod == id }
        if (removed) {
            saveProds(prods)
        }
        return removed
    }

    private fun saveProds(prods: MutableList<ModelProduct>) {
        val editor = sharedPreferences.edit()
        editor.putString(PRODS_KEY, gson.toJson(prods))
        editor.apply()
    }
}
