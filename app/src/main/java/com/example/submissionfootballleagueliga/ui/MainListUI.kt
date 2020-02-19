package com.example.submissionfootballleagueliga.ui

import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.submissionfootballleagueliga.activity.DetailActivity
import com.example.submissionfootballleagueliga.activity.MainActivity
import com.example.submissionfootballleagueliga.adapter.LigaAdapter
import com.example.submissionfootballleagueliga.model.Liga
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.verticalLayout

class MainListUI(private var leagueList: List<Liga>) : AnkoComponent<MainActivity> {
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {
            orientation = LinearLayout.VERTICAL
            recyclerView {
                layoutManager = GridLayoutManager(context, 2)
                adapter = LigaAdapter(leagueList) {
                    startActivity<DetailActivity>(DetailActivity.LEAGUE_DATA_EXTRA_KEY to it)
                }
            }
        }
    }
}