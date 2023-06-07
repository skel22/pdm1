package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity  {
    private ChatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerViewMain);

        AppDatabase db = AppDatabase.getInstance(this);
        ChatDao chatDao = db.getChatDao();

        this.adapter = new ChatAdapter();
        recyclerView.setAdapter(this.adapter);
    }

    protected void onStart(){
        super.onStart();
        List<Chat> newChatList = AppDatabase.getInstance(this).getChatDao().getAll();
        List<Message> newMessageList = AppDatabase.getInstance(this).getMessageDao().getAll();
        this.adapter.refreshList(newChatList);
    }

    public void addChat(View view){
        AddChatActivity.start(this);
    }
}