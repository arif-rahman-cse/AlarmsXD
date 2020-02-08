package com.smarifrahman.alarmsxd.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;
import com.smarifrahman.alarmsxd.R;
import com.smarifrahman.alarmsxd.adapter.AlarmAdapter;
import com.smarifrahman.alarmsxd.databinding.ActivityHomeBinding;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

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
        mHomeBinding.drawerMenu.setOnClickListener(this);
        mHomeBinding.navViewId.setNavigationItemSelectedListener(this);


    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.add_reminder_fcb:
                startActivity(new Intent(HomeActivity.this, AddReminderActivity.class));
                finish();
                break;

            case R.id.drawer_menu:
                mHomeBinding.drawerLayout.openDrawer(GravityCompat.START);
                break;

        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        switch (id) {
            case R.id.setting_id:
                startActivity(new Intent(HomeActivity.this, SettingActivity.class));
                finish();
                return true;

            case R.id.login_id:
                return true;

            case R.id.about_id:
                startActivity(new Intent(HomeActivity.this, AboutReminderXD.class));
                finish();
                return true;
        }
        return false;
    }
}
