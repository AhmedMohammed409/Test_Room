package com.example.ahmedtw_1.ui.list

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.ahmedtw_1.R
import com.example.ahmedtw_1.databinding.ActivityListBinding
import com.example.ahmedtw_1.models.Message
import com.example.ahmedtw_1.db.UserDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding
    private var messagesList: MutableList<Message> = mutableListOf()
    private lateinit var messagesAdapter: MessagesAdapter
    private var userName = "None"
    private val db: UserDataBase by lazy { UserDataBase.getInstance(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra("name").toString()
        Toast.makeText(this, userName, Toast.LENGTH_LONG).show()

        setupRecycler()
        getAllItems()

        binding.btnAdd.setOnClickListener {
            val message = binding.etMessage.text.toString()

            if (message.isNotEmpty()) {
                addMessage(message)
                binding.etMessage.text.clear()
            } else {
                Toast.makeText(this, getString(R.string.found_an_error), Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addMessage(message: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            db.messagesDAO().addMassage(Message(username = userName, message = message))
            getAllItems()
        }

    }

    private fun setupRecycler() {
        messagesAdapter = MessagesAdapter { message ->
            Toast.makeText(this, message.message, Toast.LENGTH_LONG).show()
        }
        binding.rvMessages.adapter = messagesAdapter
    }

    private fun getAllItems() {
        lifecycleScope.launch(Dispatchers.IO) {
            val returnMassages = async { db.messagesDAO().getAllMassages() }
            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.VISIBLE
                messagesList = returnMassages.await() as MutableList<Message>
                binding.progressBar.visibility = View.GONE
                messagesAdapter.submitList(messagesList)
            }
        }
    }
}