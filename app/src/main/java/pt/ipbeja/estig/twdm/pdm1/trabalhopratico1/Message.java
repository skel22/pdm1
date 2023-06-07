package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;


import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "Message", foreignKeys = {
        @ForeignKey(entity = Chat.class,
                parentColumns = "chatId",
                childColumns = "chatId",
                onDelete = ForeignKey.CASCADE)
        })
public class Message {
    @PrimaryKey
    int messageId;
    int chatId;
    private String text;
    private String date;

    public Message(int messageId, int chatId, String text, String date){
        this.messageId = messageId;
        this.chatId = chatId;
        this.text = text;
        this.date = date;
    }

    public int getId(){ return messageId; }

    public int getChatId(){ return chatId; }

    public String getText(){ return text; }

    public String getDate(){ return date; }

}
