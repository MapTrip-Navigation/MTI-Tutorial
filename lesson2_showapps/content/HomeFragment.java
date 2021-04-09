package de.infoware.mti.lesson2.ui.home;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.infoware.mti.lesson2.lesson.Lesson1_Initialize;
import de.infoware.mti.lesson2.lesson.Lesson2_ShowApps;
import de.infoware.mti.lesson2.ui.adapter.FunctionAdapter;
import de.infoware.mti.lesson2.ui.R;
import de.infoware.mti.lesson2.lesson.Lesson;

@RequiresApi(api = Build.VERSION_CODES.N)
public class HomeFragment extends Fragment implements FunctionAdapter.ItemClickListener {
    private HomeViewModel homeViewModel;
    ArrayList<Lesson> lessonArrayList = new ArrayList<>();

    TextView textView = null;

    /*
     * Within this method we will extend the button list for available functions lession by lession
     */
    private ArrayList getLessions () {
        int lessonIndex = 0;
        // Placeholder for later implemented lessons
        lessonArrayList.add(new Lesson1_Initialize(lessonIndex++,"Start MapTrip And Init MTI", this));
        lessonArrayList.add(new Lesson2_ShowApps(lessonIndex++, "Show MapTrip 10 seconds", this));
        return lessonArrayList;
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Give the function buttons a home
        final RecyclerView rvFunctions = (RecyclerView) root.findViewById(R.id.RecyclerView_Functions);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFunctions.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvFunctions.getContext(),
                layoutManager.getOrientation());
        rvFunctions.addItemDecoration(dividerItemDecoration);

        // Create adapter passing in the sample user data
        final FunctionAdapter adapter = new FunctionAdapter(getLessions(), this);

        // Attach the adapter to the recyclerview to populate items
        rvFunctions.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }

    @Override
    public void itemClicked(View view, int index) {
    }
}
