package de.infoware.mti.mti_tutorial.ui.home;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import de.infoware.mti.mti_tutorial.R;
import de.infoware.mti.mti_tutorial.ui.Adapter.FunctionAdapter;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is functions fragment");
    }



    public LiveData<String> getText() {
        return mText;
    }
}