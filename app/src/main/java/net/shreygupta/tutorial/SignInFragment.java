package net.shreygupta.tutorial;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */

public class SignInFragment extends Fragment {

    private EditText et1;
    private EditText et2;
    private String usr_name;
    private String password;
    private String usr_name_sp;
    private String password_sp;
    private Button signin;
    private Button forgot;
    private Button skip;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_sign_in, container, false);
        et1 = v.findViewById(R.id.usr_name);
        et2 = v.findViewById(R.id.pass);
        signin = v.findViewById(R.id.signin);
        forgot = v.findViewById(R.id.forgot);
        skip = v.findViewById(R.id.skip);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("my_sp", MODE_PRIVATE);

                usr_name = et1.getText().toString();
                password = et2.getText().toString();

                usr_name_sp = sp.getString("usr_name", null);
                password_sp = sp.getString("password", null);

                if (Objects.equals(usr_name, usr_name_sp)) {
                    if (Objects.equals(password, password_sp)) {
                        startActivity(new Intent(getActivity(), TopicChooseActivity.class));
                        getActivity().finish();
                    }

                    else {
                        Toast.makeText(getActivity(), "Invalid Login Credentials", Toast.LENGTH_SHORT).show();
                    }
                }

                else {
                    Toast.makeText(getActivity(), "Invalid Login Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("my_sp", MODE_PRIVATE);

                usr_name_sp = sp.getString("usr_name", null);
                password_sp = sp.getString("password", null);

                usr_name = et1.getText().toString();

                if (usr_name.equals(usr_name_sp)) {
                    Toast.makeText(getActivity(), "Your Password is: " + password_sp, Toast.LENGTH_LONG).show();
                }

                else {
                    Toast.makeText(getActivity(), "Enter Correct Username / User not Registered", Toast.LENGTH_SHORT).show();

                }
            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TopicChooseActivity.class));
                getActivity().finish();
            }
        });

    }
}