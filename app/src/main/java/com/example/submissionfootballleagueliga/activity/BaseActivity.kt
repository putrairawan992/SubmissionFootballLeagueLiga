package com.example.submissionfootballleagueliga.activity

import androidx.appcompat.app.AppCompatActivity
import com.example.submissionfootballleagueliga.R
import com.example.submissionfootballleagueliga.model.Liga
import org.json.JSONObject

open class BaseActivity : AppCompatActivity() {

    protected fun initActionBar(uiClass: String?){
        supportActionBar?.apply {
            title = "League Football"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
            if (uiClass.equals("main")){
                setDisplayHomeAsUpEnabled(false)
            }
        }
    }

    protected  fun getLeagueData() : List<Liga>{
        val leagueList : MutableList<Liga> = mutableListOf()
        val jsonFile : String? = applicationContext.assets.open("dataLeague.json").bufferedReader().use { it.readText() }
        JSONObject(jsonFile).apply {
            getJSONArray("dataLeague").apply {
                for (i in 0 until length()){
                    getJSONObject(i).apply{
                        leagueList.add(Liga(getString("logo"),getString("nameLeague"),getString("description")))
                    }
                }
            }
        }
        return leagueList
    }
}