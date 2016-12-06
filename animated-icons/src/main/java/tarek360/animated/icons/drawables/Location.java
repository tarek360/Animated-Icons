package tarek360.animated.icons.drawables;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.util.Property;
import android.view.animation.OvershootInterpolator;

public class Location extends AnimatedIcon {

  private static final String TAG = Settings.class.getSimpleName();
  private final static float finalCircleRadius = 51.969002f;
  private final float finalTransPointX = 247.274002f;
  private final float finalTransPointY = 198.386002f;
  float factorScale;
  private float viewBoxWidth = 512;
  private float viewBoxHeight = 536;
  private int animationDuration;
  private int color1;
  private int color2;
  private float transPointX = finalTransPointX;
  private float transPointY = finalTransPointY;
  private Path p;
  private Paint paint;
  private Path animationPath;
  private float rotationDegree;
  private float scale = 1.0f;
  private float circleRadius;
  private AnimatorSet animatorSet;
  private int animationStartDelay;
  private Property<Location, Float> circleRadiusProperty =
      new Property<Location, Float>(Float.class, "point") {
        @Override public Float get(Location object) {
          return object.circleRadius;
        }

        @Override public void set(Location object, Float value) {
          //            Log.i("circleRadius","circleRadius = " +circleRadius);
          object.circleRadius = value;
          invalidateSelf();
        }
      };
  private Property<Location, Float> transPointYProperty =
      new Property<Location, Float>(Float.class, "point") {
        @Override public Float get(Location object) {
          return object.transPointY;
        }

        @Override public void set(Location object, Float value) {
          //            Log.i("transPointY","transPointY = " +transPointY);
          object.transPointY = value;
          invalidateSelf();
        }
      };

  public Location() {
    animatorSet = new AnimatorSet();
    animationDuration = 700;
    animationStartDelay = 400;

    color1 = Color.WHITE;
    color2 = Color.WHITE;

    p = new Path();
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setStyle(Paint.Style.FILL);

    animationPath = new Path();

    animationPath.moveTo(624.604980f, 669.940002f);
    animationPath.rCubicTo(0.000000f, 0.000000f, -99.056000f, -28.247999f, -183.884995f,
        -100.837997f);
    animationPath.rCubicTo(-89.642998f, -76.709000f, -127.537003f, -181.574005f, -134.802994f,
        -195.785995f);
    animationPath.rCubicTo(-10.726000f, -20.978001f, -58.643002f, -174.929993f, -58.643002f,
        -174.929993f);
  }

  @Override protected void onBoundsChange(Rect bounds) {
    super.onBoundsChange(bounds);
    float viewBoxRatio = viewBoxWidth / viewBoxHeight;
    float boundsRatio = bounds.width() / (float) bounds.height();

    if (boundsRatio > viewBoxRatio) {
      // canvas larger than viewbox
      factorScale = bounds.height() / viewBoxHeight;
    } else {
      // canvas higher (or equals) than viewbox
      factorScale = bounds.width() / viewBoxWidth;
    }
    //        Log.i(TAG, "factorScale " + factorScale);
  }

  @Override public void draw(Canvas canvas) {

    Rect bounds = getBounds();
    if (viewBoxHeight <= 0 || viewBoxWidth <= 0 || bounds.width() <= 0 || bounds.height() <= 0) {
      return;
    }
    canvas.save();

    int newViewBoxHeight = Math.round(factorScale * viewBoxHeight);
    int newViewBoxWidth = Math.round(factorScale * viewBoxWidth);
    int marginX = bounds.width() - newViewBoxWidth;
    int marginY = bounds.height() - newViewBoxHeight;
    canvas.translate(bounds.left, bounds.top);
    canvas.translate(Math.round(marginX / 2f), Math.round(marginY / 2f));
    canvas.clipRect(0, 0, newViewBoxWidth, newViewBoxHeight);

    canvas.save();
    canvas.rotate(rotationDegree, newViewBoxWidth / 2, newViewBoxHeight / 2);
    canvas.scale(scale, scale, newViewBoxWidth / 2, newViewBoxHeight / 2);
    p.reset();
    p.moveTo(factorScale * -188.350006f + factorScale * transPointX,
        factorScale * 1.661000f + factorScale * transPointY);
    p.rCubicTo(factorScale * -0.136000f, factorScale * -82.226997f, factorScale * 49.945000f,
        factorScale * -154.501007f, factorScale * 125.680000f, factorScale * -180.001007f);
    p.rCubicTo(factorScale * 67.418999f, factorScale * -22.700001f, factorScale * 129.774002f,
        factorScale * -11.218000f, factorScale * 184.682999f, factorScale * 34.452999f);
    p.rCubicTo(factorScale * 37.460999f, factorScale * 31.159000f, factorScale * 58.729000f,
        factorScale * 71.917999f, factorScale * 64.850998f, factorScale * 120.138000f);
    p.rCubicTo(factorScale * 5.274000f, factorScale * 41.541000f, factorScale * -3.206000f,
        factorScale * 80.931999f, factorScale * -21.374001f, factorScale * 118.401001f);
    p.rCubicTo(factorScale * -15.364000f, factorScale * 31.687000f, factorScale * -36.254002f,
        factorScale * 59.587002f, factorScale * -59.118999f, factorScale * 86.132004f);
    p.rCubicTo(factorScale * -21.965000f, factorScale * 25.500999f, factorScale * -45.842999f,
        factorScale * 49.237999f, factorScale * -68.377998f, factorScale * 74.211998f);
    p.rCubicTo(factorScale * -12.776000f, factorScale * 14.159000f, factorScale * -25.212000f,
        factorScale * 28.612000f, factorScale * -35.368999f, factorScale * 44.840000f);
    p.rCubicTo(factorScale * -1.737000f, factorScale * 2.776000f, factorScale * -2.965000f,
        factorScale * 3.972000f, factorScale * -5.235000f, factorScale * 0.350000f);
    p.rCubicTo(factorScale * -14.385000f, factorScale * -22.950001f, factorScale * -32.903999f,
        factorScale * -42.501999f, factorScale * -51.310001f, factorScale * -62.146999f);
    p.rCubicTo(factorScale * -27.702000f, factorScale * -29.566999f, factorScale * -56.034000f,
        factorScale * -58.587002f, factorScale * -80.012001f, factorScale * -91.414001f);

    p.rCubicTo(factorScale * -24.056999f, factorScale * -32.935001f, factorScale * -43.088001f,
        factorScale * -68.236000f, factorScale * -50.901001f, factorScale * -108.764000f);
    p.cubicTo(factorScale * -187.263000f + factorScale * transPointX,
        factorScale * 25.261000f + factorScale * transPointY,
        factorScale * -188.731995f + factorScale * transPointX,
        factorScale * 12.549000f + factorScale * transPointY,
        factorScale * -188.350006f + factorScale * transPointX,
        factorScale * 1.661000f + factorScale * transPointY);
    p.close();
    p.moveTo(factorScale * -188.350006f + factorScale * transPointX,
        factorScale * 1.661000f + factorScale * transPointY);
    p.moveTo(factorScale * 0.030000f + factorScale * transPointX,
        factorScale * 86.991997f + factorScale * transPointY);
    p.cubicTo(factorScale * 47.301998f + factorScale * transPointX,
        factorScale * 87.419998f + factorScale * transPointY,
        factorScale * 87.046997f + factorScale * transPointX,
        factorScale * 48.476002f + factorScale * transPointY,
        factorScale * 87.612000f + factorScale * transPointX,
        factorScale * 1.174000f + factorScale * transPointY);
    p.cubicTo(factorScale * 88.188004f + factorScale * transPointX,
        factorScale * -47.022999f + factorScale * transPointY,
        factorScale * 49.669998f + factorScale * transPointX,
        factorScale * -86.737000f + factorScale * transPointY,
        factorScale * 2.902000f + factorScale * transPointX,
        factorScale * -88.139999f + factorScale * transPointY);
    p.rCubicTo(factorScale * -47.629002f, factorScale * -1.429000f, factorScale * -89.556000f,
        factorScale * 35.787998f, factorScale * -90.573997f, factorScale * 85.738998f);
    p.cubicTo(factorScale * -88.737000f + factorScale * transPointX,
        factorScale * 49.794998f + factorScale * transPointY,
        factorScale * -45.743000f + factorScale * transPointX,
        factorScale * 88.160004f + factorScale * transPointY,
        factorScale * 0.030000f + factorScale * transPointX,
        factorScale * 86.991997f + factorScale * transPointY);
    p.close();

    paint.setColor(color1);
    canvas.drawPath(p, paint);

    paint.setColor(color2);
    canvas.drawCircle(factorScale * 0.000000f + factorScale * transPointX,
        factorScale * -0.094000f + factorScale * transPointY, factorScale * circleRadius, paint);

    canvas.restore();
  }

  @Override public void setAlpha(int alpha) {
  }

  @Override public void setColorFilter(ColorFilter cf) {
  }

  @Override public int getOpacity() {
    return 0;
  }

  @Override public int getMinimumHeight() {
    return 10;
  }

  @Override public int getMinimumWidth() {
    return 10;
  }

  @Override public void startAnimation() {

    if (!animatorSet.isRunning()) {
      circleRadius = 0;

      final ValueAnimator mainAnimator = ValueAnimator.ofFloat(0.0f, 1.0f);
      mainAnimator.setDuration(animationDuration);
      mainAnimator.setInterpolator(new OvershootInterpolator());
      mainAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

        @Override public void onAnimationUpdate(ValueAnimator animation) {
          float fraction = animation.getAnimatedFraction();
          //                    Log.i("animation", "getAnimatedFraction " + fraction);

          float point[] = { 0f, 0f };
          PathMeasure pm = new PathMeasure(animationPath, false);
          pm.getPosTan(pm.getLength() * fraction, point, null);

          if (fraction <= 1.04) {
            scale = fraction;
          }

          rotationDegree = (1 - fraction) * -45;
          transPointX = point[0];
          transPointY = point[1];
          //                    Log.i("animation", "transPointX " + transPointX);
          //                    Log.i("animation", "transPointY " + transPointY);

          invalidateSelf();
        }
      });

      //
      final ObjectAnimator circleAnimator =
          ObjectAnimator.ofFloat(this, circleRadiusProperty, 0, finalCircleRadius);
      circleAnimator.setDuration((long) (animationDuration * 0.9f));
      circleAnimator.setStartDelay((long) (animationDuration * 0.7f));
      circleAnimator.setInterpolator(new OvershootInterpolator());

      // vertical vibrate

      final ObjectAnimator vibrateAnimator =
          ObjectAnimator.ofFloat(this, transPointYProperty, finalTransPointY, finalTransPointY + 22,
              finalTransPointY - 10, finalTransPointY + 22, finalTransPointY - 10,
              finalTransPointY + 22, finalTransPointY - 10, finalTransPointY);
      vibrateAnimator.setDuration(animationDuration * 5);
      vibrateAnimator.setStartDelay((long) (animationDuration * 0.9f));
      //            vibrateAnimator.setInterpolator(new DecelerateInterpolator());

      animatorSet.playTogether(mainAnimator, circleAnimator, vibrateAnimator);
      animatorSet.setStartDelay(animationStartDelay);
      animatorSet.start();
    }
  }

  public void hide(boolean hide) {
    if (hide) {
      scale = 0;
    } else {
      scale = 1;
    }
  }

  public void setDuration(int animationDuration) {
    this.animationDuration = animationDuration;
  }

  public void setColor1(int color1) {
    this.color1 = color1;
  }

  public void setColor2(int color2) {
    this.color2 = color2;
  }

  public void setStartDelay(int animationStartDelay) {
    this.animationStartDelay = animationStartDelay;
  }
}

