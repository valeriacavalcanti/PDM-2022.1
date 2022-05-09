package com.example.ifpb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var telaReceiver: TelaReceiver? = null
    private var tela2Receiver: Tela2Receiver? = null
    private var caboReceiver: CaboReceiver? = null
    private lateinit var itf: IntentFilter
    private lateinit var itf2: IntentFilter
    private lateinit var ifCabo: IntentFilter
    private lateinit var tvReceiver: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_IFPB", "OnCreate")
        this.tvReceiver = findViewById(R.id.tvReceiver)
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_IFPB", "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("APP_IFPB", "OnResume")
        if (this.telaReceiver == null){
            this.telaReceiver = TelaReceiver()
            this.itf = IntentFilter().apply {
                addAction(Intent.ACTION_USER_PRESENT)
            }
        }
        registerReceiver(this.telaReceiver, itf)

        if (this.tela2Receiver == null){
            this.tela2Receiver = Tela2Receiver()
            this.itf2 = IntentFilter().apply {
                addAction(Intent.ACTION_USER_PRESENT)
            }
        }
        registerReceiver(this.tela2Receiver, itf2)

        if (this.caboReceiver == null){
            this.caboReceiver = CaboReceiver()
            this.ifCabo = IntentFilter().apply {
                addAction(Intent.ACTION_POWER_CONNECTED)
                addAction(Intent.ACTION_POWER_DISCONNECTED)
            }
        }
        registerReceiver(this.caboReceiver, this.ifCabo)
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_IFPB", "OnPause")
        this.tvReceiver.text = "eita"
    }

    override fun onStop() {
        super.onStop()
        Log.i("APP_IFPB", "OnStop")
        unregisterReceiver(this.telaReceiver)
        unregisterReceiver(this.tela2Receiver)
        unregisterReceiver(this.caboReceiver)
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_IFPB", "OnRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_IFPB", "OnDestroy")
    }

    inner class Tela2Receiver: BroadcastReceiver(){
        override fun onReceive(p0: Context?, p1: Intent?) {
            this@MainActivity.tvReceiver.text = "Tela desbloqueada, mesmo!"
        }
    }

    inner class CaboReceiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action.equals(Intent.ACTION_POWER_CONNECTED)){
                this@MainActivity.tvReceiver.text = "Conectou!"
            }else{
                this@MainActivity.tvReceiver.text = "Desconectou!"
            }
        }
    }
}