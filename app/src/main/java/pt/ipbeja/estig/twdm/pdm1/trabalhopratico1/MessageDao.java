package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.os.Message;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MessageDao {
    @Query("SELECT * FROM MessageActivity")
    List<Message> getAll();

    @Insert
    void insert(Message message);

    @Update
    void update(Message message);

    @Delete
    void delete(Message message);
}
