package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.Date;
import java.util.List;

@Dao
public interface ChatDao {
    @Query("SELECT * FROM chat")
    List<Chat> getAll();

    @Query("SELECT * FROM chat WHERE chatId = :chatId")
    Chat getById(long chatId);

    @Query("UPDATE chat SET date = :date WHERE chatId = :chatId")
    void updateDate(String date, int chatId);

    @Insert
    void insert(Chat chat);

    @Insert
    void insert(List<Chat> chatList);

    @Update
    void update(Chat chat);

    @Delete
    void delete(Chat chat);
}
