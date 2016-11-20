package tarek360.animated.icons;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;

class Drawer {

  private final InvalidateListener invalidateListener;
  private RectF viewBounds;
  private Paint paint;
  private TextPaint counterTextPaint;

  private float bellRotation = 0;
  private float tearRotation = 0;
  private float counterScale = 0;
  private int notificationCount = 0;
  private boolean isTearAnimated;
  private boolean isCounterAnimated;

  private RectF iconBounds;
  private int counterBackgroundColor;
  private int countColor;
  private int repeatCount = 0;
  private int bellColor;
  private Path bellPath;
  private Path bellTearPath;
  private Path counterCircleBackgroundPath;
  private RectF countTextRectRect;

  Drawer(InvalidateListener invalidateListener) {
    this.invalidateListener = invalidateListener;
    init();
  }

  private void init() {

    countColor = Color.WHITE;
    counterBackgroundColor = Color.RED;
    bellColor = Color.WHITE;

    viewBounds = new RectF();
    iconBounds = new RectF(0f, 0f, 180f, 180f);

    paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setStyle(Paint.Style.FILL);

    counterTextPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    counterTextPaint.setTypeface(Typeface.DEFAULT_BOLD);
    counterTextPaint.setTextSize(51f);

    // Bell Path
    bellPath = new Path();
    bellPath.moveTo(0.01f, -1.51f);
    bellPath.cubicTo(3.16f, -1.51f, 5.73f, 1.06f, 5.73f, 4.24f);
    bellPath.lineTo(5.73f, 10.45f);
    bellPath.cubicTo(21.98f, 13.21f, 34.34f, 27.41f, 34.34f, 44.49f);
    bellPath.lineTo(34.34f, 73.99f);
    bellPath.lineTo(51.51f, 91.24f);
    bellPath.lineTo(-51.49f, 91.24f);
    bellPath.lineTo(-34.33f, 73.99f);
    bellPath.lineTo(-34.33f, 44.49f);
    bellPath.cubicTo(-34.33f, 27.41f, -21.97f, 13.21f, -5.72f, 10.45f);
    bellPath.lineTo(-5.72f, 4.24f);
    bellPath.cubicTo(-5.72f, 1.06f, -3.15f, -1.51f, 0.01f, -1.51f);
    bellPath.close();

    // Bell Tear Path
    bellTearPath = new Path();
    bellTearPath.moveTo(11.03f, 84.88f);
    bellTearPath.cubicTo(11.03f, 91.24f, 5.91f, 96.38f, -0.41f, 96.38f);
    bellTearPath.cubicTo(-6.73f, 96.38f, -11.86f, 91.24f, -11.86f, 84.88f);
    bellTearPath.lineTo(11.03f, 84.88f);
    bellTearPath.close();

    // Counter Circle Background Path
    counterCircleBackgroundPath = new Path();
    counterCircleBackgroundPath.addOval(new RectF(-42.5f, -42.5f, 42.5f, 42.5f), Path.Direction.CW);

    countTextRectRect = new RectF(-42.5f, -42.5f, 42.5f, 42.5f);
  }

  void onSizeChanged(int w, int h, int oldw, int oldh) {
    viewBounds.right = w;
    viewBounds.bottom = h;
  }

  void reset() {

    counterScale = 0;
    bellRotation = 0;
    tearRotation = 0;
    isTearAnimated = false;
    isCounterAnimated = false;

    invalidateListener.invalidate();
  }

  void startAnimation() {
    reset();
    animateBell();
  }

  private void animateBell() {
    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -16, 16, -12, 7, -6, 5, -5, 4, -3, 0);

    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        bellRotation = (float) animation.getAnimatedValue();
        if (!isTearAnimated && bellRotation <= -12) {
          animateTear();
          isTearAnimated = true;
        }

        if (notificationCount > 0 && !isCounterAnimated && animation.getCurrentPlayTime() > 1000) {
          animateCounter();
          isCounterAnimated = true;
        }
        invalidateListener.invalidate();
      }
    });

    valueAnimator.setInterpolator(new DecelerateInterpolator());
    valueAnimator.setDuration(4000);
    valueAnimator.setRepeatCount(repeatCount);
    valueAnimator.start();
  }

  private void animateTear() {

    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, -12, 12, -11, 7, -6, 5, -5, 4, -3, 0);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        tearRotation = (float) animation.getAnimatedValue();
        invalidateListener.invalidate();
      }
    });

    valueAnimator.setInterpolator(new DecelerateInterpolator());
    valueAnimator.setDuration(4000);
    valueAnimator.setRepeatCount(repeatCount);
    valueAnimator.start();
  }

  private void animateCounter() {

    ValueAnimator valueAnimator = ValueAnimator.ofFloat(0.7f, 1.2f, 1.1f, 1.0f);
    valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
      @Override public void onAnimationUpdate(ValueAnimator animation) {
        counterScale = (float) animation.getAnimatedValue();

        invalidateListener.invalidate();
      }
    });

    valueAnimator.setInterpolator(new DecelerateInterpolator());
    valueAnimator.setDuration(1100);
    valueAnimator.start();
  }

  void drawIcon(Canvas canvas) {

    // Resize to Target Frame
    canvas.save();
    RectF resizedFrame = resizing(iconBounds, viewBounds);
    canvas.translate(resizedFrame.left, resizedFrame.top);
    canvas.scale(resizedFrame.width() / 180f, resizedFrame.height() / 180f);

    // Bell
    canvas.save();
    canvas.translate(81.49f, 46.51f);
    canvas.rotate(-bellRotation);

    paint.setColor(bellColor);
    canvas.drawPath(bellPath, paint);
    canvas.restore();

    // BellTear
    canvas.save();
    canvas.translate(81.91f, 58.62f);
    canvas.rotate(-tearRotation);

    canvas.drawPath(bellTearPath, paint);
    canvas.restore();

    // CounterBackground
    canvas.save();
    canvas.translate(121.5f, 66.5f);
    canvas.scale(counterScale, counterScale);

    paint.setColor(counterBackgroundColor);
    canvas.drawPath(counterCircleBackgroundPath, paint);

    counterTextPaint.setColor(countColor);

    // CountTextRect
    StaticLayout countTextRectStaticLayout =
        new StaticLayout(String.valueOf(notificationCount), counterTextPaint,
            (int) countTextRectRect.width(), Layout.Alignment.ALIGN_CENTER, 1f, 0f, false);
    canvas.save();
    canvas.clipRect(countTextRectRect);
    canvas.translate(countTextRectRect.left, countTextRectRect.top
        + (countTextRectRect.height() - countTextRectStaticLayout.getHeight()) / 2f);

    countTextRectStaticLayout.draw(canvas);

    canvas.restore();
  }

  private RectF resizing(RectF rect, RectF target) {
    if (rect.equals(target) || target == null) {
      return rect;
    }

    float scale = Math.min(Math.abs(target.width() / rect.width()),
        Math.abs(target.height() / rect.height()));

    RectF result =
        new RectF(target.centerX(), target.centerY(), target.centerX(), target.centerY());
    result.inset(-Math.abs(rect.width() * scale) / 2f, -Math.abs(rect.height() * scale) / 2f);
    return result;
  }

  void setColors(@ColorInt int bellColor, @ColorInt int countColor,
      @ColorInt int counterBackgroundColor) {
    this.bellColor = bellColor;
    this.countColor = countColor;
    this.counterBackgroundColor = counterBackgroundColor;
    invalidateListener.invalidate();
  }

  void setNotificationCount(int count) {
    this.notificationCount = count;
    invalidateListener.invalidate();
  }

  int getNotificationCount() {
    return notificationCount;
  }

  void setRepeatCount(int repeatCount) {
    this.repeatCount=repeatCount;
  }

  interface InvalidateListener {
    void invalidate();
  }
}
