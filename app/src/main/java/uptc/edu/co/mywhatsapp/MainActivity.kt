package uptc.edu.co.mywhatsapp

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var llChatView: LinearLayout
    private lateinit var llBottomBarChat: LinearLayout
    private lateinit var llTopBarChat: LinearLayout
    private val chatList = arrayListOf<Chat>()
    private val optionsChatList = arrayListOf<OptionChat>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
        configChats()
        configBottomBar()
        configTopBar()
    }

    private fun configTopBar() {
        val topView = layoutInflater.inflate(R.layout.bar_top_chat, null)
        llTopBarChat.addView(topView)
    }

    private fun configBottomBar() {
        val optionsChatView = layoutInflater.inflate(R.layout.bar_bottom_chat, null)
        llBottomBarChat.addView(optionsChatView)
    }

    private fun configChats() {
        fillChatList()
        addChatsToList()
    }

    private fun initViews() {
        llChatView = findViewById(R.id.ll_chats)
        llBottomBarChat = findViewById(R.id.ll_bottom_bar_chats)
        llTopBarChat = findViewById(R.id.ll_top_bar_chats)
    }

    private fun fillChatList() {
        for(i in 0 until 20){
            chatList.add(Chat("User $i"))
        }
    }

    private fun addChatsToList() {
        chatList.forEach { chat ->
            val chatView = layoutInflater.inflate(R.layout.window_chat, null)
            val tvNameContact: TextView = chatView.findViewById(R.id.tvNameContact)
            tvNameContact.text = chat.userName
            llChatView.addView(chatView)
        }
    }
}
