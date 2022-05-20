package com.example.janela

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var btForm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_JANELA", "Main - OnCreate")

        this.btForm = findViewById(R.id.btMainFormulario)

        val formularioResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val nome = it.data?.getStringExtra("NOME_ALTERADO")
                val idade = it.data?.getStringExtra("IDADE_ALTERADA")
                Toast.makeText(this, "${nome} - ${idade}", Toast.LENGTH_SHORT).show()
            }else{
               Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
            }
        }

        this.btForm.setOnClickListener{
            val intent = Intent(this, FormularioActivity::class.java).apply {
                putExtra("NOME", "Valéria Cavalcanti")
                putExtra("IDADE", "15")
            }

            // chamada para outra activity - nao espera retorno
//            if (intent.resolveActivity(packageManager) != null){
//                startActivity(intent)
//            }

            // chamada para outra activity - esperando resultado
            if (intent.resolveActivity(packageManager) != null) {
                formularioResult.launch(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_JANELA", "Main - OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_JANELA", "Main - OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_JANELA", "Main - OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_JANELA", "Main - OnStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_JANELA", "Main - OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_JANELA", "Main - OnDestroy")
    }
}