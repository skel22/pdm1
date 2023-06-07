package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import java.util.Calendar;

@Entity
public class Chat {
    @PrimaryKey(autoGenerate = true)
    int chatId;
    private String name;
    private String lastMessageSent;
    private String date;
    //private boolean sender;

    public Chat(int chatId, String name, String lastMessageSent, String date /*boolean sender*/){
        this.chatId = chatId;
        this.name = name;
        this.lastMessageSent = lastMessageSent;
        this.date = date;
        //this.sender = sender;
    }

    public int getId(){
        return chatId;
    }

    public String getName(){
        return name;
    }

    public String getLastMessageSent(){ return lastMessageSent; }

    public String getDate(){ return date; }

    //public boolean getSender(){ return sender; }
}
