package com.example.lab1

import PostAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.lab1.models.Post

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val avatarImageView: ImageView = findViewById(R.id.imageView)

        val avatarUrl = "https://avatars.mds.yandex.net/get-altay/14110197/2a000001926276eec68379fe0208ac8e563a/XXXL"

        Glide.with(this)
            .load(avatarUrl)
            .circleCrop()
            .into(avatarImageView)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val posts = mutableListOf(
            Post("Приобрел малышечку", "https://images.unsplash.com/photo-1740940349301-d29d8c62e0f4?q=80&w=1964&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 12, 5),
            Post("Today I'm working all day long. I like it!", "https://images.unsplash.com/photo-1741034793661-3bd2a33d5b1b?q=80&w=1888&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 30, 10),
            Post("Путешествую по Непалу. Только посмотрите на эти шикарные горы. Человек настолько ничтожен перед мощью природы.", "https://images.unsplash.com/photo-1735926581492-cac597ddbd2e?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 44, 20),
            Post("Одного мудреца спросили:\n" +
                    "- Как вам удалось прожить так долго?\n" +
                    "- все просто, - ответил мудрец, - я никогда ни с кем не спорю\n" +
                    "- но это же невозможно!!!\n" +
                    "- возможно\n" +
                    "Мудрец умер", "https://images.unsplash.com/photo-1738369350430-87d667611998?q=80&w=1887&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 228, 132)
        )

        recyclerView.adapter = PostAdapter(posts)

        val subscribeBtn : Button = findViewById(R.id.button1)
        subscribeBtn.setOnClickListener {
            if (subscribeBtn.text == "Подписаться") {
                subscribeBtn.text = "Отписаться"
                subscribeBtn.setBackgroundResource(R.drawable.rounded_button_unsub)
            }
            else {
                subscribeBtn.text = "Подписаться"
                subscribeBtn.setBackgroundResource(R.drawable.rounded_button_sub)
            }
        }

        val exitButton: ImageView = findViewById(R.id.exitButton)
        exitButton.setOnClickListener {
            finish()
        }

    }
}