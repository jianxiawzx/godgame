package bb.godgame;

import bb.godgame.R;
import bb.godgame.MySlipSwitch.OnSwitchListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SettingActivity extends Activity implements OnClickListener{

	private MySlipSwitch mySlipSwitch;
	private Button button;
	private TextView textView;
	Handler handler= new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		button=(Button)findViewById(R.id.set_back);
		button.setOnClickListener(this);
		textView=(TextView)findViewById(R.id.setting_state);
		if(MainActivity.isPlay==1)
		{
		    textView.setText(R.string.showon);
		}
		else
		{
			textView.setText(R.string.showoff);
		}
		mySlipSwitch=(MySlipSwitch)findViewById(R.id.musicslipswitch);
		mySlipSwitch.setImageResource(R.drawable.bkg_switch, R.drawable.bkg_switch, R.drawable.btn_slip);
		mySlipSwitch.setSwitchState(true);
		mySlipSwitch.setOnSwitchListener(new OnSwitchListener() {	
			public void onSwitched(boolean isSwitchOn) {
				// TODO Auto-generated method stub
				if(isSwitchOn)
				{
					bb.godgame.MainActivity.isPlay=1;
					startService(new Intent("bb.godgame.MUSIC"));
					textView.setText(R.string.showon);
				}
				else 
				{
					bb.godgame.MainActivity.isPlay=0;
					stopService(new Intent("bb.godgame.MUSIC"));
					textView.setText(R.string.showoff);
				}
			}
		});
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId()==R.id.set_back)
		{
			Intent intent =new Intent();
			intent.setClass(SettingActivity.this, MainActivity.class);
			startActivity(intent);
			this.finish();
		}
	}
	

}
