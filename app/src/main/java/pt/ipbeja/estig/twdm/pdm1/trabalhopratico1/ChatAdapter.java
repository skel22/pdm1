package pt.ipbeja.estig.twdm.pdm1.trabalhopratico1;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<Chat> chatList;
    //private ChatAdapterEventListener chatEventListener;

    public ChatAdapter(){
        this.chatList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_item, parent,false);
        return new ChatViewHolder(rootView);
    }

    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position){
        final Chat chat = this.chatList.get(position);

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
        private TextView textViewTab;
        private TextView textViewLastMsg;
        private ImageView imageViewChatIcon;

        public ChatViewHolder(@NonNull View rootView){
            super(rootView);
            this.rootView = rootView;
            this.textViewTab = rootView.findViewById(R.id.textViewTabTitle);
            this.textViewLastMsg = rootView.findViewById(R.id.textViewLastMsg);
            this.imageViewChatIcon = rootView.findViewById(R.id.imageViewChatIcon);
        }
    }
}
