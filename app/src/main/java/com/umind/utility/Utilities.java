package com.umind.utility;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Hai Nguyen - 8/27/15.
 */
public class Utilities {

	// /**
	// * Dismiss dialog
	// */
	// public static void dismissDialog(Dialog dialog) {
	//
	// try {
	//
	// dialog.dismiss();
	// } catch (Exception e) {
	//
	// LogUtil.e("Dismiss dialog", "Dismiss dialog");
	// }
	// }

	// /**
	// * Show alert dialog
	// *
	// * @param title
	// * Dialog title
	// * @param message
	// * Dialog message
	// * @param positiveText
	// * Positive button text
	// * @param negativeText
	// * Negative button text
	// * @param positiveButtonClick
	// * Positive button click listener
	// * @param negativeButtonClick
	// * Negative button click listener
	// * @param isCancelAble
	// * True if can cancel
	// */
	// public static void showAlertDialog(Context context, String title,
	// String message, String positiveText, String negativeText,
	// DialogInterface.OnClickListener positiveButtonClick,
	// DialogInterface.OnClickListener negativeButtonClick,
	// boolean isCancelAble) {
	//
	// AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
	// dialogBuilder.setCancelable(isCancelAble);
	// dialogBuilder.setMessage(message);
	// if (!title.equals("")) {
	//
	// dialogBuilder.setTitle(title);
	// }
	//
	// // Positive button
	// if (!positiveText.equals("")) {
	//
	// if (positiveButtonClick != null) {
	//
	// dialogBuilder.setPositiveButton(positiveText,
	// positiveButtonClick);
	// } else {
	//
	// dialogBuilder.setPositiveButton(positiveText,
	// new DialogInterface.OnClickListener() {
	// @Override
	// public void onClick(DialogInterface dialog,
	// int which) {
	//
	// dialog.dismiss();
	// }
	// });
	// }
	// }
	//
	// // Negative button
	// if (!negativeText.equals("")) {
	//
	// if (negativeButtonClick != null) {
	//
	// dialogBuilder.setNegativeButton(negativeText,
	// negativeButtonClick);
	// } else {
	//
	// dialogBuilder.setNegativeButton(negativeText,
	// new DialogInterface.OnClickListener() {
	// @Override
	// public void onClick(DialogInterface dialog,
	// int which) {
	//
	// dialog.dismiss();
	// }
	// });
	// }
	// }
	//
	// AlertDialog dialog = dialogBuilder.create();
	// dialog.show();
	// }

	/**
	 * Get type face
	 */
	// public static Typeface getTypeFace(Context context, int style) {
	//
	// Typeface typeFace;
	// switch (style) {
	// case 1 :
	//
	// typeFace = Typeface.createFromAsset(context.getAssets(),
	// "fonts/SourceSansPro-Semibold.otf");
	// break;
	// case 2 :
	//
	// typeFace = Typeface.createFromAsset(context.getAssets(),
	// "fonts/SourceSansPro-LightIt.otf");
	// break;
	// case 3 :
	//
	// typeFace = Typeface.createFromAsset(context.getAssets(),
	// "fonts/SourceSansPro-SemiboldIt.otf");
	// break;
	// default :
	//
	// typeFace = Typeface.createFromAsset(context.getAssets(),
	// "fonts/SourceSansPro-Light.otf");
	// break;
	// }
	//
	// return typeFace;
	// }

	// /**
	// * Display network image
	// * */
	// public static void displayImage(Context ctx, ImageView imageView,
	// String url) {
	//
	//
	// Picasso.with(ctx).load(url).placeholder(R.mipmap.ic_launcher).into(imageView);
	// }
	/**
	 * Check user permission
	 *
	 * @param context
	 *            Application context
	 * @param permissions
	 *            List of permissions
	 * @return true if has permission
	 */
	public static boolean hasPermissions(Context context, String... permissions) {
		if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
				&& context != null && permissions != null) {

			for (String permission : permissions) {

				if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {

					return false;
				}
			}
		}

		return true;
	}
}
