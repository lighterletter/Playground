package john.lighterletter.com.galileo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import john.lighterletter.com.galileo.litho.TestActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        doSomething()
    }

    private fun doSomething() {
        val something = findViewById<View>(R.id.hello) as TextView
        something.text = "Whoa!"

        hello.text = "Holy wacanoly!" //This is wild. Extensions are generated from the id of the view.

        val button: Button = findViewById<Button>(R.id.button) as Button
        button.setOnClickListener { view ->
            startActivity(Intent(this, TestActivity::class.java))
        }
    }
}
