package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Calendar;

@Entity
public class MessageActivity {
    @PrimaryKey
    private long id;
    private String text;

    private String date;

    public long getId(){ return id; }

    public void setText(){ this.text = text; }

    public void setDate(){
        Calendar time = Calendar.getInstance();

        this.date = time.toString();
    }

    public String getDate(){
        return date;
    }
}
