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

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	
	// Keep all Images in array
	public Integer[] mThumbIds = {			
			R.drawable.apple, R.drawable.cheesesandwich,
			R.drawable.orange, R.drawable.macncheese,
			R.drawable.pizza, R.drawable.spagnmeatballs,
			R.drawable.watercup
	};
	
	
	// Constructor
	public ImageAdapter(Context c){
		mContext = c;
	}

	//@Override
	public int getCount() {
		return mThumbIds.length;
	}

	//@Override
	public Object getItem(int position) {
		return mThumbIds[position];
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
		imageView.setImageResource(mThumbIds[position]);
        return imageView;
        
	}
	

}
