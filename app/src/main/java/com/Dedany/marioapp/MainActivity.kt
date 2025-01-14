package com.Dedany.marioapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.Dedany.marioapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)



        binding?.buttonLogin?.setOnClickListener {
            if (!checkPassword(
                    binding?.editPassword?.text.toString(),
                    binding?.editrepeatPassword?.text.toString()
                )
            ) {
                binding?.editPassword?.error = "Las contraseñas no coinciden"
                binding?.editrepeatPassword?.error = "las contraseñas no coinciden"
            }
        }

        binding?.buttonLogin?.setOnClickListener {


            //NAVEGAR A OTRA ACTIVIDAD
            startActivity(Intent(this, MainFragmentActivity::class.java))
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent) }

        }



    fun checkPassword(password: String, repeatPassword: String): Boolean {
        return password.equals(repeatPassword)
    }
}






