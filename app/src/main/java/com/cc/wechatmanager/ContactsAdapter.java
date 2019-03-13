package com.cc.wechatmanager;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.cc.core.wechat.model.user.Friend;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
    List<Friend> contacts;
    List<Friend> selectContacts = new LinkedList<>();
    public ContactsAdapter() {
        this.contacts = new ArrayList<>();
    }

    public Friend getItem(int position) {
        if (contacts == null || position >= contacts.size()) {
            return null;
        } else {
            return contacts.get(position);
        }
    }

    public void refeshData(List<Friend> data) {
        contacts.clear();
        if (data != null) {
            contacts.addAll(data);
        }
        notifyDataSetChanged();
    }

    void onSelectContact(Friend friend, boolean isSelected) {
        if (friend == null) {
            return;
        }

        if (isSelected && !selectContacts.contains(friend)) {
            selectContacts.add(friend);
        } else if (!isSelected) {
            selectContacts.remove(friend);
        }
    }

    public List<Friend> getSelectContacts() {
        return selectContacts;
    }

    public void clearSelectContacts() {
        selectContacts.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        return new ContactsAdapter.ViewHolder(LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_contact, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsAdapter.ViewHolder viewHolder, int position) {
        viewHolder.bindView(getItem(position));
    }

    @Override public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return contacts == null ? 0 : contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatar;
        TextView nameView;
        TextView wechatView;
        CheckBox checkBox;
        CheckListener checkListener;
        public ViewHolder(View itemView) {
            super(itemView);
            avatar = itemView.findViewById(R.id.avatar);
            nameView = itemView.findViewById(R.id.name);
            wechatView = itemView.findViewById(R.id.wechatId);
            checkBox = itemView.findViewById(R.id.checkbox);
            checkListener = new CheckListener();
            checkBox.setOnCheckedChangeListener(checkListener);
        }

        void bindView(Friend friend) {
            checkListener.friend = friend;
            Glide.with(avatar.getContext()).load(friend.getAvatar()).into(avatar);
            nameView.setText(friend.getNickname());
            wechatView.setText(friend.getWechatId());
            checkBox.setChecked(selectContacts.contains(friend));
        }
    }

    private class CheckListener implements CompoundButton.OnCheckedChangeListener {
        private Friend friend;
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            onSelectContact(friend, isChecked);
        }
    }
}
