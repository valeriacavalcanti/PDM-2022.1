package br.eti.valeria.friends

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var rvAmigos: RecyclerView
    private lateinit var fabAdd: FloatingActionButton
    private lateinit var amigos: ArrayList<Amigo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.amigos = arrayListOf()

        this.rvAmigos = findViewById(R.id.rvMainAmigos)
        this.fabAdd = findViewById(R.id.fabMainAdd)

        this.rvAmigos.adapter = AmigoAdapter(this.amigos)
        (this.rvAmigos.adapter as AmigoAdapter).listener = OnItemClickAmigo()

        ItemTouchHelper(OnSwipe()).attachToRecyclerView(this.rvAmigos)

        val frmResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == RESULT_OK){
                val amigo = it.data?.getSerializableExtra("AMIGO_NOVO") as Amigo
                //this.amigos.add(amigo)
                (this.rvAmigos.adapter as AmigoAdapter).add(amigo)
                Log.i("AMIGOS", this.amigos.toString())
            }
        }

        this.fabAdd.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)
            frmResult.launch(intent)
        }
    }

    inner class OnItemClickAmigo: OnItemClickRecyclerView{
        override fun OnClick(position: Int) {
            val amigo = this@MainActivity.amigos[position]
            Toast.makeText(this@MainActivity, amigo.nome, Toast.LENGTH_SHORT).show()
            (this@MainActivity.rvAmigos.adapter as AmigoAdapter).notifyItemChanged(position)
        }
    }

    inner class OnSwipe: ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT
    ){
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder,
        ): Boolean {
            val from = viewHolder.adapterPosition
            val to = target.adapterPosition
            (this@MainActivity.rvAmigos.adapter as AmigoAdapter).mov(from, to)
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            (this@MainActivity.rvAmigos.adapter as AmigoAdapter).del(viewHolder.adapterPosition)
        }

    }
}