package com.example.ahmedtw_1.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ahmedtw_1.R
import com.example.ahmedtw_1.databinding.ActivitySecondBinding
import com.example.ahmedtw_1.model.Massage
import com.example.ahmedtw_1.model.UserDataBase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SecondActivity : AppCompatActivity(), OnListItemClick {
    private lateinit var binding: ActivitySecondBinding
    var name: String = "not get named"
    private var listMassages: MutableList<Massage> = mutableListOf()
    private lateinit var massage: Massage
    private lateinit var addapter: Recycler
    private lateinit var db: UserDataBase
    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        db = UserDataBase.getinstance(this)

        if (intent != null) {
            name = intent.getStringExtra("name").toString()
        }
        Toast.makeText(this, name, Toast.LENGTH_LONG).show()


        addapter = Recycler()
        addapter.onListItemClick = this
        binding.Rv.adapter = addapter
      getAllItems()


        binding.btnAdd.setOnClickListener {
            massage = Massage(1, R.drawable.me, name, binding.edtAdd.text.toString())
//            listMassages.add(massage)
//            addapter.set_items(listMassages)

            GlobalScope.launch(Dispatchers.IO) {
               db.userdao().addMassage(massage)
                 getAllItems()
            }


            binding.edtAdd.text.clear()
      }

    }

    @OptIn(DelicateCoroutinesApi::class)
    private  fun getAllItems() {
        GlobalScope.launch(Dispatchers.IO) {
            val returnMassages = async { db.userdao().getAllMassage() }
            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.VISIBLE
                listMassages = returnMassages.await() as MutableList<Massage>
                binding.progressBar.visibility = View.GONE
                addapter.set_items(listMassages)
            }
        }
    }

    override fun onItemclick(massage: Massage) {
        Toast.makeText(this, massage.massage, Toast.LENGTH_LONG).show()
    }
}