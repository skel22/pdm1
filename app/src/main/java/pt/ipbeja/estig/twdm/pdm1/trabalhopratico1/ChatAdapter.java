package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<Chat> chatList;
    private ChatAdapterEventListener chatEventListener;

    public ChatAdapter(ChatAdapterEventListener chatEventListener){
        this.chatList = new ArrayList<>();
        this.chatEventListener = chatEventListener;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_room_items, parent,false);
        return new ChatViewHolder(rootView);
    }

    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position){
        final Chat chat = this.chatList.get(position);
        holder.textViewUserReply.setText(chat.getMessage());
        Glide.with(holder.rootView.getContext()).load(chat.getText()).into(holder.textViewUserReply);

        holder.rootView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ChatDetailsActivity.startActivity(holder.rootView.getContext(), chat.getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.chatList.size();
    }

    public void refreshList(List<Chat> newChatList){
        this.chatList = newChatList;
        notifyDataSetChanged();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder{
        private View rootView;

        private View textViewUserReply;

        public ChatViewHolder(@NonNull View view){
            super(rootView);
            this.rootView = rootView;
            this.textViewUserReply = rootView.findViewById(R.id.textViewUserReply);
            this.
        }
    }

    public interface ChatAdapterEventListener{
        void onChatEventListener(long chatId);
        void onChatLongClicked(long chatId);
    }
}
