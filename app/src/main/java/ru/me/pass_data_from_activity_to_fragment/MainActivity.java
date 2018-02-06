package ru.me.pass_data_from_activity_to_fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager manager;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getFragmentManager();
        etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
    }


    public void sendDataToFragment(View view) {
        int number1 = Integer.parseInt(etFirstNumber.getText().toString());
        int number2 = Integer.parseInt(etSecondNumber.getText().toString());

/*      Bundle bundle = new Bundle();
        bundle.putInt("result", number1 + number2);
        bundle.putInt("firstNumber", number1);
        bundle.putInt("secondNumber", number2);
*/
        FragmentA fragmentA = new FragmentA();
        fragmentA.setData(number1, number2);
        fragmentA.setEmployee(new Employee());
//        fragmentA.setArguments(bundle);

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();

    }


    public class Employee{
        String name;
        int age;
    }
}
