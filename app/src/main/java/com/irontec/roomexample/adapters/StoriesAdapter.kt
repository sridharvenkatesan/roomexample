package com.irontec.roomexample.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.irontec.roomexample.R
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.Audio
import com.irontec.roomexample.database.entities.Story
import kotlinx.android.synthetic.main.row_customer.view.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

/**
 * Created by axier on 8/2/18.
 */
class StoriesAdapter(private val mContext: Context, private val mData: MutableList<Story>) : BaseAdapter() {

    fun addAll(audios: List<Story>) {
        mData.clear()
        mData.addAll(audios)
        notifyDataSetChanged()
    }

    fun removeFromList(story: Story, audioList: MutableList<Story>) {
        mData.clear()
        audioList.remove(story)
        mData.addAll(audioList)
        notifyDataSetInvalidated();
    }

    fun updateList(story: Story, audioList: MutableList<Story>, position: Int) {
        mData.removeAt(position)
        mData.add(position, story)
        notifyDataSetChanged();
    }

    fun deleteAll() {
        mData.clear()
        notifyDataSetInvalidated()
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
                    .inflate(R.layout.row_customer, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }

        val story = mData[position]
        doAsync {

            val audio: Audio = AppDatabase.getInstance(context = mContext)
                    .audioDao()
                    .loadAllByIds(arrayOf(story.audioId))
                    .first()

            uiThread {

                viewHolder.title.text = String.format("%s %s", story.audioFileName, audio.promoCode)

            }
        }
        viewHolder.title.text = String.format("%s %s", story.audioFileName, story.audioUrl)
        /* try {
             println("audio_template" + convertByteArrayToString(story))
         } catch (e: JSONException) {
             e.printStackTrace()
         }*/
        /*viewHolder.deleteBtn.setOnClickListener {
            doAsync {
                val database = AppDatabase.getInstance(context = mContext)
                val audios: MutableList<Story> = database.audioDao().all as MutableList<Story>
                database.audioDao().deleteById(audios.get(position).uid)
                mContext.runOnUiThread {
                    removeFromList(audios.get(position), audios)
                }
            }
        }
        viewHolder.editBtn.setOnClickListener {
            doAsync {
                val database = AppDatabase.getInstance(context = mContext)
                val audios: MutableList<Story> = database.audioDao().all as MutableList<Story>
                audios.get(position).audioUrl = "https://stackoverflow.com/questions/46358711/how-write-create-and-update-query-in-room-library"
                database.audioDao().updateAudio(audios.get(position))
                mContext.runOnUiThread {
                    updateList(audios.get(position), audios, position)
                }
            }
        }*/
        return view!!
    }

    /*private fun convertByteArrayToString(story: Story): String {
        var convertedStr: String = story.audioTemplate!!.toString(Charset.defaultCharset())
        var jsonData = JSONObject(convertedStr)
        var strVal: String = jsonData.getJSONObject("widget").getJSONObject("window").toString()
        return strVal
    }*/


    internal class ViewHolder(view: View) {

        var title: TextView
        var deleteBtn: ImageView
        var editBtn: ImageView

        init {
            title = view.customer_title
            deleteBtn = view.delete_btn
            editBtn = view.update
        }
    }

}
