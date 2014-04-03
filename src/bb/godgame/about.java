package bb.godgame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class about extends Activity implements OnClickListener{

	Button btnBack=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aboutview);
		btnBack=(Button)findViewById(R.id.backmain);
		btnBack.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		Intent intent =new Intent();
		intent.setClass(about.this, MainActivity.class);
		startActivity(intent);
		about.this.finish();
	}
}
