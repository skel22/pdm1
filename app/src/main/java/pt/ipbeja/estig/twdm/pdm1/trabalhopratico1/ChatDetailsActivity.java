package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ChatDetailsActivity extends AppCompatActivity {

    private static final String KEY_CHAT_ID = "chatId";

    public static void startActivity(Context context,long chatId){
        Intent intent = new Intent(context, ChatDetailsActivity.class);
        intent.putExtra(ChatDetailsActivity.KEY_CHAT_ID, chatId);
        context.startActivity(intent);
    }

    private Chat chat;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }
}
