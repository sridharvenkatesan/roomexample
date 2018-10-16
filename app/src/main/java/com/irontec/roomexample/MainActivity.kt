package com.irontec.roomexample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import com.irontec.roomexample.database.AppDatabase
import com.irontec.roomexample.database.entities.Audio
import com.irontec.roomexample.database.entities.Story
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*

class MainActivity : AppCompatActivity() {
    var url: String = "https://github.com/irontec/android-room-example"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stories.setOnClickListener({ _ ->
            val intent = Intent(this@MainActivity, StoriesActivity::class.java)
            startActivity(intent)
        })

        audios.setOnClickListener({ _ ->
            val intent = Intent(this@MainActivity, AudioActivity::class.java)
            startActivity(intent)
        })

        new_story.setOnClickListener({ _ ->
            doAsync {

                val audios = AppDatabase.getInstance(this@MainActivity).audioDao().all
                val names: MutableList<CharSequence> = arrayListOf()
                audios.asSequence()
                        .mapTo(names) {
                            String.format("%s %s", it.audioTitle, it.audioUrl)
                        }

                uiThread {

                    selector(getString(R.string.dialog_title), names, { _, i ->

                        alert {
                            customView {
                                verticalLayout {
                                    val amount = editText {
                                        inputType = InputType.TYPE_CLASS_NUMBER
                                        padding = dip(16)
                                        hint = getString(R.string.dialog_hint)
                                    }
                                    positiveButton("Register") {
                                        saveAmount(amount.text.toString(), audios.get(i))
                                    }
                                }
                            }
                        }.show()
                        toast("So you're living in ${names[i]}, right?")
                    })

                }
            }

        })

        new_moments.setOnClickListener({ _ ->
            val intent = Intent(this@MainActivity, ProvidersActivity::class.java)
            startActivity(intent)
        })

    }

    private fun saveAmount(amount: String, audio: Audio) {
        doAsync {
            val file_name = "sample.json"
            val json_string = assets.open(file_name).bufferedReader().use {
                it.readText()
            }
            /*        val client = Story("10-10-18", "story" + index, "1" + index, "true", "audio" + index,
                            url, "08-10-18"+index, "", "", "", "", "", 1, 1,
                            1, "", "", "", "", "", "")*/
            val story = Story(audioDatePurchased = "10-10-18", audioFileName = "story", audioIdentifier = "1", audioInappPurchased = "true", audioName = "audio", audioUrl = "",
                    dateBegan = "08-08-18", dateCreatedMovie = "", dateLastRendered = "", dateMovieUploaded = "", dateThumbnailUploaded = "", defaultMusicFile = "",
                    inviteStatus = 1, isActive = 1, isShared = 2, momentsOrder = "", movieIdentifier = "", order = "", provisionalMovieIdentifier = "", remoteUrlString = "", restoredMovieId = "", audioId = audio.uid)
            AppDatabase.getInstance(this@MainActivity).storyDao().insert(story)
        }
    }
}
