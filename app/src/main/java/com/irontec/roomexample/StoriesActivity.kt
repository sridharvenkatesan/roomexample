package com.irontec.roomexample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.irontec.roomexample.adapters.StoriesAdapter
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.Audio
import kotlinx.android.synthetic.main.activity_customer.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class StoriesActivity : AppCompatActivity() {

    private var mAdapter: StoriesAdapter? = null
    private lateinit var database: AppDatabase;
    private val url: String = "https://github.com/irontec/android-room-example2"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        database = AppDatabase.getInstance(context = this@StoriesActivity)

        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        }

        mAdapter = StoriesAdapter(this@StoriesActivity, mutableListOf())
        customer_list.adapter = mAdapter

        doAsyncOperation(1)

        /*   doAsync {
               val stories = database.storyDao().all
               var story1 = stories.get(2)
               val story: Story = database
                       .storyDao()
                       .loadAllByIds(arrayOf(story1.audioId))
                       .first()

               uiThread {

   //                viewHolder.customer.text = String.format("%s %s", audio.audioTemplate, audio.audioUrl)

               }
           }*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.empty, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            finish()
        } else if (id == R.id.delete_menu) {
            doAsyncOperation(2)
        } else {
            doAsyncOperation(3)
        }
        return super.onOptionsItemSelected(item)
    }

    fun doAsyncOperation(identifier: Int) {
        doAsync {
            if (identifier == 1) {
                val audios = database.storyDao().all
                uiThread {
                    mAdapter!!.addAll(audios)
                }
            } else if (identifier == 2) {
                database.audioDao().deleteAll()
                runOnUiThread {
                    mAdapter!!.deleteAll()
                }
            } else {
                var audio: Audio
                audio = database.audioDao().findByPromo("28952", url)
                println(database.audioDao().findByPromo("28952", url).promoCode)
                println(audio.promoCode + ":::" + audio.uid + ":::::" + audio.audioUrl)
            }
        }
    }
}
