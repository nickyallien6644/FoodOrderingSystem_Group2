package com.example.foodorderingsystem.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.example.foodorderingsystem.Model.Account;
import com.example.foodorderingsystem.Model.SessionManagement;
import com.example.foodorderingsystem.R;
import com.example.foodorderingsystem.Utils.Api;
import com.example.foodorderingsystem.Utils.ApiInterface;
import com.example.foodorderingsystem.Utils.Email;
import com.example.foodorderingsystem.fragment.ConfirmEmail;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ForgotPassword extends AppCompatActivity {
    ApiInterface accountService;
    private List<Account> listAccounts;
    Account user;
    private Session mSession;
    TextInputLayout txtlayoutEmail;
    TextInputEditText etxtFotgEmail;
    SessionManagement sessionManagement;
    String ForgotEmail;
    boolean isAcount = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        listAccounts = new ArrayList<> ();
        getUser ();
        txtlayoutEmail = findViewById (R.id.txtlayout_ForgEmail);
        etxtFotgEmail = findViewById(R.id.etxt_ForgEmail);

        etxtFotgEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() != 0) {
                    if( !validateEmail() ||listAccounts == null || listAccounts.isEmpty ()){
                        txtlayoutEmail.setError ("loi ne 123");
                    }else {
                        ForgotEmail = txtlayoutEmail.getEditText().getText().toString().trim();
                        for (Account account : listAccounts) {
                            if (ForgotEmail.equals (account.getaEmail ())) {
                                isAcount = true;
                                user = account;
                                Toast.makeText (ForgotPassword.this, "Yes", Toast.LENGTH_SHORT).show ();
                                break;
                            }
                        }
                        if(isAcount){
                            isAcount = true;
                            txtlayoutEmail.setError (null);
                        }else {
                            txtlayoutEmail.setError ("loi ne");
                        }
                    }

                }else {
                    txtlayoutEmail.setError (null);
                }

            }
            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public void btnNext(View v){
        if (isAcount == true){
            sendMail();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.Frgment_ConfigEmail, new ConfirmEmail());
            fragmentTransaction.commit();

        }else {
            txtlayoutEmail.setError ("loi ne 444");
        }
    }
    public void getUser() {
        listAccounts = new ArrayList<>();
        accountService= Api.getClients ();  // call Api get PersonService
        Call<List<Account>> call=accountService.getAccounts (); // call list get Student
        call.enqueue(new Callback<List<Account>>() {
            /**
             * On Response is the data that the server returns to the client
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<List<Account>> call, Response<List<Account>> response) {
                if(response.isSuccessful()) {
                    listAccounts = response.body();
                    Log.e ("List User",listAccounts.size ()+"");
                }
            }

            @Override
            public void onFailure(Call<List<Account>> call, Throwable t) {
                Log.e("Error:",t.getMessage());
            }
        });
    }
    private boolean validateEmail(){
        String inputEmail = txtlayoutEmail.getEditText().getText ().toString ().trim ();
        if (inputEmail.isEmpty ()){
            txtlayoutEmail.setError ("Email not empty");
            return false;
        }else if (!Patterns.EMAIL_ADDRESS.matcher (inputEmail).matches ()){
            txtlayoutEmail.setError ("Email invaluable please input again");
            return false;
        }
        else {
            txtlayoutEmail.setError (null);
            return true;
        }
    }
    private void sendMail() {

        String mail = etxtFotgEmail.getText().toString().trim();
        int code ;
        Random random = new Random();
        code = random.nextInt(89999) + 1000;
        String message = "Code: "+code;
        String subject = "Forgot PassWord";
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        sessionManagement = new SessionManagement (ForgotPassword.this) ;
                        sessionManagement.save (mail,String.valueOf(code));
                        Toast.makeText(ForgotPassword.this,"Message Sent",Toast.LENGTH_SHORT).show();
                    }
                });

                Properties props = new Properties();

                //Configuring properties for gmail
                //If you are not using gmail you may need to change the values
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");

                //Creating a new session
                mSession = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                            //Authenticating the password
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(Email.EMAIL, Email.PASSWORD);
                            }
                        });

                try {
                    //Creating MimeMessage object
                    MimeMessage mm = new MimeMessage(mSession);

                    //Setting sender address
                    mm.setFrom(new InternetAddress(Email.EMAIL));
                    //Adding receiver
                    mm.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
                    //Adding subject
                    mm.setSubject(subject);
                    //Adding message
                    mm.setText(message);
                    //Sending email
                    Transport.send(mm);

                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        });


    }
    public static final Pattern EMAIL_ADDRESS =
            Pattern.compile ("[a-zA-Z0-9_]{5,20}@(Gmail|gmail|email|Email)(.com|.edu)(.edu|.vn)*$");
}