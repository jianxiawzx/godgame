package bb.godgame;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.R.integer;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	static int isPlay=1;
	Button btnnormal;
	Button btnservive;
	Button btnsetting;
	Button btnabout;
	Button btnrecord;
	Button btnexit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if(isPlay==1)
		{
			startService(new Intent("bb.godgame.MUSIC"));
		}
		btnnormal=(Button)findViewById(R.id.narmal);
		btnservive=(Button)findViewById(R.id.servive);
		btnrecord=(Button)findViewById(R.id.record);
		btnabout=(Button)findViewById(R.id.about);
		btnsetting=(Button)findViewById(R.id.set);
		btnexit=(Button)findViewById(R.id.exit);
		btnabout.setOnClickListener(this);
		btnnormal.setOnClickListener(this);
		btnrecord.setOnClickListener(this);
		btnservive.setOnClickListener(this);
		btnsetting.setOnClickListener(this);
		btnexit.setOnClickListener(this);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		if(isPlay==0)
		{
			stopService(new Intent("bb.godgame.MUSIC"));
		}
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		stopService(new Intent("bb.godgame.MUSIC"));
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		super.onPause();
		if(v.getId()==R.id.about)
		{
			Intent intent=new Intent();
			intent.setClass(MainActivity.this, about.class);
			startActivity(intent);
		}
		if(v.getId()==R.id.exit)
		{
			this.finish();
		}
		if(v.getId()==R.id.set)
		{
			Intent intent =new Intent();
			intent.setClass(MainActivity.this , SettingActivity.class);
			startActivity(intent);
		}
		if (v.getId()==R.id.record) 
		{
			Intent intent =new Intent();
			intent.setClass(MainActivity.this , HighScoreActivity.class);
			startActivity(intent);
		}
	}
}
