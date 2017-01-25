package com.terebenin.vkclient.login;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.terebenin.vkclient.R;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.terebenin.vkclient.login.LoginActivity.USER_TOKEN;


/**
 * Created by evgeny on 25.01.17.
 */

public class LoggedInActivity extends Activity{

    @BindView(R.id.uiTextToken) TextView tvToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_logged_in);
        ButterKnife.bind(this);

        Bundle bundle = this.getIntent().getExtras();
        tvToken.setText(bundle.getString(USER_TOKEN));
    }
}
