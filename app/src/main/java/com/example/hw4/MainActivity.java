package com.example.hw4;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText etPrograming, etDataStructure, etAlgorithm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }
    private void  findViews(){
        etPrograming = (EditText) findViewById(R.id.etPrograming);
        etDataStructure = (EditText) findViewById(R.id.etDataStructure);
        etAlgorithm = (EditText) findViewById(R.id.etAlgorithm);
    }
    private boolean isVlid(EditText editText){
        String pattern = "1[0]{2}|[0-9]{1,2}";
        String text = editText.getText().toString();
        if(!text.matches(pattern)){
            editText.setError("0~100");
            return false;
        }else{
            return true;
        }
    }

    public void onSubmitClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean isValid =
                isVlid(etPrograming) & isVlid(etDataStructure) & isVlid(etAlgorithm);
        if(!isValid){

            return;
        }
        builder.setNeutralButton("Nothing",null);
        builder.setNegativeButton("CANCEL",null);
        builder.setPositiveButton("OK", null);

        int programming = Integer.parseInt(etPrograming.getText().toString());
        int dataStructure = Integer.parseInt(etDataStructure.getText().toString());
        int algorithm = Integer.parseInt(etAlgorithm.getText().toString());
        Intent intent = new Intent(this,ResultActivity.class);
        Bundle bundle = new Bundle();
        bundle.putInt("programming",programming);
        bundle.putInt("dataStructure",dataStructure);
        bundle.putInt("algorithm",algorithm);

        intent.putExtras(bundle);
        startActivity(intent);
    }
}
