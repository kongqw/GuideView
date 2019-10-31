package com.kongqw.sample.guide.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kongqw.sample.guide.R;

public class HomeActivity extends Activity implements View.OnClickListener {
    private Button mBtnList, mBtnMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mBtnMore = findViewById(R.id.btn_more);
        mBtnList = findViewById(R.id.btn_list);
        mBtnList.setOnClickListener(this);
        mBtnMore.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_more:
                startActivity(new Intent(HomeActivity.this, SimpleGuideViewActivity.class));
                break;
            case R.id.btn_list:
                startActivity(new Intent(HomeActivity.this, MyListActivity.class));
                break;

        }
    }
}
