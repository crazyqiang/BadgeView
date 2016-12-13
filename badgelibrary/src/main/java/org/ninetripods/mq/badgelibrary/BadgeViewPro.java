package org.ninetripods.mq.badgelibrary;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by MQ on 2016/11/28.
 */

public class BadgeViewPro extends TextView {
    //背景形状
    private int shape_type;
    public static final int SHAPE_CIRCLE = 0;
    public static final int SHAPE_OVAL = 1;
    public static final int SHAPE_RECTANGLE = 2;
    public static final int SHAPE_ROUND_RECTANGLE = 3;

    private int bgColor;//背景颜色
    private Context mContext;
    private float leftMargin, topMargin, rightMargin, bottomMargin;
    private int gravity;
    private int textColor;
    private int textSize;
    private String textStr;

    public BadgeViewPro(Context context) {
        this(context, null);
    }

    public BadgeViewPro(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BadgeViewPro(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        gravity = Gravity.END | Gravity.TOP;
        this.mContext = context;
        //get custom attribute
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.BadgeViewPro);
        bgColor = ta.getColor(R.styleable.BadgeViewPro_bgColor, Color.RED);
        textColor = ta.getColor(R.styleable.BadgeViewPro_textColor, Color.WHITE);
        textSize = ta.getDimensionPixelSize(R.styleable.BadgeViewPro_textSize, 10);
        shape_type = ta.getInteger(R.styleable.BadgeViewPro_shape_type, SHAPE_ROUND_RECTANGLE);
        ta.recycle();
        if (!(getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams =
                    new FrameLayout.LayoutParams(
                            android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                            android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                            gravity);
            setLayoutParams(layoutParams);
        }
        //文本居中
        setGravity(Gravity.CENTER);
        setPadding(TypefaceUtil.dip2Px(context, 5)
                , TypefaceUtil.dip2Px(context, 1)
                , TypefaceUtil.dip2Px(context, 5)
                , TypefaceUtil.dip2Px(context, 1));
    }


    private void setTextBgShape() {
        switch (shape_type) {
            case SHAPE_CIRCLE:
                ShapeUtil.setCircleBg(this, bgColor);
                break;
            case SHAPE_OVAL:
                ShapeUtil.setOvalBg(this, bgColor);
                break;
            case SHAPE_RECTANGLE:
                ShapeUtil.setRectBg(this, bgColor);
                break;
            case SHAPE_ROUND_RECTANGLE:
                ShapeUtil.setRoundRectBg(mContext, this, 9, bgColor);
                break;
            default:
                break;
        }
    }

    /**
     * 设置目标View的Margin
     *
     * @param left   leftMargin
     * @param top    topMargin
     * @param right  rightMargin
     * @param bottom bottomMargin
     * @return BadgeViewPro
     */
    public BadgeViewPro setMargin(float left, float top, float right, float bottom) {
        leftMargin = TypefaceUtil.dip2Px(mContext, left);
        topMargin = TypefaceUtil.dip2Px(mContext, top);
        rightMargin = TypefaceUtil.dip2Px(mContext, right);
        bottomMargin = TypefaceUtil.dip2Px(mContext, bottom);
        return this;
    }

    /**
     * 设置文本颜色
     *
     * @param textColor TextColor
     * @return BadgeViewPro
     */
    public BadgeViewPro setStrColor(int textColor) {
        this.textColor = textColor;
        return this;
    }

    /**
     * 设置显示文本
     *
     * @param textStr StrText
     * @return BadgeViewPro
     */
    public BadgeViewPro setStrText(String textStr) {
        this.textStr = textStr;
        return this;
    }

    /**
     * 设置文本大小
     *
     * @param textSize TextSize
     * @return BadgeViewPro
     */
    public BadgeViewPro setStrSize(int textSize) {
        this.textSize = textSize;
        return this;
    }

    /**
     * 设置文字背景颜色
     *
     * @param bgColor Background Color
     * @return BadgeViewPro
     */
    public BadgeViewPro setStrBgColor(int bgColor) {
        this.bgColor = bgColor;
        return this;
    }

    /**
     * 设置文本背景类型
     *
     * @param shapeType ShapeType
     * @return BadgeViewPro
     */
    public BadgeViewPro setShape(int shapeType) {
        this.shape_type = shapeType;
        return this;
    }

    /**
     * get text background
     *
     * @param mGravity Gravity
     * @return BadgeViewPro
     */
    public BadgeViewPro setBgGravity(int mGravity) {
        this.gravity = mGravity;
        FrameLayout.LayoutParams layoutParams =
                new FrameLayout.LayoutParams(
                        android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                        android.view.ViewGroup.LayoutParams.WRAP_CONTENT,
                        gravity);
        setLayoutParams(layoutParams);
        return this;
    }


    /**
     * 绑定目标View
     *
     * @param target 目标View
     */
    public void setTargetView(final View target) {
        if (target == null) {
            return;
        }
        //目标view不可见，直接return
        if (target.getVisibility() == View.GONE | target.getVisibility() == View.INVISIBLE) return;
        if (TextUtils.isEmpty(textStr)) {
            shape_type = SHAPE_CIRCLE;
        } else {
            setText(textStr);
        }
        setTextSize(textSize);
        setTextColor(textColor);
        setTextBgShape();
        target.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                if (getParent() != null) {
                    ((ViewGroup) getParent()).removeView(BadgeViewPro.this);
                }
                if (target.getParent() instanceof FrameLayout) {
                    FrameLayout parentContainer = (FrameLayout) target.getParent();
                    setParams(target, parentContainer);
                    parentContainer.addView(BadgeViewPro.this);
                } else if (target.getParent() instanceof ViewGroup) {
                    //find TargetView's parent and remove TargetView from parent
                    ViewGroup parentContainer = (ViewGroup) target.getParent();
                    int groupIndex = parentContainer.indexOfChild(target);
                    parentContainer.removeView(target);
                    // new a FrameLayout that contains TargetView
                    FrameLayout pContainer = new FrameLayout(getContext());
                    //set LayoutParams
                    setParams(target, pContainer);
                    pContainer.addView(target);
                    pContainer.addView(BadgeViewPro.this);
                    parentContainer.addView(pContainer, groupIndex);
                } else if (target.getParent() == null) {
                    Log.e(getClass().getSimpleName(), "ParentView is needed");
                }
                target.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });


    }

    /**
     * 设置targetView和父View的LayoutParams
     *
     * @param target          TargetView
     * @param parentContainer TargetView的父View
     */
    private void setParams(View target, FrameLayout parentContainer) {
        int tempWidth, tempHeight;
        ViewGroup.LayoutParams containerParams = target.getLayoutParams();
        tempWidth = target.getWidth();
        tempHeight = target.getHeight();
        containerParams.width = (int) (tempWidth + leftMargin + rightMargin);
        containerParams.height = (int) (tempHeight + topMargin + bottomMargin);
        parentContainer.setLayoutParams(containerParams);
        parentContainer.setId(target.getId());
        FrameLayout.LayoutParams targetViewMargin = new FrameLayout.LayoutParams(tempWidth, tempHeight);
        targetViewMargin.leftMargin = (int) leftMargin;
        targetViewMargin.rightMargin = (int) rightMargin;
        targetViewMargin.topMargin = (int) topMargin;
        targetViewMargin.bottomMargin = (int) bottomMargin;
        target.setLayoutParams(targetViewMargin);
    }
}
