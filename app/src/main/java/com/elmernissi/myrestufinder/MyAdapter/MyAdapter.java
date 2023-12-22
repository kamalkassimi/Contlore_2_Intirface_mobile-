package com.elmernissi.myrestufinder.MyAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elmernissi.myrestufinder.R;
import com.elmernissi.myrestufinder.model.Magasin;

import java.util.ArrayList;

public class MyAdapter  extends  RecyclerView.Adapter<MyAdapter.holdarView>{
    private ArrayList<Magasin> data ;
    public MyAdapter(ArrayList<Magasin> data) {
        this.data = data;
    }


    public  void  setchange(ArrayList<Magasin> newdata){
        data.clear();
        data.addAll(newdata);
    }

    public static class   holdarView extends RecyclerView.ViewHolder {
        TextView textView1 , textView2 ,textView3;
        public holdarView(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.nomTextView);
            textView2 = itemView.findViewById(R.id.adresseTextView);
            textView3 = itemView.findViewById(R.id.telephoneTextView);
        }
    }

    @NonNull
    public holdarView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new holdarView(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_magasin_item,null,false));
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.holdarView holder, int position) {
          Magasin list_index= data.get(position);
          holder.textView1.setText(list_index.getName());
          holder.textView2.setText(list_index.getAddrese());
          holder.textView3.setText(list_index.getTelephone());
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
}
