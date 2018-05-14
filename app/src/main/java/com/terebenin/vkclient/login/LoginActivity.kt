package com.terebenin.vkclient.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import butterknife.BindView
import butterknife.ButterKnife
import com.terebenin.vkclient.R
import com.terebenin.vkclient.newsfeed.NewsActivity
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk

/**
 * Created by Evgeny Terebenin on 14.05.2018.
 */
class LoginActivity : Activity() {

    private val scope = arrayOf(VKScope.FRIENDS, VKScope.WALL, VKScope.OFFLINE)
    @BindView(R.id.uiBtnSignIn)
    internal var btnSignIn: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        val prefs = getPreferences(Context.MODE_PRIVATE)

        val restoredText = prefs.getBoolean("loginStatus", false)

        if (restoredText) {
            Toast.makeText(this@LoginActivity, R.string.logged_in, Toast.LENGTH_SHORT).show()
            val intent = Intent(this@LoginActivity, NewsActivity::class.java)
            startActivity(intent)
            finish()
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_login)
        ButterKnife.bind(this)

        btnSignIn!!.setOnClickListener { view: View -> VKSdk.login(this, *scope) }

    }
}