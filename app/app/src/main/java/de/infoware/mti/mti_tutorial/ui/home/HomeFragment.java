package de.infoware.mti.mti_tutorial.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.infoware.mti.mti_tutorial.R;
import de.infoware.mti.mti_tutorial.ui.Adapter.FunctionAdapter;
import de.infoware.mti.mti_tutorial.ui.SomeComparableArray;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ArrayList<SomeComparableArray> dummyArrayList;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        // Give the function buttons a home
        final RecyclerView rvFunctions = (RecyclerView) root.findViewById(R.id.RecyclerView_Functions);
/*
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFunctions.setLayoutManager(new LinearLayoutManager(getActivity()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rvFunctions.getContext(),
                layoutManager.getOrientation());
        rvFunctions.addItemDecoration(dividerItemDecoration);
*/

        dummyArrayList = new ArrayList<>();
        SomeComparableArray dummy = new SomeComparableArray();
        dummyArrayList.add(dummy);
        // Create adapter passing in the sample user data
        final FunctionAdapter adapter = new FunctionAdapter(dummyArrayList);
 //       adapter.setDummyArrayList(dummyArrayList);

        // Attach the adapter to the recyclerview to populate items
        rvFunctions.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return root;
    }
}