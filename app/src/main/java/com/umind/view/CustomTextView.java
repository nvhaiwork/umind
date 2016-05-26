package com.umind.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class CustomTextView extends TextView {

	public CustomTextView(Context paramContext) {
		super(paramContext);
		setFont();
	}

	public CustomTextView(Context paramContext, AttributeSet paramAttributeSet) {
		super(paramContext, paramAttributeSet);
		setFont();
	}

	public CustomTextView(Context paramContext, AttributeSet paramAttributeSet,
			int paramInt) {
		super(paramContext, paramAttributeSet, paramInt);
		setFont();
	}

	public void setFont() {

		// if (isInEditMode()) {
		//
		// return;
		// }

		// int style = 0;
		// Typeface typeFace = getTypeface();
		// if (typeFace != null) {
		//
		// style = typeFace.getStyle();
		// }
		//
		// typeFace = Utilities.getTypeFace(getContext(), style);
		// setTypeface(typeFace);
	}
}
