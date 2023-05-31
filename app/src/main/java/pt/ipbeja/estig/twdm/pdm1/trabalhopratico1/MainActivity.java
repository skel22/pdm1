package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Message;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    protected void onStart(){
        super.onStart();
        List<Chat> newChatList = AppDatabase.getInstance(this).getChatDao().getAll();
        List<Message> newMessageList = AppDatabase.getInstance(this).getMessageDao().getAll();
        this.adapter.refreshList(newChatList);
    }

    public void onChatLongClicked(long chatId){
        ChatDao chatDao = AppDatabase.getInstance(MainActivity.this).getChatDao();
        Chat chat = chatDao.getById(chatId);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Delete Chat");
        builder.setMessage("Do you want to delete" + chat.getName() + "?");

        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                chatDao.delete(chat);
                List<Chat> newList = chatDao.getAll();
                adapter.refreshList(newList);
                dialog.dismiss();
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void addChat(View view){
        AddChat.start(this);
    }
}