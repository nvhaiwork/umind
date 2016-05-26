package com.umind.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umind.activity.BaseActivity;

import butterknife.ButterKnife;

/**
 * Hai Nguyen - 8/28/15.
 */
public class BaseFragment extends Fragment implements View.OnClickListener {

	protected BaseActivity mAct;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

		int viewId = addView();
		View view = inflater.inflate(viewId, container, false);
		// view.setOnTouchListener(new View.OnTouchListener() {
		// public boolean onTouch(View v, MotionEvent event) {
		// return true;
		// }
		// });

		ButterKnife.bind(this, view);
		initView();
		return view;
	}

	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mAct = (BaseActivity) context;
	}

	/**
	 * Add view
	 */
	protected int addView() {

		return 0;
	}

	/**
	 * Init child view
	 */
	protected void initView() {

	}

	@Override
	public void onClick(View view) {

	}
}
