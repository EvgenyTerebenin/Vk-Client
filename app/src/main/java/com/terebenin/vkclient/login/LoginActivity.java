package com.terebenin.vkclient.login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.terebenin.vkclient.R;
import com.terebenin.vkclient.newsfeed.NewsActivity;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

    @BindView(R.id.uiBtnSignIn) Button btnSignIn;

    private static final String[] sMyScope = new String[]{
            VKScope.FRIENDS,
            VKScope.WALL,
            VKScope.OFFLINE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        boolean restoredText = prefs.getBoolean("loginStatus", false);
        if (restoredText == true) {
            Toast.makeText(LoginActivity.this, R.string.logged_in, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
            startActivity(intent);
            finish();
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        ButterKnife.bind(this);

        btnSignIn.setOnClickListener((View view) ->
                VKSdk.login(this, sMyScope));

        VKSdk.wakeUpSession(this, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
                switch (res) {
                    case LoggedOut:
                        Toast.makeText(LoginActivity.this, R.string.logged_out, Toast.LENGTH_SHORT).show();
                        break;
                    case LoggedIn:
                        Toast.makeText(LoginActivity.this, R.string.logged_in, Toast.LENGTH_SHORT).show();
                        break;
                    case Pending:
                        break;
                    case Unknown:
                        break;
                }
            }

            @Override
            public void onError(VKError error) {
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Toast.makeText(LoginActivity.this, R.string.logged_in, Toast.LENGTH_SHORT).show();
                SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
                editor.putBoolean("loginStatus", true);
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, NewsActivity.class);
                startActivity(intent);
            }

            @Override
            public void onError(VKError error) {
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}


