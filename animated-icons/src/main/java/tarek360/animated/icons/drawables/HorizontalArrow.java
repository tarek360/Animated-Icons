package tarek360.animated.icons.drawables;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Property;

public class HorizontalArrow extends AnimatedIcon {

  private float lineThickness = 6;
  private int animationDuration = 200;
  private int color = Color.WHITE;

  private float rightDirectionPoint = 56;
  private float LeftDirectionPoint = 8;
  private float endPoint = rightDirectionPoint;
  private float arrowPointX = rightDirectionPoint;
  private float factorScale;

  private float viewBoxWidth = 64;
  private float viewBoxHeight = 64;

  private Path p;
  private Paint paint;
  private Property<HorizontalArrow, Float> arrowPointXProperty =
      new Property<HorizontalArrow, Float>(Float.class, "point") {
        @Override public Float get(HorizontalArrow object) {
          return object.arrowPointX;
        }

        @Override public void set(HorizontalArrow object, Float value) {
          object.arrowPointX = value;
          invalidateSelf();
        }
      };

  public HorizontalArrow() {
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

    p.moveTo(factorScale * 8, factorScale * 32.000000f);
    p.lineTo(factorScale * 56, factorScale * 32.000000f);

    canvas.drawPath(p, paint);

    p.reset();
    p.moveTo(factorScale * 32.0f, factorScale * 13.0f);
    p.lineTo(factorScale * arrowPointX, factorScale * 32.000000f);
    p.lineTo(factorScale * 32.0f, factorScale * 51.0f);

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
    ObjectAnimator.ofFloat(this, arrowPointXProperty, endPoint)
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

