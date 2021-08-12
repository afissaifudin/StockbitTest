package com.afisdev.stockbittest.adapter

import android.view.View
import android.view.ViewGroup
import com.afisdev.core.extension.*
import com.afisdev.core.ui.BaseRecylerAdapter
import com.afisdev.stockbittest.R
import com.afisdev.stockbittest.adapter.ToplistAdapter.ToplistViewHolder
import com.afisdev.stockbittest.model.Toplist
import kotlinx.android.synthetic.main.toplist_item.view.*

class ToplistAdapter(data: MutableList<Toplist>) :
    BaseRecylerAdapter<Toplist, ToplistViewHolder>(data)     {

    inner class ToplistViewHolder(itemView: View) : BaseViewHolder(itemView) {
        override fun bind(item: Toplist) {
            val usd = item.RAW?.currency
            val coinInfo = item.CoinInfo
            val priceGap = usd?.getPriceGap()
            val percent = usd?.getPercent()
            with(itemView) {
                tvName.text = coinInfo?.Name
                tvFullName.text = coinInfo?.FullName
                tvPrice.text = usd?.PRICE?.roundingAndDecimalFormat() ?: "N/A"
                tvCalculatePercent.apply {
                    text = priceGap?.formatDataCalPercent(percent) ?: "N/A"
                    setTextColor(resources.getColor(percent?.let { getBgColor(it) } ?: R.color.silver ))
                }
            }
        }

        private fun getBgColor(number: Double): Int{
            return when{
                number > 0 -> R.color.green
                number < 0 -> R.color.red
                else -> R.color.silver
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToplistViewHolder {
        val view = parent.inflate(R.layout.toplist_item)
        return ToplistViewHolder(view)
    }
}