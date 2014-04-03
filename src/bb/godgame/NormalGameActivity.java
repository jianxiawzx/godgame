package bb.godgame;

import java.io.IOException;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class NormalGameActivity extends Activity{

	
	Button button;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.noralgame);
		button=(Button)findViewById(R.id.btn11);
	}
}
