package com.example.softwarica.ui.add;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.softwarica.R;
import com.example.softwarica.model.User;

import java.util.ArrayList;
import java.util.List;

public class AddFragment extends Fragment {

    private AddViewModel addViewModel;
    Button submit, clear;
    EditText name, age, address;
    RadioGroup rgGender;
    String sname, sage, saddress, sgender;
    int image;

    public static List<User> user_list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        addViewModel =
                ViewModelProviders.of(this).get(AddViewModel.class);
        View root = inflater.inflate(R.layout.fragment_add, container, false);

        submit = root.findViewById(R.id.submit);
        clear = root.findViewById(R.id.clear);
        name = root.findViewById(R.id.name);
        age = root.findViewById(R.id.age);
        address = root.findViewById(R.id.address);
        rgGender = root.findViewById(R.id.rg_gender);

        rgGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.rb_male) {
                    sgender = "Male";
                    image = R.drawable.male;
                }
                if (checkedId == R.id.rb_female) {
                    sgender = "Female";
                    image = R.drawable.female;
                }
                if (checkedId == R.id.rb_other) {
                    sgender = "Other";
                    image = R.drawable.male;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sname = name.getText().toString();
                sage = age.getText().toString();
                saddress = address.getText().toString();

                user_list.add(new User(sname, saddress, sgender, sage, image));
                Toast.makeText(getActivity(), "New User Successfully Added", Toast.LENGTH_SHORT).show();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                age.setText("");
                address.setText("");
                rgGender.clearCheck();
            }
        });
        return root;
    }
}