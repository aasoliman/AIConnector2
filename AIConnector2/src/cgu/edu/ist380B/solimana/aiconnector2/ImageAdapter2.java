package cgu.edu.ist380B.solimana.aiconnector2;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;



import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter2 extends BaseAdapter {
	private Context mContext;
	
	// Keep all Images in array
	public Integer[] mThumbIds2 = {			
			R.drawable.beach, R.drawable.football,
			R.drawable.playground, R.drawable.mall,
			R.drawable.soccer, R.drawable.school,
			R.drawable.supermarket,R.drawable.swimmingpool,
			R.drawable.videgames
	};
	
	// Constructor
	public ImageAdapter2(Context c){
		mContext = c;
	}

	//@Override
	public int getCount() {
		return mThumbIds2.length;
	}

	//@Override
	public Object getItem(int position) {
		return mThumbIds2[position];
	}

	//@Override
	public long getItemId(int position) {
		return 0;
	}

	//@Override
	public View getView(int position, View convertView, ViewGroup parent) {			
		ImageView imageView;
		if (convertView == null) {
			imageView = new ImageView(mContext);
			imageView.setLayoutParams(new GridView.LayoutParams(220, 220));
			imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);			
		}
		else
		{
			imageView = (ImageView) convertView;			
		}
		imageView.setImageResource(mThumbIds2[position]);
        return imageView;
        
	}
	

}
