package com.esprit.animalproject.Entity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.esprit.animalproject.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {

    private List<Users> listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomListAdapter(Context aContext,  List<Users> listData) {
        this.context = aContext;
        this.listData = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }
    static class ViewHolder {
        ImageView photoView;
        TextView NameView;
        TextView contactView;
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.list_item_layout, null);
            holder = new ViewHolder();
            holder.photoView = (ImageView) convertView.findViewById(R.id.imageView_vet);
            holder.NameView = (TextView) convertView.findViewById(R.id.textView_Name);
            holder.contactView = (TextView) convertView.findViewById(R.id.textView_contact);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        Users user = this.listData.get(position);
        holder.NameView.setText(user.getUserName());
        holder.contactView.setText("Contact: " + user.getEmail());

        int imageId = this.getMipmapResIdByName(user.getPhoto());

        holder.photoView.setImageResource(imageId);

        return convertView;}

    public int getMipmapResIdByName(String resName)  {
        String pkgName = context.getPackageName();
        // Return 0 if not found.
        int resID = context.getResources().getIdentifier(resName , "mipmap", pkgName);
        Log.i("CustomListView", "Res Name: "+ resName+"==> Res ID = "+ resID);
        return resID;
    }




}
