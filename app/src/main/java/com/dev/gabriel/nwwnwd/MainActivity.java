package com.dev.gabriel.nwwnwd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nwd_Button = (Button) findViewById(R.id.nwd_Button);
        Button nww_Button = (Button) findViewById(R.id.nww_Button);

        final EditText firstNmb_Textbox = (EditText) findViewById(R.id.firstNumber_Textbox);
        final EditText secondNmb_Textbox = (EditText) findViewById(R.id.secondNumber_Textbox);
        final EditText thirdNmb_Textbox = (EditText) findViewById(R.id.thirdNumber_Textbox);
        final TextView output = (TextView) findViewById(R.id.lbl_output);

        nwd_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                int result = 0;
                if (!TextUtils.isEmpty(thirdNmb_Textbox.getText().toString()))
                {
                    result = GetLCD(GetLCD(Integer.parseInt(firstNmb_Textbox.getText().toString()), Integer.parseInt(secondNmb_Textbox.getText().toString())), Integer.parseInt(thirdNmb_Textbox.getText().toString()));
                    output.setText("NWD = " + result);
                    return;
                }

                result = GetLCD(Integer.parseInt(firstNmb_Textbox.getText().toString()), Integer.parseInt(secondNmb_Textbox.getText().toString()));

                output.setText("NWD = " + result);
            }
        });

        nww_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (!TextUtils.isEmpty(thirdNmb_Textbox.getText().toString()))
                {
                    int result = GetLCM(GetLCM(Integer.parseInt(firstNmb_Textbox.getText().toString()), Integer.parseInt(secondNmb_Textbox.getText().toString())), Integer.parseInt(thirdNmb_Textbox.getText().toString()));
                    output.setText("NWW = " + result);
                    return;
                }

                int result = GetLCM(Integer.parseInt(firstNmb_Textbox.getText().toString()), Integer.parseInt(secondNmb_Textbox.getText().toString()));
                output.setText("NWW = " + result);

            }
        });
    }

    private int GetLCD(int a, int b)
    {
       if (b == 0) return a;
       else return GetLCD(b, a % b);
    }

    private int GetLCM(int a, int b)
    {
        return ((a * b) / GetLCD(a, b));
    }
}
