package tarek360.animated.icons.drawables;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Property;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;

public class Bin extends AnimatedIcon {
  private static final float[] VIEW_BOX = { 0.000000f, 0.000000f, 512.000000f, 512.000000f };
  float diff = -30;
  float endPoint = 0;
  private Path p = new Path();
  private Paint paint = new Paint();
  private int animationDuration = 200;
  private int color = Color.WHITE;
  private Interpolator interpolator;
  private float diffPointY = 0;
  private Property<Bin, Float> diffYProperty = new Property<Bin, Float>(Float.class, "point") {
    @Override public Float get(Bin object) {
      return object.diffPointY;
    }

    @Override public void set(Bin object, Float value) {
      object.diffPointY = value;
      invalidateSelf();
    }
  };

  public Bin() {
    interpolator = new OvershootInterpolator();
  }

  @Override public void draw(Canvas canvas) {
    paint.setAntiAlias(true);
    float viewBoxWidth = VIEW_BOX[2];
    float viewBoxHeight = VIEW_BOX[3];
    Rect bounds = getBounds();
    if (viewBoxHeight <= 0 || viewBoxWidth <= 0 || bounds.width() <= 0 || bounds.height() <= 0) {
      return;
    }
    canvas.save();
    float viewBoxRatio = viewBoxWidth / (float) viewBoxHeight;
    float boundsRatio = bounds.width() / (float) bounds.height();
    float factorScale;
    if (boundsRatio > viewBoxRatio) {
      // canvas larger than viewbox
      factorScale = bounds.height() / (float) viewBoxHeight;
    } else {
      // canvas higher (or equals) than viewbox
      factorScale = bounds.width() / (float) viewBoxWidth;
    }
    int newViewBoxHeight = Math.round(factorScale * viewBoxHeight);
    int newViewBoxWidth = Math.round(factorScale * viewBoxWidth);
    int marginX = bounds.width() - newViewBoxWidth;
    int marginY = bounds.height() - newViewBoxHeight;
    canvas.translate(bounds.left, bounds.top);
    canvas.translate(Math.round(marginX / 2f), Math.round(marginY / 2f));
    canvas.clipRect(0, 0, newViewBoxWidth, newViewBoxHeight);
    canvas.translate(-Math.round(factorScale * VIEW_BOX[0]),
        -Math.round(factorScale * VIEW_BOX[1]));
    paint.setAlpha(255);
    paint.setAlpha(255);
    paint.setAlpha(255);
    p.reset();
    p.moveTo(factorScale * 93.067001f, factorScale * 184.132996f);
    p.rLineTo(0, factorScale * 300.000000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 16.500000f, factorScale * 13.501000f,
        factorScale * 30.000000f, factorScale * 30.000000f, factorScale * 30.000000f);
    p.rLineTo(factorScale * 270.000000f, 0);
    p.rCubicTo(factorScale * 16.500000f, factorScale * 0.000000f, factorScale * 30.000000f,
        factorScale * -13.500000f, factorScale * 30.000000f, factorScale * -30.000000f);
    p.rLineTo(0, factorScale * -300.000000f);
    p.rLineTo(factorScale * -330.000000f, 0);
    p.close();
    p.moveTo(factorScale * 93.067001f, factorScale * 184.132996f);
    p.moveTo(factorScale * 183.065994f, factorScale * 454.134003f);
    p.rLineTo(factorScale * -30.000000f, 0);
    p.rLineTo(0, factorScale * -210.000000f);
    p.rLineTo(factorScale * 30.000000f, 0);
    p.rLineTo(0, factorScale * 210.000000f);
    p.close();
    p.moveTo(factorScale * 183.065994f, factorScale * 454.134003f);
    p.moveTo(factorScale * 243.065994f, factorScale * 454.134003f);
    p.rLineTo(factorScale * -30.000000f, 0);
    p.rLineTo(0, factorScale * -210.000000f);
    p.rLineTo(factorScale * 30.000000f, 0);
    p.rLineTo(0, factorScale * 210.000000f);
    p.close();
    p.moveTo(factorScale * 243.065994f, factorScale * 454.134003f);
    p.moveTo(factorScale * 303.066986f, factorScale * 454.134003f);
    p.rLineTo(factorScale * -30.000000f, 0);
    p.rLineTo(0, factorScale * -210.000000f);
    p.rLineTo(factorScale * 30.000000f, 0);
    p.rLineTo(0, factorScale * 210.000000f);
    p.close();
    p.moveTo(factorScale * 303.066986f, factorScale * 454.134003f);
    p.moveTo(factorScale * 363.066986f, factorScale * 454.134003f);
    p.rLineTo(factorScale * -30.000000f, 0);
    p.rLineTo(0, factorScale * -210.000000f);
    p.rLineTo(factorScale * 30.000000f, 0);
    p.rLineTo(0, factorScale * 210.000000f);

    p.close();
    p.moveTo(factorScale * 363.066986f, factorScale * 454.134003f);
    p.setFillType(Path.FillType.EVEN_ODD);
    paint.setShader(null);
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(color);
    canvas.drawPath(p, paint);
    paint.setAlpha(255);
    p.reset();
    p.moveTo(factorScale * 430.566986f, factorScale * 110.133003f + factorScale * diffPointY);
    p.rLineTo(factorScale * -97.500000f, 0);
    p.rLineTo(0, factorScale * -37.500999f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * -12.375000f, factorScale * -10.125000f,
        factorScale * -22.500999f, factorScale * -22.500000f, factorScale * -22.500999f);
    p.rLineTo(factorScale * -105.000000f, 0);
    p.rCubicTo(factorScale * -12.375000f, factorScale * 0.000000f, factorScale * -22.500000f,
        factorScale * 10.125000f, factorScale * -22.500000f, factorScale * 22.500999f);
    p.rLineTo(0, factorScale * 37.500999f);
    p.rLineTo(factorScale * -97.500999f, 0);
    p.rCubicTo(factorScale * -12.375000f, factorScale * 0.000000f, factorScale * -22.500999f,
        factorScale * 10.125000f, factorScale * -22.500999f, factorScale * 22.500000f);
    p.rLineTo(0, factorScale * 37.500999f);
    p.rLineTo(factorScale * 390.000000f, 0);
    p.rLineTo(0, factorScale * -37.500000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * -12.375000f, factorScale * -10.125000f,
        factorScale * -22.500999f, factorScale * -22.500000f, factorScale * -22.500999f);
    p.close();
    p.moveTo(factorScale * 430.566986f, factorScale * 110.133003f + factorScale * diffPointY);
    p.moveTo(factorScale * 303.066986f, factorScale * 110.133003f + factorScale * diffPointY);
    p.rLineTo(factorScale * -90.000000f, 0);
    p.rLineTo(0, factorScale * -29.624001f);
    p.rLineTo(factorScale * 90.000000f, 0);
    p.rLineTo(0, factorScale * 29.624001f);
    p.close();
    p.moveTo(factorScale * 303.066986f, factorScale * 110.133003f + factorScale * diffPointY);
    p.setFillType(Path.FillType.EVEN_ODD);
    paint.setShader(null);
    paint.setStyle(Paint.Style.FILL);
    paint.setColor(color);
    canvas.drawPath(p, paint);
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

    if (endPoint == diff) {
      endPoint = 0;
    } else {
      endPoint = diff;
    }
    ObjectAnimator animator =
        ObjectAnimator.ofFloat(this, diffYProperty, endPoint).setDuration(animationDuration);
    animator.setInterpolator(interpolator);
    animator.start();
  }

  public void setDuration(int animationDuration) {
    this.animationDuration = animationDuration;
  }

  public void setColor(int color) {
    this.color = color;
    invalidateSelf();
  }

  public void setInterpolator(Interpolator interpolator) {
    this.interpolator = interpolator;
  }
}

