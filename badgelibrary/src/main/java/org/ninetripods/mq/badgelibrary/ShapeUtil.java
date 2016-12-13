package org.ninetripods.mq.badgelibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;

/**
 * Created by MQ on 2016/11/29.
 */

class ShapeUtil {
    /**
     * 设置圆角矩形背景
     *
     * @param mContext   Context
     * @param view       TargetView
     * @param dipRadius  circular radius
     * @param badgeColor background color
     */
    static void setRoundRectBg(Context mContext, View view, int dipRadius, int badgeColor) {
        int radius = TypefaceUtil.dip2Px(mContext, dipRadius);
        float[] radiusArray = new float[]{radius, radius, radius, radius, radius, radius, radius, radius};
        RoundRectShape roundRect = new RoundRectShape(radiusArray, null, null);
        ShapeDrawable bgDrawable = new ShapeDrawable(roundRect);
        bgDrawable.getPaint().setColor(badgeColor);
        view.setBackgroundDrawable(bgDrawable);
    }

    /**
     * 设置矩形背景
     *
     * @param view       TargetView
     * @param badgeColor background color
     */
    static void setRectBg(View view, int badgeColor) {
        RectShape rectShape = new RectShape();
        ShapeDrawable drawable = new ShapeDrawable(rectShape);
        drawable.getPaint().setColor(badgeColor);
        drawable.getPaint().setStyle(Paint.Style.FILL); //填充
        view.setBackgroundDrawable(drawable);
    }

    /**
     * 设置椭圆背景
     *
     * @param view       TargetView
     * @param badgeColor background color
     */
    static void setOvalBg(View view, int badgeColor) {
        OvalShape ovalShape = new OvalShape();
        ShapeDrawable drawable = new ShapeDrawable(ovalShape);
        drawable.getPaint().setColor(badgeColor);
        drawable.getPaint().setStyle(Paint.Style.FILL);
//        drawable.getPaint().setStrokeWidth(1);
//        drawable.setBounds(0, 0, view.getMeasuredWidth() * 2, view.getMeasuredHeight() * 2);
//        drawable.getPaint().setShadowLayer(10, 15, 15, Color.GREEN);//设置阴影
        view.setBackgroundDrawable(drawable);
    }

    /**
     * 设置椭圆背景
     *
     * @param view       TargetView
     * @param badgeColor background color
     */
    static void setCircleBg(View view, int badgeColor) {
        view.setBackgroundDrawable(new CircleDrawable(badgeColor));
    }
}
