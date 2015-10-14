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
 * 作者:洪生鹏
 * 网站：http://www.hongshengpeng.com
 * 日期：2013-12-22
 * 请保留相关信息，不做商业用途
 * 
 * 
 */


public class Login extends Activity {

	private EditText mUser; // 帐号编辑框

	private EditText mPassword; // 密码编辑框

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

				String test = pwd; // test 32位（大）

				// 字符加密后的密文

				if (name.equals("test") && test.equals(pwd)) // 判断 帐号和密码

				{

					Intent intent = new Intent();

					intent.setClass(Login.this, LoginLoad.class);

					intent.putExtra("username", name);

					startActivity(intent);

				} else if ("".equals(mUser.getText().toString())

				|| "".equals(mPassword.getText().toString())) // 判断

				// 帐号和密码

				{

					new AlertDialog.Builder(Login.this)

					.setIcon(

					getResources().getDrawable(

					R.drawable.login_error_icon))

					.setTitle("登录错误")

					.setMessage("帐号或者密码不能为空，\n请输入后再登录！")

					.setNegativeButton("关闭", null).create().show();

				} else {

					new AlertDialog.Builder(Login.this)

					.setIcon(

					getResources().getDrawable(

					R.drawable.login_error_icon))

					.setTitle("登录失败")

					.setMessage("帐号或者密码不正确，\n请检查后重新输入！")

					.setNegativeButton("关闭", null).create().show();

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
