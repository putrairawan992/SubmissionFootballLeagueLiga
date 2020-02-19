package com.example.submissionfootballleagueliga.activity

import android.os.Bundle
import com.example.submissionfootballleagueliga.ui.MainListUI
import org.jetbrains.anko.setContentView

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initActionBar("main")
        MainListUI(getLeagueData()).setContentView(this)
    }
}

