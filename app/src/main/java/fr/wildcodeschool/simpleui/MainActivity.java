package fr.wildcodeschool.simpleui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables initialization
    private CheckBox mIWantToBeAWilder;
    private EditText mFirstName;
    private EditText mLastName;
    private Button mButtonAccept;
    private TextView mCongratulations;
    private boolean isCheckboxActive = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstName = (EditText) findViewById(R.id.firstName);
        mLastName = (EditText) findViewById(R.id.lastName);
        mCongratulations = (TextView) findViewById(R.id.congratulations);

        //Set edittexts as not enabled
        mFirstName.setEnabled(false);
        mLastName.setEnabled(false);

        //Set the "Congratulations" message as invisible
        mCongratulations.setVisibility(TextView.INVISIBLE);

        addListenerOnYesWilder();
        addListenerOnButtonAccept();

    }

    //Add a listener on the CheckBox "Yes Wilder". If checked, set as enabled the two "mFirstName" and "mLastName" EditTexts. Else, set as enabled the two  "mFirstName" and "mLastName" EditTexts.
    public void addListenerOnYesWilder() {

        mIWantToBeAWilder = (CheckBox) findViewById(R.id.Yeswilder);

        mIWantToBeAWilder.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                isCheckboxActive = !isCheckboxActive; //Reverse isCheckboxActive

                if(isCheckboxActive) {
                    mFirstName.setEnabled(true);
                    mLastName.setEnabled(true);
                }
                else {
                    mFirstName.setEnabled(false);
                    mLastName.setEnabled(false);
                }

            }
        });

        mFirstName.setEnabled(false);
        mLastName.setEnabled(false);

    }


    // When user click on accept :
    // If mfirstName or mLastName is empty : add a toast "please fill firstname and lastname"
    // Else : Set the "Congratulations" visible and write "Congratulations + Firstname + Lastname"
    public void addListenerOnButtonAccept() {

        mButtonAccept = (Button) findViewById(R.id.accept);

        mButtonAccept.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                if(mFirstName.getText().toString().isEmpty() || mLastName.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill your firstname and lastname !", Toast.LENGTH_LONG).show();

                }
                else {
                    mCongratulations.setText("Congratulations " + mFirstName.getText().toString() + " " + mLastName.getText().toString());
                    mCongratulations.setVisibility(TextView.VISIBLE);
                }


            }
        });



    }



}