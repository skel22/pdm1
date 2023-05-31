package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.util.Calendar;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;

    private String message;

    private String date;

    public Chat(long id, String name, String message, String date){
        this.id = id;
        this.name = name;
        this.message = message;
    }

    public long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getMessage(){ return message; }
}
