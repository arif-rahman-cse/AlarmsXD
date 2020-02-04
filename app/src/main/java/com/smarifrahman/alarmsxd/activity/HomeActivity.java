package com.smarifrahman.alarmsxd.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.smarifrahman.alarmsxd.R;
import com.smarifrahman.alarmsxd.adapter.AlarmAdapter;
import com.smarifrahman.alarmsxd.databinding.ActivityHomeBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityHomeBinding mHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);

        mHomeBinding.alarmRecyclerView.setHasFixedSize(true);
        mHomeBinding.alarmRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        AlarmAdapter adapter = new AlarmAdapter(this);
        mHomeBinding.alarmRecyclerView.setAdapter(adapter);

        mHomeBinding.addReminderFcb.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.add_reminder_fcb:
                startActivity(new Intent(HomeActivity.this, AddReminderActivity.class));
                finish();
                break;
        }


    }
}
