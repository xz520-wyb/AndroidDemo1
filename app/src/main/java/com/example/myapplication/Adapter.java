package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class Adapter extends RecyclerView.Adapter<Adapter.myViewHolder> {
    private final List<String>list;
    private final Context context;
    private View inflater;

    public Adapter(Context context,List<String>list){
        this.context=context;
        this.list=list;
    }
    @Override
    public myViewHolder onCreateViewHolder(ViewGroup viewGroup , int i) {
        inflater = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false);
        myViewHolder myviewholder=new myViewHolder(inflater);
        return myviewholder;
    }

    @Override
    public void onBindViewHolder(myViewHolder myviewholder, int j) {
        myviewholder.textView.setText(list.get(j));
        myviewholder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,Activity1.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public myViewHolder(View itemView){
            super(itemView);
            textView=itemView.findViewById(R.id.itemview);
        }
    }
}
