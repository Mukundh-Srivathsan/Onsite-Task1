package com.delta.onsites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.delta.onsites.Calculator.InputFragment;
import com.delta.onsites.Calculator.OutputFragment;

public class MainActivity extends AppCompatActivity implements InputFragment.Listner {

    private static final String TAG = "MainActivity";

    OutputFragment outputFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started");

        FragmentManager manager = getSupportFragmentManager();

        InputFragment inputFragment = new InputFragment();

        manager.beginTransaction()
                .replace(R.id.input, inputFragment, inputFragment.getTag())
                .commit();

        outputFragment= new OutputFragment();
        manager.beginTransaction()
                .replace(R.id.output, outputFragment, outputFragment.getTag())
                .commit();
    }

    @Override
    public void sendAns(double ans) {
        outputFragment.updateAns(ans);
    }
}