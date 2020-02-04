package com.smarifrahman.alarmsxd.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.smarifrahman.alarmsxd.R;
import com.smarifrahman.alarmsxd.databinding.ActivityAddReminderBinding;
import com.smarifrahman.alarmsxd.fragment.ArrivalFragment;
import com.smarifrahman.alarmsxd.fragment.DepartureFragment;

public class AddReminderActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityAddReminderBinding mAddReminderBinding;
    ArrivalFragment mArrivalFragment;
    DepartureFragment mDepartureFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        mAddReminderBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_reminder);


        mArrivalFragment = new ArrivalFragment();
        mDepartureFragment = new DepartureFragment();
        replaceFragment(mArrivalFragment);
        arrivalButtonBg();

        mAddReminderBinding.addArrival.setOnClickListener(this);
        mAddReminderBinding.addDeparture.setOnClickListener(this);


    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_arrival_departure, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.add_arrival: {

                arrivalButtonBg();
                replaceFragment(mArrivalFragment);
                break;
            }
            case R.id.add_departure: {
                departureButtonBg();
                replaceFragment(mDepartureFragment);
                break;
            }
        }
    }

    private void departureButtonBg() {
        mAddReminderBinding.addDeparture.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_rectangle_fill));
        mAddReminderBinding.addArrival.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        mAddReminderBinding.addDeparture.setTextColor(getResources().getColor(R.color.white));
        mAddReminderBinding.addArrival.setTextColor(getResources().getColor(R.color.gray));
    }

    private void arrivalButtonBg() {
        mAddReminderBinding.addArrival.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_rectangle_fill));
        mAddReminderBinding.addDeparture.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        mAddReminderBinding.addArrival.setTextColor(getResources().getColor(R.color.white));
        mAddReminderBinding.addDeparture.setTextColor(getResources().getColor(R.color.gray));
    }
}
