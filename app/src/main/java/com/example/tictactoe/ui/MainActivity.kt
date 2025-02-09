package com.example.tictactoe.ui

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.tictactoe.R
import com.example.tictactoe.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var textTic: TextView
    private lateinit var textTac: TextView
    private lateinit var textToe: TextView
    private lateinit var tttIconView: View
    private lateinit var playButton: AppCompatButton
    private lateinit var analytics: FirebaseAnalytics
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textTic = findViewById(R.id.homeTic)
        textTac = findViewById(R.id.homeTac)
        textToe = findViewById(R.id.homeToe)
        tttIconView = findViewById(R.id.tttView)
        playButton = findViewById(R.id.homePlayButton)

        scaleTextTic()
        scaleTextTac()
        scaleTextToe()
        scaleTttIconView()


        val handler = Handler(mainLooper)
        handler.postDelayed({
            playButton.visibility = View.VISIBLE
        }, 3000)




//        // Obtain the FirebaseAnalytics instance.
//        analytics = Firebase.analytics
//
//        // Configure Google Sign In
//        val gso = GoogleSignInOptions
//            .Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//            .requestIdToken(getString(R.string.default_web_client_id))
//            .requestEmail()
//            .build()

//        googleSignInClient = GoogleSignIn.getClient(this, gso)

        playButton.setOnClickListener {
            val intent = Intent(this, ChooseGameType::class.java)
            startActivity(intent)
        }
    }

    private fun scaleTextTic() {
        val animation = ObjectAnimator.ofFloat(textTic, View.TRANSLATION_X, 200f, 0f)
        animation.duration = 1000
        animation.start()
    }

    private fun scaleTextTac() {
        val animation = ObjectAnimator.ofFloat(textTac, View.TRANSLATION_X, 200f, 0f )
        animation.duration = 2000
        animation.start()
    }

    private fun scaleTextToe() {
        val animation = ObjectAnimator.ofFloat(textToe, View.TRANSLATION_X, 200f, 0f )
        animation.duration = 3000
        animation.start()
    }

    private fun scaleTttIconView() {
        val animation = ObjectAnimator.ofFloat(tttIconView, View.TRANSLATION_Y, 200f, 0f)
        animation.duration = 3000
        animation.start()
    }

    override fun onBackPressed() {
        val a = Intent(Intent.ACTION_MAIN)
        a.addCategory(Intent.CATEGORY_HOME)
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(a)
    }


}