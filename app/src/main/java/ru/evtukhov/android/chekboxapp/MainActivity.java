package ru.evtukhov.android.chekboxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews(){
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mBtnOk.setOnClickListener(success);
    }

    private void resetCheckBoxes(){
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        mCashAddressChkBx.setChecked(true);
                        break;
                    default:
                }
            }
        }
    };

    View.OnClickListener success = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mBankCardChkBx.isChecked()) {
                Toast.makeText(MainActivity.this, mInputMoney.getText().toString() + " " + getString(R.string.app_card) + " " + mInputInfo.getText().toString(), Toast.LENGTH_LONG).show();
            }
            if (mMobilePhoneChkBx.isChecked()) {
                Toast.makeText(MainActivity.this, mInputMoney.getText().toString() + " " + getString(R.string.app_mobile) + " " + mInputInfo.getText().toString(), Toast.LENGTH_LONG).show();
            }
            if (mCashAddressChkBx.isChecked()) {
                Toast.makeText(MainActivity.this, mInputMoney.getText().toString() + " " + getString(R.string.app_cash) + " " + mInputInfo.getText().toString(), Toast.LENGTH_LONG).show();
            }
        }
    };
}
