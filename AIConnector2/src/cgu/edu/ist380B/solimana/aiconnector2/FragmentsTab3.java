package cgu.edu.ist380B.solimana.aiconnector2;

import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ActionBar;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FragmentsTab3 extends Fragment implements ActionBar.TabListener {

	private Fragment mFragment3;
	private Button Write;
	private Button Read;
	private TextView Txt;
	private EditText TxtS;	
	public String text;
	
	//I am not sure this will work or not
	//Also should I cast the type to RelativeLayout?
         	
 

    
	@Override
	public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		//super.onCreate(savedInstanceState);
		
		View view3 = inflater.inflate(R.layout.fragment3,container,false);

		Txt = (TextView) view3.findViewById(R.id.txtv);
		TxtS=(EditText) view3.findViewById(R.id.txtS);
		Write = (Button) view3.findViewById(R.id.btw);
		Write.setOnClickListener(new OnClickListener() {
	        public void onClick(View v) {
	        	//Txt.setText("Yess!!!!!");
	        	
	            // here you set what you want to do when user clicks your button,
	            // e.g. launch a new activity
	        	if (!Environment.MEDIA_MOUNTED.equals(Environment
	    				.getExternalStorageState())) {
	    			Toast.makeText(getView().getContext(), "External SD card not mounted",
	    					Toast.LENGTH_LONG).show();
	    		} else {
	    			try {
	    				if (v == Write) {
	    					PackageManager m = getView().getContext().getPackageManager();
	    					String s = getView().getContext().getPackageName();
	    					PackageInfo p = m.getPackageInfo(s, 0);
	    					s = p.applicationInfo.dataDir;
	    					File myFile = new File(s + "/password.txt");
	    					myFile.createNewFile();
	    					FileOutputStream fOut = new FileOutputStream(myFile);
	    					OutputStreamWriter myOutWriter = new OutputStreamWriter(
	    							fOut);
	    					myOutWriter.append(TxtS.getText());
	    					myOutWriter.close();
	    					fOut.close();
	    					Toast.makeText(getView().getContext(),
	    							"Text Updated",
	    							Toast.LENGTH_SHORT).show();
	    				}} catch (Exception e) {
	    					Toast.makeText(getView().getContext(), e.getMessage(),
	    							Toast.LENGTH_SHORT).show();
	    				}}
	    				
	    			}	    			    	      
	    });
		Read = (Button) view3.findViewById(R.id.btr);
		Read.setOnClickListener(new OnClickListener() {
	        private BufferedReader myReader;

			public void onClick(View v) {
				//Txt.setText("Yess!!!!!");
					if (!Environment.MEDIA_MOUNTED.equals(Environment
	    				.getExternalStorageState())) {
	    			Toast.makeText(getView().getContext(), "External SD card not mounted",
	    					Toast.LENGTH_LONG).show();
	    		} else {
	    			if (v == Read) {

	    				try {
	    					PackageManager m = getView().getContext().getPackageManager();
	    					String s = getView().getContext().getPackageName();
	    					PackageInfo p = m.getPackageInfo(s, 0);
	    					s = p.applicationInfo.dataDir;
	    					File myFile = new File(s + "/MyDoople.txt");

	    					FileInputStream fIn = new FileInputStream(myFile);
	    					myReader = new BufferedReader(
	    							new InputStreamReader(fIn));
	    					String aDataRow = "";
	    					String aBuffer = "";

	    					while ((aDataRow = myReader.readLine()) != null) {
	    						aBuffer += aDataRow;

	    						// byte buffer into a string
	    						text = new String(aBuffer);

	    						Txt.setText(text);

	    					}}
	    					catch (Exception e) {
	    						Toast.makeText(getView().getContext(), e.getMessage(),
		    							Toast.LENGTH_SHORT).show();
	    					
	    				}}
	    				}
	        	
		
	        }
			});
		return view3;
		
	        

		// Get the view from fragment3.xml
		//mFragment3.getActivity().setContentView(R.layout.fragment3);
	}

	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		mFragment3 = new FragmentsTab3();
		// Attach fragment3.xml layout
		ft.add(android.R.id.content, mFragment3);
		ft.attach(mFragment3);
	}

	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Remove fragment3.xml layout
		ft.remove(mFragment3);
	}

	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub

	}
	


}
