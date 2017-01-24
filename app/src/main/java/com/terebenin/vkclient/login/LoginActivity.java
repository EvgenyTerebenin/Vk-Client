package com.terebenin.vkclient.login;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.terebenin.vkclient.R;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKScope;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;
import com.vk.sdk.util.VKUtil;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Activity which displays a login screen to the user, offering registration as
 * well.
 */
public class LoginActivity extends Activity {

    private boolean isResumed = false;

    /**
     * Scope is set of required permissions for your application
     *
     * @see <a href="https://vk.com/dev/permissions">vk.com api permissions documentation</a>
     */
    private static final String[] sMyScope = new String[]{
            VKScope.FRIENDS,
            VKScope.WALL,
            VKScope.PHOTOS,
            VKScope.NOHTTPS,
            VKScope.MESSAGES,
            VKScope.DOCS
    };

    @BindView(R.id.uiBtnSignIn) Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        ButterKnife.bind(this);

        VKSdk.wakeUpSession(this, new VKCallback<VKSdk.LoginState>() {
            @Override
            public void onResult(VKSdk.LoginState res) {
//                if (isResumed) {
                    switch (res) {
                        case LoggedOut:
                            Toast.makeText(LoginActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
//                            showLogin();
                            break;
                        case LoggedIn:
                            Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
//                            showLogout();
                            break;
                        case Pending:
                            break;
                        case Unknown:
                            break;
                    }
//                }
            }

            @Override
            public void onError(VKError error) {

            }
        });

        btnSignIn.setOnClickListener((View view) -> {
            VKSdk.login(this, sMyScope);
        });

        String[] fingerprint = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.d("Fingerprint", fingerprint[0]);
    }
}
