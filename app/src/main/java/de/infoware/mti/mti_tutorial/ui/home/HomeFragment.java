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
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.infoware.mti.mti_tutorial.R;
import de.infoware.mti.mti_tutorial.ui.Adapter.FunctionAdapter;
import de.infoware.mti.mti_tutorial.Lessions.Lession;
import de.infoware.mti.mti_tutorial.ui.notifications.LessionInitMti;

public class HomeFragment extends Fragment implements FunctionAdapter.ItemClickListener {

    private HomeViewModel homeViewModel;
//    private ArrayList<Lession> dummyArrayList;
//    public Button button;


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

    /*
     * Within this method we will extend the button list for available functions lession by lession
    */
    private ArrayList getLessions () {
        ArrayList<Lession> lessionArrayList = new ArrayList<>();

        // first lession: Initialization of MTI
        Lession lession = new LessionInitMti(0,"Initialize MTI");
        lessionArrayList.add(lession);

        /*
        lession = new LessionInitMti(1,"blubb");
        lessionArrayList.add(lession);
         */

        return lessionArrayList;
    }

    @Override
    public void itemClicked(View view, int index) {
        System.out.println("alköjfd");
    }
}