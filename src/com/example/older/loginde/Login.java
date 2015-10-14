package com.example.older.loginde;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.older_serv.R;
import com.example.older_serv.R.drawable;
import com.example.older_serv.R.id;
import com.example.older_serv.R.layout;


/*
 * ����:������
 * ��վ��http://www.hongshengpeng.com
 * ���ڣ�2013-12-22
 * �뱣�������Ϣ��������ҵ��;
 * 
 * 
 */


public class Login extends Activity {

	private EditText mUser; // �ʺű༭��

	private EditText mPassword; // ����༭��

	Button btnLogin, btnBack, btnSave, btnCancel, btnLeave;
	private PopupWindow popupWindowshare;
	private View popupWindowView;
	private EditText leaveword;
	private TextView titleTv, fontSmall, fontMiddle, fontLarge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.login);
		
		mUser = (EditText) findViewById(R.id.login_user_edit);

		mPassword = (EditText) findViewById(R.id.login_passwd_edit);

		btnLogin = (Button) findViewById(R.id.login_login_btn);

		btnBack = (Button) findViewById(R.id.login_reback_btn);
		
		btnLogin.setOnClickListener(listener);

		btnBack.setOnClickListener(listener);
		
	}

	OnClickListener listener = new OnClickListener() {

		public void onClick(View v) {

			switch (v.getId()) {

			case R.id.login_login_btn:

				String name = mUser.getText().toString();

				String pwd = MD5.getMD5(mPassword.getText().toString());
			//	Toast.makeText(getApplicationContext(), pwd,Toast.LENGTH_SHORT).show();

				String test = pwd; // test 32λ����

				// �ַ����ܺ������

				if (name.equals("test") && test.equals(pwd)) // �ж� �ʺź�����

				{

					Intent intent = new Intent();

					intent.setClass(Login.this, LoginLoad.class);

					intent.putExtra("username", name);

					startActivity(intent);

				} else if ("".equals(mUser.getText().toString())

				|| "".equals(mPassword.getText().toString())) // �ж�

				// �ʺź�����

				{

					new AlertDialog.Builder(Login.this)

					.setIcon(

					getResources().getDrawable(

					R.drawable.login_error_icon))

					.setTitle("��¼����")

					.setMessage("�ʺŻ������벻��Ϊ�գ�\n��������ٵ�¼��")

					.setNegativeButton("�ر�", null).create().show();

				} else {

					new AlertDialog.Builder(Login.this)

					.setIcon(

					getResources().getDrawable(

					R.drawable.login_error_icon))

					.setTitle("��¼ʧ��")

					.setMessage("�ʺŻ������벻��ȷ��\n������������룡")

					.setNegativeButton("�ر�", null).create().show();

				}

				break;

			case R.id.login_reback_btn:
                /*
				Login.this.finish();
				Intent msg = new Intent();

				msg.setClass(Login.this, MessageListActivity.class);

				

				startActivity(msg);
				*/
				
				/*
				Uph aUm = Uph.getInstance(Login.this);

			    aUm.getM(getApplicationContext(),"a399c779a0e5f17d49ddbf52dddd1640",0);
			    */
				break;
			

			
			
			default:
				break;

			}

		}

	};

}
