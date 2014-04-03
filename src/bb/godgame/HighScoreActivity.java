package bb.godgame;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import bb.godgame.R.string;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

public class HighScoreActivity extends Activity{

	private static final String FILE_NAME = "highscore.txt";
	Button button;
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.highscore);
		button=(Button)findViewById(R.id.highscore_clear);
		textView=(TextView)findViewById(R.id.showhighscore);
		write("12345");
		textView.setText(read());
	}
	private void write(String text)
	{
		try
		{
			FileOutputStream fos = openFileOutput(FILE_NAME, MODE_PRIVATE);
			fos.write(text.getBytes());  
			fos.close();
		} catch (Exception e)
		{
			// TODO: handle exception
			e.printStackTrace();  
		}
	}
	private String  read() {
		try 
		{
			FileInputStream fis = openFileInput(FILE_NAME);  
			byte[] buffer = new byte[fis.available()]; 
			fis.read(buffer);
			String resString=new String(buffer);
			Log.e("res", resString);
		    return resString;
		} catch (Exception e)
		{
			// TODO: handle exception
			textView.setText("OH,苍天啊，你还没有记录啊，赶紧去玩玩，挑战一下自己的智商吧！！！");
			e.printStackTrace();
		}
		return null;
		
	}
}
