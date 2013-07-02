package cgu.edu.ist380B.solimana.aiconnector2;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class FullImageActivity2 extends Activity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.full_image2);
		
		Intent i = getIntent();
		
		// Selected image id
		int position = i.getExtras().getInt("id");
		ImageAdapter2 imageAdapter2 = new ImageAdapter2(getApplicationContext());
		
		ImageView imageView = (ImageView) findViewById(R.id.full_image_view2);
		imageView.setImageResource(imageAdapter2.mThumbIds2[position]);
	}

}
