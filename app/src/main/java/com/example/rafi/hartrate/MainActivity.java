package e.dcl.plusminus;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private Button bt1,bt2;
    private EditText et1,et2;
    private TextView tx1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt1=(Button)findViewById (R.id.bt1);
        bt2=(Button) findViewById(R.id.bt2) ;
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        tx1=(TextView)findViewById(R.id.tx1);


        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        String num1=et1.getText().toString();
        String num2=et2.getText().toString();

        double a=Double.parseDouble(num1);
        double b=Double.parseDouble(num2);
        if(v.getId()==R.id.bt1){
            double bmi=a/(b*b);
            float k = (float) Math.round(bmi * 100) / 100;

            if(bmi<18.5){

                tx1.setText("Your BMI is "+k+"\nYou Are too Underweight");
            }

            if(bmi>=18.5 && bmi<=24.9){

                tx1.setText("Your BMI is "+k+"\nYou Are Normal!");
            }
            if(bmi>=25 && bmi<=29.9){

                tx1.setText("Your BMI is "+k+"\nYou Are Overweight!");
            }

            if(bmi>=30){

                tx1.setText("Your BMI is "+k+"\nYou Are Messy!");
            }


        }

        if (v.getId()==R.id.bt2){


            try {
                Intent bi = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/tnBN06BZxWU"));
                startActivity(bi);
            }
            catch (Exception e){

                tx1.setText("First Calculate your BMI");

            }

        }

    }
}
