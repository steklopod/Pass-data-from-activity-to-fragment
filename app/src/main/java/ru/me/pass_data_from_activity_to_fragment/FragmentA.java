package ru.me.pass_data_from_activity_to_fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class FragmentA extends Fragment {

    private static final String TAG = FragmentA.class.getSimpleName();
    private Button btnAdd;
    private TextView txvResult;
    private int number1 = 0, number2 =0, result = 0;
    private MainActivity.Employee mEmployee;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        btnAdd = (Button) view.findViewById(R.id.btnAdd);
        txvResult = (TextView) view.findViewById(R.id.txvResult);

//        Bundle arguments = getArguments();
//        final int result = arguments.getInt("result", 0);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txvResult.setText("Сумма: " + (number1 + number2));
            }
        });
        return view;
    }

    public void setData(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }


    public void setEmployee(MainActivity.Employee employee) {
        this.mEmployee = employee;
        
    }
}
