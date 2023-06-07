package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {Chat.class, Message.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ChatDao getChatDao();

    public abstract MessageDao getMessageDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "chatBotDB").allowMainThreadQueries().addCallback(new Callback() {
                        @Override
                        public void onCreate(@NonNull SupportSQLiteDatabase db) {
                            super.onCreate(db);

                        }
                    })
                    .build();
        }
        return INSTANCE;
    }
}
