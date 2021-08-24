package com.delta.onsites;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {

    private MutableLiveData<Double> answer = new MutableLiveData<>();

    public void setAnswer(double ans)
    {
        answer.setValue(ans);
    }

    public LiveData<Double> getAnswer()
    {
        return answer;
    }


}
