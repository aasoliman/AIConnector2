package cgu.edu.ist380B.solimana.aiconnector2;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.os.Bundle;
import android.app.Activity;

public class AIConnector extends Activity {
	
	// Declare Tab Variable
	Tab tab;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Create the actionbar
				ActionBar actionBar = getActionBar();

				// Hide Actionbar Icon
				actionBar.setDisplayShowHomeEnabled(false);

				// Hide Actionbar Title
				actionBar.setDisplayShowTitleEnabled(false);

				// Create Actionbar Tabs
				actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

				// Create first Tab
				tab = actionBar.newTab().setTabListener(new FragmentsTab1());
				// Create your own custom icon
				//tab.setIcon(R.drawable.tab1);
				tab.setText("Food");	
				tab.setIcon(R.drawable.pizza);
				actionBar.addTab(tab);

				// Create Second Tab
				tab = actionBar.newTab().setTabListener(new FragmentsTab2());
				// Set Tab Title
				tab.setText("Activities");
				tab.setIcon(R.drawable.videgames);
				actionBar.addTab(tab);

				// Create Third Tab
				tab = actionBar.newTab().setTabListener(new FragmentsTab3());
				// Set Tab Title
				tab.setText("Admin");
				tab.setIcon(R.drawable.settings);
				actionBar.addTab(tab);
		
		}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aiconnector, menu);
		return true;
	}

}

