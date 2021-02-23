package de.infoware.mti.mti_tutorial.ui.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.infoware.mti.mti_tutorial.R;
import de.infoware.mti.mti_tutorial.ui.SomeComparableArray;

public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder>{

    private ArrayList <SomeComparableArray> dummyArrayList;

    public FunctionAdapter (ArrayList<SomeComparableArray> dummyArrayList) {
        this.dummyArrayList = dummyArrayList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button buttonFunction;

        public ViewHolder (View itemView) {
            super (itemView);
            buttonFunction = (Button) itemView.findViewById(R.id.button_init_mti);
        }
    }

    public void setDummyArrayList (ArrayList<SomeComparableArray> dummyArrayList) {
        this.dummyArrayList = dummyArrayList;
    }

    @NonNull
    @Override
    public FunctionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View refRouteView = inflater.inflate(R.layout.function, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(refRouteView);
        return viewHolder;    }

    @Override
    public void onBindViewHolder(@NonNull FunctionAdapter.ViewHolder holder, int position) {
        holder.buttonFunction.setText(dummyArrayList.get(0).getButtonTitle());
    }

    @Override
    public int getItemCount() {
        return dummyArrayList.size();
    }
}
