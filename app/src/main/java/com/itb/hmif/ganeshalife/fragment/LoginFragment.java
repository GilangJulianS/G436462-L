package com.itb.hmif.ganeshalife.fragment;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.itb.hmif.ganeshalife.R;
import com.itb.hmif.ganeshalife.activity.HomeActivity;
import com.itb.hmif.ganeshalife.controller.MainController;
import com.itb.hmif.ganeshalife.controller.OnVolleyCallback;
import com.itb.hmif.ganeshalife.model.User;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Yanfa on 5/12/2016.
 */
public class LoginFragment extends Fragment {

    private Button loginButton;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private TextView forgotPasswordTV;

    private String username;
    private String password;

    private MainController mainController;
    private SharedPreferences sharedPreferences;
    private LoadingDialog loadingDialog;

    private User currUser;
    private boolean isError;

    public LoginFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);

        mainController = new MainController();
        loadingDialog = new LoadingDialog();
        isError = true;

        sharedPreferences = getActivity().getSharedPreferences(getString(R.string.preferences_name), getActivity().MODE_PRIVATE);

        usernameEditText = (EditText)rootView.findViewById(R.id.usernameEditText);
        passwordEditText = (EditText)rootView.findViewById(R.id.passwordEditText);

        passwordEditText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    if(usernameEditText.getText().toString().length() > 0 &&
                            passwordEditText.getText().toString().length() > 0) {
                        loadingDialog.show(getFragmentManager(), "Loading");
                        username = usernameEditText.getText().toString();
                        password = passwordEditText.getText().toString();
                        mainController.login(getActivity(), username, password, new OnVolleyCallback() {
                            @Override
                            public void onSuccess(String result) {
                                currUser = getUserFromLoginJSON(result);
                                MainController.CURRENT_USER = currUser;
                                loadingDialog.dismiss();

                                if(isError){
                                    Toast.makeText(getContext(), "Username atau password anda salah", Toast.LENGTH_SHORT).show();
                                }else{
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putString("token", MainController.AUTH_TOKEN);
//                                editor.putString("username", MainController.USERNAME);
//                                editor.commit();
                                    Intent i = new Intent(getActivity(), HomeActivity.class);
                                    startActivity(i);
//                                keepLogin(context);
                                }
                            }

                            @Override
                            public void onError(String errorResult) {
                                loadingDialog.dismiss();
                                Toast.makeText(getContext(), "Login gagal, silahkan coba lagi", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else{
                        Toast.makeText(getActivity(), "Silahkan isi username dan password terlebih dahulu", Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                return false;
            }
        });

        loginButton = (Button)rootView.findViewById(R.id.loginButton);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usernameEditText.getText().toString().length() > 0 &&
                        passwordEditText.getText().toString().length() > 0) {
                    loadingDialog.show(getFragmentManager(), "Loading");
                    username = usernameEditText.getText().toString();
                    password = passwordEditText.getText().toString();
                    mainController.login(getActivity(), username, password, new OnVolleyCallback() {
                        @Override
                        public void onSuccess(String result) {
                            currUser = getUserFromLoginJSON(result);
                            MainController.CURRENT_USER = currUser;
                            loadingDialog.dismiss();

                            if(isError){
                                Toast.makeText(getContext(), "Username atau password anda salah", Toast.LENGTH_SHORT).show();
                            }else{
//                                SharedPreferences.Editor editor = sharedPreferences.edit();
//                                editor.putString("token", MainController.AUTH_TOKEN);
//                                editor.putString("username", MainController.USERNAME);
//                                editor.commit();
                                Intent i = new Intent(getActivity(), HomeActivity.class);
                                startActivity(i);
//                                keepLogin(context);
                            }
                        }

                        @Override
                        public void onError(String errorResult) {
                            loadingDialog.dismiss();
                            Toast.makeText(getContext(), "Login gagal, silahkan coba lagi", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else{
                    Toast.makeText(getActivity(), "Silahkan isi username dan password terlebih dahulu", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgotPasswordTV = (TextView)rootView.findViewById(R.id.forgotPasswordLoginTextView);
        forgotPasswordTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(browserIntent);
            }
        });

        return rootView;
    }

    private User getUserFromLoginJSON(String loginString){
        String userId = "";
        String username = "";
        String realName = "Tegar Aji Pangestu";
        String email = "";
        int value = 0;
        User loginUser = null;
        try {
            JSONObject jsonLogin = new JSONObject(loginString);

            MainController.AUTH_TOKEN = jsonLogin.getString("token");
            isError = jsonLogin.getString("error").equals("true");

            userId = jsonLogin.getString("user_id");
            username = jsonLogin.getString("username");
            email = jsonLogin.getString("email");
            if(!jsonLogin.getString("value").equals("null")) {
                value = jsonLogin.getInt("value");
            }

            loginUser = new User(userId, username, realName, email, value);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  loginUser;
    }
}
