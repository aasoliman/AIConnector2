package cgu.edu.ist380B.solimana.aiconnector2;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;

import cgu.edu.ist380B.solimana.aiconnector2.FullImageActivity2;
import cgu.edu.ist380B.solimana.aiconnector2.ImageAdapter2;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import android.content.Intent;

public class FragmentsTab2 extends Fragment implements ActionBar.TabListener {
	
	private Fragment mFragment2;
	
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		
		View view2 = inflater.inflate(R.layout.grid_layout2,container,false);
	    GridView gridView2 = (GridView) view2.findViewById(R.id.grid_view2);
	    gridView2.setAdapter(new ImageAdapter2(getActivity())); 
	    
		//On Click Do Action: Show Image		 
		gridView2.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				
				Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();
				
				// Sending image id to FullImageActivity
				Log.d(getTag(), "before intent");
				Intent i = new Intent(getActivity().getApplicationContext(), FullImageActivity2.class);
				// passing array index
				i.putExtra("id", position);
				startActivity(i);
				
			}
		});
	    return view2;
	}
	

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment2 = new FragmentsTab2();
		// Attach fragment2.xml layout
		ft.add(android.R.id.content, mFragment2);
		ft.attach(mFragment2);
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Remove fragment1.xml layout
		ft.remove(mFragment2);
	}
	
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

}
