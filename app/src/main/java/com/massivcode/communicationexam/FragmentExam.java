package com.massivcode.communicationexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class FragmentExam extends Fragment implements View.OnClickListener {

    private EditText mEditText;
    private Button mSendButton;
    private TextView mTextView;




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment, container, false);

        mEditText = (EditText) view.findViewById(R.id.et_to_activity);
        mTextView = (TextView) view.findViewById(R.id.tv_received);
        mSendButton = (Button) view.findViewById(R.id.btn_send);
        mSendButton.setOnClickListener(this);



        return view;
    }

    public void receiveDataFromActivity(String string) {
        Toast.makeText(getActivity(), "액티비티로부터 메세지를 전달받았습니다!", Toast.LENGTH_SHORT).show();
        mTextView.append("액티비티 : " + string + "\n");
    }


    // 프래그먼트에서 액티비티로 데이터를 보낼 때 사용하는 리스너
    private FragmentToActivityListener mFragmentToActivity;

    // 리스너를 세팅하는 메소드
    public void setFragmentToActivityListener(FragmentToActivityListener listener) {
        mFragmentToActivity = listener;
    }

    @Override
    public void onClick(View v) {
        String message = mEditText.getText().toString();

        if(TextUtils.isEmpty(message)) {
            Toast.makeText(getActivity(), "메시지를 입력해주세요!", Toast.LENGTH_SHORT).show();
        } else {
            if(mFragmentToActivity != null) {
                mFragmentToActivity.receivedData(message);
            }

        }

    }

}
