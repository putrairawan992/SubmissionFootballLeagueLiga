package com.example.submissionfootballleagueliga.adapter

import android.net.Uri
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.submissionfootballleagueliga.R
import com.example.submissionfootballleagueliga.model.Liga
import com.example.submissionfootballleagueliga.ui.ItemListUI
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import org.jetbrains.anko.AnkoContext

class LigaAdapter(private var leagueList: List<Liga>, private val listener: (Liga) -> Unit) :
    RecyclerView.Adapter<LigaAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) =
        ViewHolder(ItemListUI().createView(AnkoContext.Companion.create(parent.context, parent)))

    override fun getItemCount() = leagueList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(leagueList[position], listener)
    }

    inner class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {

        private val itemLinearLayout = itemView.findViewById<LinearLayout>(ItemListUI.linear_layout)
        private val itemLogo = itemView.findViewById<ImageView>(ItemListUI.league_logo)
        private val itemName = itemView.findViewById<TextView>(ItemListUI.league_nameLeague)

        fun bind(league: Liga, listener: (Liga) -> Unit) {
            league.logo.let {
                Picasso.get().load(Uri.parse(it))
                    .placeholder(R.drawable.ic_broken_image)
                    .error(R.drawable.ic_broken_image)
                    .into(itemLogo)
            }
            itemName.text = league.nameLeague
            itemLinearLayout.setOnClickListener {
                listener(league)
            }
        }
    }
}