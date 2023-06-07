package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class AddChatActivity extends AppCompatActivity {

    Button addChatButton;

    public static void start(Context context){
        Intent intent = new Intent(context, AddChatActivity.class);
        intent.putExtra("Chat1", 100);
        intent.putExtra("Chat2", 100);
        context.startActivity(intent);
    }

    private EditText editTextPickName;
    //private ImageView editImageViewPick;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chat);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String teste1 = bundle.getString("Key1");
        int teste2 = bundle.getInt("Key2");

        Calendar calendar = Calendar.getInstance();

        this.editTextPickName = findViewById(R.id.editTextPickName);
        //this.editImageViewPick = findViewById(R.id.editImageViewPick);
    }

    public void addChat(View view){
        String name = this.editTextPickName.getText().toString();
        Chat chat = new Chat(0, name, "", "");
    }
}
