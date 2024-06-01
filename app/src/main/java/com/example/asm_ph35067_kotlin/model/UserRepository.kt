package com.example.asm_ph35067_kotlin.model

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object UserRepository {
    private const val PREFS_NAME = "user_prefs"
    private const val USERS_KEY = "users"

    private lateinit var sharedPreferences: SharedPreferences
    private val gson = Gson()

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getUsers(): MutableList<ModelUser> {
        val usersJson = sharedPreferences.getString(USERS_KEY, null)
        return if (usersJson.isNullOrEmpty()) {
            mutableListOf()
        } else {
            gson.fromJson(usersJson, object : TypeToken<MutableList<ModelUser>>() {}.type)
        }
    }

    fun addUser(user: ModelUser) {
        val users = getUsers()
        users.add(user)
        saveUsers(users)
    }

    private fun saveUsers(users: MutableList<ModelUser>) {
        val editor = sharedPreferences.edit()
        editor.putString(USERS_KEY, gson.toJson(users))
        editor.apply()
    }
}
