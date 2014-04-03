package bb.godgame;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.MaskFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.ImageView;

public class startActivity extends Activity{

	private int flag1=0;
	private int flag2=0;
	private ImageView imageView=null;
	//开机启动的两个图片
	Bitmap bitmap0=null;
	Bitmap bitmap1=null;
	private int alpha=0;
	Handler handler= new Handler() {	
		@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				if(msg.what==0x123)
				{
					if(flag1==0)
					{
						imageView.setAlpha(alpha);
						imageView.setImageBitmap(bitmap0);
					}
					else
					{
						imageView.setAlpha(alpha);
						imageView.setImageBitmap(bitmap1);
					}
				}
				if (msg.what==0x12)
				{
					Intent intent=new Intent();
					intent.setClass(startActivity.this, MainActivity.class);
					startActivity(intent);
					startActivity.this.finish();
				}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.startview);
		//获取两个图片
		bitmap0=BitmapFactory.decodeResource(getResources(), R.drawable.start0);
		bitmap1=BitmapFactory.decodeResource(getResources(), R.drawable.start1);
		imageView=(ImageView)findViewById(R.id.image);
		//设置为第一个图片
		imageView.setImageBitmap(bitmap0);
		Runnable thread=new T();
		new Thread(thread).start();
	}
	public class T implements Runnable
	{
		@Override
		public void run() {		
			while(true)
			{
				//第一张图片，渐入渐出
				if(flag1==0)     
				{
					//渐入
					if(flag2==0)
					{
						alpha++;
						if(alpha>255)
						{
							flag2=1;
						}
						else
						{
							handler.sendEmptyMessage(0x123);
						}
					}
					else
					{
						alpha--;
						if(alpha<0)
						{
							alpha=0;
							flag1=1;
							flag2=0;
						}
						else
						{
							handler.sendEmptyMessage(0x123);
						}
					}
				}
				else
				{
					if(flag2==0)
					{
						alpha++;
						if(alpha>255)
						{
							flag2=1;
						}
						else
						{
							handler.sendEmptyMessage(0x123);
						}
					}
					else
					{
						alpha--;
						if(alpha<0)
						{
							alpha=0;
							flag1=0;
							flag2=0;
							handler.sendEmptyMessage(0x12);
							break;
						}
						else
						{
							handler.sendEmptyMessage(0x123);
						}
					}
				}
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
