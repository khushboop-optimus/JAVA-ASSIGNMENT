package com.example.android_assign1;

//import com.example.android.fragments.R;

import android.os.Build;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.widget.SearchViewCompatIcs.MySearchView;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {

	Button list_view, grid_view, exlist_view;
	StartFragment myFragment = new StartFragment();
    FragmentTransaction transaction,ft;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
	@Override
	public void onCreate(final Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		list_view = (Button) findViewById(R.id.list);
		grid_view = (Button) findViewById(R.id.grid);
		exlist_view = (Button) findViewById(R.id.exlist);

		
		grid grid_fragment=new grid();
		exlist exlist_fragment=new exlist();
	    transaction = getFragmentManager()
				.beginTransaction();
		list list_fragment=new list();
		transaction.add(R.id.myfragment, list_fragment);
		
		//transaction.addToBackStack(null);
		//transaction
		//		.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
		transaction.commit();
		
	

	    ft = getFragmentManager().beginTransaction();

		StartFragment myFragment = new StartFragment();
		ft.add(R.id.myfragment, myFragment);
		//ft.detach(myFragment);
		//ft.attach(myFragment);
		ft.commit();	
		//ft.detach(myFragment);
		//ft.commit();
		
		list_view.setOnClickListener(btnOnClickListener);
		grid_view.setOnClickListener(btnOnClickListener);
		exlist_view.setOnClickListener(btnOnClickListener);
	}

	Button.OnClickListener btnOnClickListener = new Button.OnClickListener() {
		@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
		@Override
		public void onClick(View v) {
			//FragmentActivity list_fragment,grid_fragment,exlist_fragment;
			
			grid grid_fragment=new grid();
			exlist exlist_fragment=new exlist();
			FragmentTransaction transaction = getFragmentManager()
					.beginTransaction();
			list list_fragment=new list();
			transaction.add(R.id.myfragment, list_fragment);
			
			//transaction.addToBackStack(null);
			//transaction
			//		.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			transaction.commit();
			//transaction.add(R.id.myfragment, grid_fragment);
			//transaction.add(R.id.myfragment, exlist_fragment);
			

			
              //newfragment=myFragment;
			
			if (v == list_view) {
			   // oldfragment=newfragment;	
				//newfragment = new list();
				
				//newfragment=
				
				transaction.detach(list_fragment);
				
			}
 
			else if (v == grid_view)
			{
	            //oldfragment=newfragment;		
				//newfragment = new grid();
				transaction.attach(list_fragment);
			}
			
			
			else if (v == exlist_view)

			{
				 // oldfragment=newfragment;	
				//newfragment = new exlist();
			} else {
				  //oldfragment=newfragment;	
				  //newfragment = new StartFragment();
			}

			//FragmentTransaction transaction = getFragmentManager()
					//.beginTransaction();
			//transaction.detach(oldfragment);
			//transaction.attach(newfragment);
		
			
			//transaction.addToBackStack(null);
			//transaction
				//	.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
			//transaction.commit();
		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
