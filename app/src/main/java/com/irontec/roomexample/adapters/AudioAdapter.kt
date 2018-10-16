package com.irontec.roomexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.irontec.roomexample.R
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.Audio
import com.irontec.roomexample.database.entities.Story
import kotlinx.android.synthetic.main.row_bill.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import java.text.NumberFormat
import java.util.*

/**
 * Created by axier on 8/2/18.
 */
class AudioAdapter(private val mContext: Context, private val mData: MutableList<Audio>) : BaseAdapter() {

    fun addAll(customers: List<Audio>) {
        mData.clear()
        mData.addAll(customers)
        notifyDataSetChanged()
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun getItem(position: Int): Any {
        return mData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        val viewHolder: ViewHolder
        if (view != null) {
            viewHolder = view.tag as ViewHolder
        } else {
            view = LayoutInflater.from(mContext)
                    .inflate(R.layout.row_bill, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }

        val audio = mData[position]
        doAsync {

            /*val story: Story = AppDatabase.getInstance(context = mContext)
                    .storyDao()
                    .loadAllByIds(arrayOf(audio.storyId))
                    .first()

            uiThread {

                viewHolder.customer.text = String.format("%s %s", story.dateBegan, story.audioFileName)

            }*/
        }

        viewHolder.amount.text = String.format("%s", audio.audioTitle + "::" + audio.audioUrl)

        return view!!
    }

    internal class ViewHolder(view: View) {

        var customer: TextView
        var amount: TextView

        init {
            customer = view.bill_customer
            amount = view.bill_amount
        }
    }

}
