package com.example.appbanhang.Activity.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appbanhang.JavaMailAPI.JavaMailAPI;
import com.example.appbanhang.R;
import com.example.appbanhang.Util.AccCountEmail;
import com.example.appbanhang.Util.CheckConnection;

import java.util.Date;

public class ContactFragment extends Fragment {

    private View rootView;


    private EditText edtFullName, edtEmail, edtPhone, edtMessage;
    private Button btnSend;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_contact, container, false);
        khoiTao();
        if (CheckConnection.haveNetworkConnection(getContext())) {
            khoiTao();
        }
        return rootView;
    }


    private void khoiTao() {
        edtFullName = (EditText) rootView.findViewById(R.id.contact_fullname_edit);
        edtEmail = (EditText) rootView.findViewById(R.id.contact_email_edt);
        edtPhone = (EditText) rootView.findViewById(R.id.contact_phone_edt);
        edtMessage = (EditText) rootView.findViewById(R.id.contact_message_edt);
        btnSend = (Button) rootView.findViewById(R.id.contact_send_message_btn);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date date = java.util.Calendar.getInstance().getTime();
                String titleCustomer = "Cảm ơn bạn đã góp ý, chúng tôi sẽ trả lời trong thời gian sớm nhất";
                String message = "<p>Thời gian góp ý " + date + "</p><p>Nội dung góp ý: " + edtMessage.getText().toString() + "</p><p>Mọi thắc mắc vui lòng liên hệ: 0788049042(Bảo) - Email: " + AccCountEmail.EMAIL + "</p>";
                JavaMailAPI javaMailAPI = new JavaMailAPI(getContext(), edtEmail.getText().toString(), titleCustomer, message, 1);
                javaMailAPI.execute();

                String myTitle = "Khách hàng góp ý " + edtFullName.getText().toString();
                String myMessage = "<p>Email khách hàng: " + edtEmail.getText().toString() + " - " + edtPhone.getText().toString() + "</p><p>Nội dung góp ý: " + edtMessage.getText().toString() + "</p>";
                JavaMailAPI javaMailAPI1 = new JavaMailAPI(getContext(), AccCountEmail.EMAIL, myTitle, myMessage, 1);
                javaMailAPI1.execute();
            }
        });
    }

}
