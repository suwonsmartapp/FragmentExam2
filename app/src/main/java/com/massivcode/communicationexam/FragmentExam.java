package com.massivcode.communicationexam;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    private String mReceivedData;

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
        mReceivedData = string;
        Toast.makeText(getActivity(), "액티비티로부터 메세지를 전달받았습니다!", Toast.LENGTH_SHORT).show();
        mTextView.append("\n" + mReceivedData);
    }

    @Override
    public void onClick(View v) {

    }
}
