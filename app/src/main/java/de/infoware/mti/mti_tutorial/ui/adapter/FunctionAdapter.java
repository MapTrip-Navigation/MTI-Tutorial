package de.infoware.mti.mti_tutorial.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.infoware.mti.mti_tutorial.R;
import de.infoware.mti.mti_tutorial.lessions.Lession;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder>{
    private ArrayList <Lession> lessionArrayList;
    private ItemClickListener itemClickListenerVar;

    public interface ItemClickListener {
        void itemClicked(View view, int index);
    }

    public FunctionAdapter (ArrayList<Lession> lessionArrayList, ItemClickListener itemClickListener) {
        this.lessionArrayList = lessionArrayList;
        itemClickListenerVar = itemClickListener;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button buttonFunction;

        public ViewHolder (View itemView) {
            super (itemView);
            buttonFunction = (Button) itemView.findViewById(R.id.buttonFunction);
        }
    }

    @NonNull
    @Override
    public FunctionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View someView = inflater.inflate(R.layout.function, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(someView);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull FunctionAdapter.ViewHolder holder, final int position) {
        holder.buttonFunction.setText(lessionArrayList.get(position).getButtonCaption());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerVar.itemClicked(v, position);

                Lession lession = lessionArrayList.get(position);
                lession.doSomething();
            }
        };
        holder.buttonFunction.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return lessionArrayList.size();
    }
}