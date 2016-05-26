package com.umind.api;

import android.os.AsyncTask;

import com.umind.constant.Constants;
import com.umind.utility.CustomPreferences;
import com.umind.utility.LogUtil;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Hai Nguyen - 5/26/16.
 */
public class TCPClient extends AsyncTask<String, Void, Void> {

	private final int SERVER_PORT = 80;
	private final String SERVER_IP = "128.199.68.171";

	@Override
	protected Void doInBackground(String... messages) {

		Socket socket = null;
		try {

			String token = CustomPreferences.getPreferences(
					Constants.PREF_REGISTRATION_ID, "");
			socket = new Socket(SERVER_IP, SERVER_PORT);

			// Push messages
			PrintWriter out = new PrintWriter(new BufferedWriter(
					new OutputStreamWriter(socket.getOutputStream())), true);

			// Auth message
			out.println("login_id:" + token);
			out.flush();

			// User message
			for (String message : messages) {

				out.println("_mip:" + message);
				out.flush();
			}

			// Done message
			out.println("_done");
			out.flush();

			// Close out put
			out.close();
		} catch (Exception ignore) {

			LogUtil.e("Exception", ignore.getMessage());
		} finally {

			if (socket != null) {

				try {

					socket.close();
				} catch (IOException ignore) {
				}
			}
		}

		return null;
	}
}
