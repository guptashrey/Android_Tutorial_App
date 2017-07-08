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

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignUpFragment extends Fragment {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private EditText et4;
    private Button signup;
    private String name;
    private String usr_name;
    private String password;
    private String con_password;

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sign_up, container, false);

        et1 = v.findViewById(R.id.reg_name);
        et2 = v.findViewById(R.id.reg_usr_name);
        et3 = v.findViewById(R.id.reg_pass);
        et4 = v.findViewById(R.id.reg_con_pass);
        signup = v.findViewById(R.id.signup);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp = getActivity().getSharedPreferences("my_sp", MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();

                name = et1.getText().toString();
                usr_name = et2.getText().toString();
                password = et3.getText().toString();
                con_password = et4.getText().toString();

                e.putString("name", name);
                e.putString("usr_name", usr_name);

                if (name.isEmpty()) {
                    Toast.makeText(getActivity(), "Enter details!", Toast.LENGTH_SHORT).show();

                }

                else {

                    if (password.equals(con_password)) {
                        e.putString("password", password);
                        e.apply();
                        startActivity(new Intent(getActivity(), TopicChooseActivity.class));
                        getActivity().finish();
                    }

                    else {
                        Toast.makeText(getActivity(), "Password mismatch!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}