package com.massivcode.communicationexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentToActivityListener {

    private EditText mEditText;
    private TextView mTextView;
    private Button mSendButton;

    private FragmentExam mFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.et_to_fragment);
        mTextView = (TextView) findViewById(R.id.tv_received);
        mSendButton = (Button) findViewById(R.id.btn_send);
        mSendButton.setOnClickListener(this);

        // 정적으로 레이아웃에 추가되어있는 프래그먼트는 아래와 같은 방법으로 얻어올 수 있습니다.
        mFragment = (FragmentExam) getSupportFragmentManager().findFragmentById(R.id.fragment);

        // 프래그먼트로부터 데이터를 받을 때 사용하는 리스너를 세팅하기 위한 메소드
        mFragment.setFragmentToActivityListener(this);
    }

    /**
     * 프래그먼트로부터 전달받은 데이터가 들어오는 콜백 메소드
     * @param str
     */
    @Override
    public void receivedData(String str) {
        mTextView.append("프래그먼트 : " + str + "\n");
    }


    @Override
    public void onClick(View v) {
        String message = mEditText.getText().toString();

        if(TextUtils.isEmpty(message)) {
            Toast.makeText(MainActivity.this, "전달할 메세지를 입력해주세요!", Toast.LENGTH_SHORT).show();
        } else {
            mFragment.receiveDataFromActivity(message);
        }
    }
}
