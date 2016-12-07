package com.example.mike.callactivity;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.provider.CallLog;
import android.support.v4.app.ActivityCompat;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends Activity implements View.OnClickListener {

    EditText phoneTo;
    Button btn,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12,btn99;
    TextView textView = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneTo = (EditText) findViewById(R.id.editText2);
            btn = (Button)findViewById(R.id.button);
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);
        btn9 = (Button)findViewById(R.id.btn9);
        btn10 = (Button)findViewById(R.id.btn10);
        btn11 = (Button)findViewById(R.id.btn11);
        btn12 = (Button)findViewById(R.id.btn12);
        btn99 = (Button)findViewById(R.id.btn99);
        textView = (TextView)findViewById(R.id.txt1);

        getCallDetails();
        getWindow().setSoftInputMode(
         WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                                                       );
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makePhoneCall(view);
            }
        });


      /*  if () {
            Toast.makeText(MainActivity.this, "restart app after call", Toast.LENGTH_LONG).show();
            Intent restart = getBaseContext().getPackageManager().
            getLaunchIntentForPackage(getBaseContext().getPackageName());
            restart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(restart);
        }*/


        btn99.setOnLongClickListener(new View.OnLongClickListener() {
                 @Override
                 public boolean onLongClick(View view) {
                     int length = phoneTo.length();
                     if (length>0){
                         phoneTo.setText("");
                     }

                     return false;
                 }
             });
      phoneTo.setOnTouchListener(otl);

    }

    private void getCallDetails() {
        StringBuffer stringBuffer = new StringBuffer();
        String strOrder = android.provider.CallLog.Calls.DATE + " DESC";
        Cursor cursor = managedQuery(CallLog.Calls.CONTENT_URI, null,
                null, null, strOrder);
        int Number = cursor.getColumnIndex(CallLog.Calls.NUMBER);
        int Type = cursor.getColumnIndex(CallLog.Calls.TYPE);
        int Date1 = cursor.getColumnIndex(CallLog.Calls.DATE);
        int Duration = cursor.getColumnIndex(CallLog.Calls.DURATION);
        stringBuffer.append("Call Log :");
        while (cursor.moveToNext()) {
            String phNum = cursor.getString(Number);
            String callTypeCode = cursor.getString(Type);
            String strcallDate = cursor.getString(Date1);
            Date callDate = new Date(Long.valueOf(strcallDate));
            String callDuration = cursor.getString(Duration);
            String callType = null;
            int callcode = Integer.parseInt(callTypeCode);
            switch (callcode) {
                case CallLog.Calls.OUTGOING_TYPE:
                    callType = "Outgoing";
                    break;
                case CallLog.Calls.INCOMING_TYPE:
                    callType = "Incoming";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    callType = "Missed";
                    break;
            }

            stringBuffer.append("\nPhone Number:--- " + phNum + " \nCall Type:--- " + callType + " \nCall Date:--- " + callDate
                    + " \nCall duration in sec :--- " + callDuration);
            stringBuffer.append("\n----------------------------------");
        }
        //    cursor.close();
        textView.setText(stringBuffer);
    }


    public void makePhoneCall(View view) {

        try {
            String number = phoneTo.getText().toString();
            Intent phoneIntent = new Intent(Intent.ACTION_CALL );
            phoneIntent.setData(Uri.parse("tel:" + number));
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

               return;
           }
            startActivity(phoneIntent);


        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this,
                    "Call failed, please try again later!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn1:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_1));
                break;
            case R.id.btn2:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_2));
                break;
            case R.id.btn3:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_3));
                break;
            case R.id.btn4:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_4));
                break;
            case R.id.btn5:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_5));
                break;
            case R.id.btn6:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_6));
                break;
            case R.id.btn7:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_7));
                break;
            case R.id.btn8:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_8));
                break;
            case R.id.btn9:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_9));
                break;
            case R.id.btn10:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_0));
                break;
            case R.id.btn11:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_STAR));
                break;
            case R.id.btn12:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_POUND));
                break;
            case R.id.btn99:
                phoneTo.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));

                break;

        }

    }
  private View.OnTouchListener otl = new View.OnTouchListener() {
        public boolean onTouch (View v, MotionEvent event) {
          int a=   phoneTo.getOffsetForPosition(event.getX(), event.getY());
                phoneTo.setSelection(a);
            return true;
        }
    };


    @Override
    protected void onResume() {
        getCallDetails();

        super.onResume();
    }

}
