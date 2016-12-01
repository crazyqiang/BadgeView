package org.ninetripods.mq.badgelibrary;

import android.content.Context;

/**
 * Created by MQ on 2016/11/28.
 */

public class TypefaceUtil {
    /*
     * converts dip to px
     */
    public static int dip2Px(Context context, float dip) {
        return (int) (dip * context.getResources().getDisplayMetrics().density + 0.5f);
    }

//    /**
//     * converts sp to px
//     */
//    public static int sp2px(Context context, float sp) {
//        return (int) (sp * context.getResources().getDisplayMetrics().scaledDensity);
//    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
