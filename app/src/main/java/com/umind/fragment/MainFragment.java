package com.umind.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.ImageView;

import com.umind.R;
import com.umind.api.TCPClient;
import com.umind.constant.Constants;
import com.umind.utility.LogUtil;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Hai Nguyen - 11/5/15.
 */
public class MainFragment extends BaseFragment implements RecognitionListener {

	@Bind(R.id.main_btn_record)
	ImageView btnRecord;

	private SpeechRecognizer mSpeechEngine;

	public static MainFragment getInstance() {

		return new MainFragment();
	}

	@Override
	protected int addView() {

		return R.layout.fragment_main;
	}

	@Override
	public void onResume() {
		super.onResume();

		LocalBroadcastManager.getInstance(mAct).registerReceiver(
				mResponseReceiver, new IntentFilter(Constants.INTENT_PUSH));
	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		LocalBroadcastManager.getInstance(mAct).unregisterReceiver(
				mResponseReceiver);
	}

	@Override
	protected void initView() {
		super.initView();

		mSpeechEngine = SpeechRecognizer.createSpeechRecognizer(mAct);
		mSpeechEngine.setRecognitionListener(this);
		btnRecord.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {

			case R.id.main_btn_record :

				startSpeechEngine();
				break;
		}
	}
	// === RECOGNITION LISTENER ==
	@Override
	public void onReadyForSpeech(Bundle bundle) {

	}

	@Override
	public void onBeginningOfSpeech() {

	}

	@Override
	public void onRmsChanged(float v) {

	}

	@Override
	public void onBufferReceived(byte[] bytes) {

	}

	@Override
	public void onEndOfSpeech() {

	}

	@Override
	public void onError(int i) {

	}

	@Override
	public void onResults(Bundle bundle) {

		ArrayList<String> matches = bundle
				.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
		if (matches == null || matches.size() == 0) {

			return;
		}

		new TCPClient().execute(matches.get(0));
	}

	@Override
	public void onPartialResults(Bundle bundle) {

	}

	@Override
	public void onEvent(int i, Bundle bundle) {

	}

	// == END OF RECOGNITION LISTENER ==
	// == PRIVATE METHOD ==
	/**
	 *
	 * Start speech engine
	 */
	private void startSpeechEngine() {

		Intent recognizerIntent = new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_PREFERENCE,
				"VN");
		recognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
				mAct.getPackageName());
		// recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
		// RecognizerIntent.LANGUAGE_MODEL_WEB_SEARCH);
		recognizerIntent.putExtra(RecognizerIntent.EXTRA_PARTIAL_RESULTS, true);
		recognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "vi");
		recognizerIntent.putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 1);
		mSpeechEngine.startListening(recognizerIntent);
	}

	private BroadcastReceiver mResponseReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {

			String message = intent
					.getStringExtra(Constants.INTENT_PUSH_MESSAGE);
			LogUtil.e("Response Message", message);
		}
	};
}
