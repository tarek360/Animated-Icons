package tarek360.animated.icons.drawables;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Property;

public class VerticalArrow extends AnimatedIcon {

  private float lineThickness = 6;
  private int animationDuration = 200;
  private int color = Color.WHITE;

  private float rightDirectionPoint = 56;
  private float LeftDirectionPoint = 8;
  private float endPoint = rightDirectionPoint;
  private float arrowPointY = rightDirectionPoint;
  private float factorScale;

  private float viewBoxWidth = 64;
  private float viewBoxHeight = 64;

  private Path p;
  private Paint paint;
  private Property<VerticalArrow, Float> arrowPointYProperty =
      new Property<VerticalArrow, Float>(Float.class, "point") {
        @Override public Float get(VerticalArrow object) {
          return object.arrowPointY;
        }

        @Override public void set(VerticalArrow object, Float value) {
          object.arrowPointY = value;
          invalidateSelf();
        }
      };

  public VerticalArrow() {
    p = new Path();
    paint = new Paint();
    paint.setAntiAlias(true);
    paint.setColor(color);
    paint.setStrokeCap(Paint.Cap.BUTT);
    paint.setStyle(Paint.Style.STROKE);
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
    paint.setStrokeWidth(factorScale * lineThickness);
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

    // 32.839713,56.901513
    // 0,-49.803026
    p.moveTo(factorScale * 32.0f, factorScale * 8);
    p.lineTo(factorScale * 32.0f, factorScale * 56.0f);

    canvas.drawPath(p, paint);

    p.reset();
    // 14.083963   33.258774
    // 32.85761    56.420652
    // 51.595463   33.258774
    p.moveTo(factorScale * 13.0f, factorScale * 32.0f);
    p.lineTo(factorScale * 32.0f, factorScale * arrowPointY);
    p.lineTo(factorScale * 51.0f, factorScale * 32.0f);

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

    if (endPoint == LeftDirectionPoint) {
      endPoint = rightDirectionPoint;
    } else {
      endPoint = LeftDirectionPoint;
    }
    ObjectAnimator.ofFloat(this, arrowPointYProperty, endPoint)
        .setDuration(animationDuration)
        .start();
  }

  public void setLineThickness(float lineThickness) {
    this.lineThickness = lineThickness;
  }

  public void setDuration(int animationDuration) {
    this.animationDuration = animationDuration;
  }

  public void setColor(int color) {
    this.color = color;
  }
}

