package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddChat extends AppCompatActivity {
    public static void start(Context context){
        Intent intent = new Intent(context, AddChat.class);
        intent.putExtra("Chat1", 100);
        intent.putExtra("Chat2", 100);
        context.startActivity(intent);
    }

    private EditText editTextPickName;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String teste1 = bundle.getString("Key1");
        int teste2 = bundle.getInt("Key2");

        this.editTextPickName = findViewById(R.id.editTextPickName);

    }

    public void addChat(View view){
        String name = this.editTextPickName.getText().toString();
        Chat newChat = new Chat(0, name, );
    }
}
