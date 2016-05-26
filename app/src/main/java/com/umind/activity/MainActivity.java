package com.umind.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.umind.R;
import com.umind.constant.Constants;
import com.umind.fragment.BaseFragment;
import com.umind.fragment.MainFragment;
import com.umind.service.gcm.RegistrationIntentService;
import com.umind.utility.CustomPreferences;
import com.umind.utility.Utilities;

import butterknife.Bind;

/**
 * Hai Nguyen - 11/2/15.
 */
public class MainActivity extends BaseActivity {

	@Bind(R.id.main_toolbar)
	Toolbar toolbar;

	@Override
	protected int addView() {
		return R.layout.activity_main;
	}

	@Override
	protected void initView(@Nullable Bundle savedInstanceState) {
		super.initView(savedInstanceState);

		if (!checkPlayServices()) {

			finish();
		}

		setUpToolBar();
		requestPermission();
		if (savedInstanceState == null) {

			addFragment(MainFragment.getInstance(), false);
		}

		String token = CustomPreferences.getPreferences(
				Constants.PREF_REGISTRATION_ID, "");
		if (token == null || token.equals("")) {

			startService(new Intent(this, RegistrationIntentService.class));
		}
	}

	/**
	 * add fragment
	 *
	 * @param fragment
	 *            Fragment
	 * @param isAddToBackStack
	 *            Add fragment to back stack or not
	 */
	public void addFragment(BaseFragment fragment, boolean isAddToBackStack) {

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.activity_container, fragment, fragment.getClass().getName());
		if (isAddToBackStack) {

			ft.addToBackStack(null);
		}

		ft.commit();
	}

	// /**
	// * Back to previous fragment
	// */
	// public void backFragment(boolean backToHome) {
	//
	// FragmentManager fm = getSupportFragmentManager();
	// if (fm.getBackStackEntryCount() <= 0) {
	//
	// finish();
	// return;
	// }
	//
	// if (backToHome) {
	//
	// fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
	// } else {
	//
	// fm.popBackStack();
	// }
	// }

	@Override
	public void onBackPressed() {

		super.onBackPressed();
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			@NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	// === PRIVATE METHODS =====

	/**
	 * Set up toolbar
	 */
	private void setUpToolBar() {

		setSupportActionBar(toolbar);
		toolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.white));
		ActionBar actionBar = getSupportActionBar();
		if (actionBar == null) {

			return;
		}

		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setDisplayShowHomeEnabled(false);
	}

	/**
	 * Request user permission
	 */
	private void requestPermission() {

		String[] PERMISSIONS = {Manifest.permission.RECORD_AUDIO,
				Manifest.permission.CALL_PHONE,
				Manifest.permission.READ_CONTACTS,
				Manifest.permission.SET_ALARM};

		if (!Utilities.hasPermissions(this, PERMISSIONS)) {

			ActivityCompat.requestPermissions(this, PERMISSIONS, 100);
		}
	}

	/**
	 * Check the device to make sure it has the Google Play Services APK. If it
	 * doesn't, display a dialog that allows users to download the APK from the
	 * Google Play Store or enable it in the device's system settings.
	 */
	private boolean checkPlayServices() {

		GoogleApiAvailability apiAvailability = GoogleApiAvailability
				.getInstance();
		int resultCode = apiAvailability.isGooglePlayServicesAvailable(this);
		if (resultCode != ConnectionResult.SUCCESS) {

			if (apiAvailability.isUserResolvableError(resultCode)) {

				apiAvailability.getErrorDialog(this, resultCode, 1001).show();
			} else {

				finish();
			}

			return false;
		}

		return true;
	}
}
