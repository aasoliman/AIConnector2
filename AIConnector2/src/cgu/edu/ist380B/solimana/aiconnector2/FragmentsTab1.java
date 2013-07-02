package cgu.edu.ist380B.solimana.aiconnector2;



import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;

import cgu.edu.ist380B.solimana.aiconnector2.FullImageActivity;
import cgu.edu.ist380B.solimana.aiconnector2.ImageAdapter;

//com.androidbegin.fragmenttabs.R;
import android.os.Bundle;
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

public class FragmentsTab1 extends Fragment implements ActionBar.TabListener {

	private Fragment mFragment;	

	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    View view = inflater.inflate(R.layout.grid_layout,container,false);
	    GridView gridView = (GridView) view.findViewById(R.id.grid_view);
	    gridView.setAdapter(new ImageAdapter(getActivity())); 
		//On Click Do Action: Show Image		 
		gridView.setOnItemClickListener(new OnItemClickListener() {
			
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				Toast.makeText(getActivity(), String.valueOf(position), Toast.LENGTH_SHORT).show();			
			
				// Sending image id to FullImageActivity
				Intent i = new Intent(getActivity().getApplicationContext(), FullImageActivity.class);
				// passing array index
				i.putExtra("id", position);
				startActivity(i);
				
			}
		});
	    return view;
	}


	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment = new FragmentsTab1();
		// Attach fragment1.xml layout
		ft.add(android.R.id.content, mFragment);
		ft.attach(mFragment);
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Remove fragment1.xml layout
		ft.remove(mFragment);
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}

}
