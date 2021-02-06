import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sharedpreferences.R
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        sharedPreferences = getSharedPreferences("userData", Context.MODE_PRIVATE)


    }


    fun save(view: View){
        val email = emailET.text.toString()
        val firstName = firstNameET.text.toString()
        val lastName = lastNameET.text.toString()
        val age = ageET.text.toString().toInt()
        val address = addressET.text.toString()

        val edit = sharedPreferences.edit()
        edit.putString("email",email)
        edit.putString("firstName",firstName)
        edit.putString("lastName",lastName)
        edit.putInt("age",age)
        edit.putString("address",address)
        edit.apply()


    }
    fun read(view: View){
        val email = sharedPreferences.getString("email","")
        val firstName = sharedPreferences.getString("firstName","")
        val lastName = sharedPreferences.getString("lastName","")
        val age = sharedPreferences.getInt("age",0)
        val address = sharedPreferences.getString("address","")

        emailET.setText(email)
        firstNameET.setText(firstName)
        lastNameET.setText(lastName)
        ageET.setText(age.toString())



    }
    fun delete(view: View){
        val edit = sharedPreferences.edit()
        edit.clear()
        edit.apply()

    }
}