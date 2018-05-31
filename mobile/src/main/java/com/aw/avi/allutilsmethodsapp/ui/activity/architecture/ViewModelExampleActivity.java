package com.aw.avi.allutilsmethodsapp.ui.activity.architecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aw.avi.allutilsmethodsapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewModelExampleActivity extends AppCompatActivity {

    @BindView(R.id.increment_button)
    Button incrementButton;
    @BindView(R.id.click_count_text)
    TextView clickCountText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_model_example);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.increment_button)
    public void incrementClickCount(View button) {
        int currentClickCount = Integer.parseInt(clickCountText.getText().toString());
        clickCountText.setText(String.valueOf(++currentClickCount));
    }
}
