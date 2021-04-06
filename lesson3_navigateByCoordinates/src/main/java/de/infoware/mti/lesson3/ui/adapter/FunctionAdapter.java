package de.infoware.mti.lesson3.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.infoware.mti.lesson2.ui.R;
import de.infoware.mti.lesson3.lesson.Lesson;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FunctionAdapter extends RecyclerView.Adapter<FunctionAdapter.ViewHolder> {
    private ArrayList<Lesson> lessonArrayList;
    private ItemClickListener itemClickListenerVar;

    public interface ItemClickListener {
        void itemClicked(View view, int index);
    }

    public FunctionAdapter(ArrayList<Lesson> lessonArrayList, ItemClickListener itemClickListener) {
        this.lessonArrayList = lessonArrayList;
        itemClickListenerVar = itemClickListener;

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public Button buttonFunction;

        public ViewHolder(View itemView) {
            super(itemView);
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
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FunctionAdapter.ViewHolder holder, final int position) {
        holder.buttonFunction.setText(lessonArrayList.get(position).getButtonCaption());

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListenerVar.itemClicked(v, position);

                Lesson lesson = lessonArrayList.get(position);
                lesson.doSomething();
            }
        };
        holder.buttonFunction.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return lessonArrayList.size();
    }

}