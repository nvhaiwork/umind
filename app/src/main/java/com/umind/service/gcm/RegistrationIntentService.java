/**
 * Copyright 2015 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.umind.service.gcm;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.umind.constant.Constants;
import com.umind.utility.CustomPreferences;

import android.app.IntentService;
import android.content.Intent;

import java.io.IOException;

public class RegistrationIntentService extends IntentService {

	private static final String TAG = "RegistrationIntentService";

	public RegistrationIntentService() {
		super(TAG);
	}

	@Override
	protected void onHandleIntent(Intent intent) {

		String token = "";
		try {

			InstanceID instanceID = InstanceID.getInstance(this);
			token = instanceID.getToken("302824348668",
					GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);
		} catch (IOException ignore) {
		}

		CustomPreferences.setPreferences(Constants.PREF_REGISTRATION_ID, token);
	}
}