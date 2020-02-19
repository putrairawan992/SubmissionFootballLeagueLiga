package com.example.submissionfootballleagueliga.ui

import android.view.Gravity
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import com.example.submissionfootballleagueliga.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class ItemListUI : AnkoComponent<ViewGroup> {
    companion object {
        const val linear_layout = 0
        const val league_nameLeague = 1
        const val league_logo = 2
    }

    override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
        //CardView
        cardView {
            cardElevation = dip(2).toFloat()
            radius = dip(8).toFloat()
            //elevation = dip(2).toFloat()
            layoutParams =
                FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT
                ).apply { margin = dip(8) }
            verticalLayout {
                id = linear_layout
                orientation = LinearLayout.VERTICAL
                backgroundResource = attr(R.attr.selectableItemBackground).resourceId
                isClickable = true

                imageView { id = league_logo }.lparams(width = dip(100), height = dip(100)) {
                    gravity = Gravity.CENTER_HORIZONTAL
                }

                textView {
                    id = league_nameLeague
                    gravity = Gravity.CENTER
                }.lparams(matchParent, matchParent) {
                    gravity = Gravity.CENTER_HORIZONTAL
                    margin = dip(8)
                }
            }
        }
    }
}