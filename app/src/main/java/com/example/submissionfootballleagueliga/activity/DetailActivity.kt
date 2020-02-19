package com.example.submissionfootballleagueliga.activity

import android.os.Bundle
import android.view.MenuItem
import com.example.submissionfootballleagueliga.model.Liga
import com.example.submissionfootballleagueliga.ui.DetailListUI
import org.jetbrains.anko.setContentView

class DetailActivity : BaseActivity() {
    companion object {
        const val LEAGUE_DATA_EXTRA_KEY = "league_data"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val league = intent.getParcelableExtra<Liga>(LEAGUE_DATA_EXTRA_KEY)
        initActionBar("detail")
        DetailListUI(league).setContentView(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}