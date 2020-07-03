package com.gajen.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.RadioButton;

/**
 * Created by Alka on 7/26/2016.
 */
public class RobotoNormalRadioButton extends RadioButton {

    public RobotoNormalRadioButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoNormalRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoNormalRadioButton(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "NotoSans-Regular.ttf");
            setTypeface(tf);
        }
    }

}
