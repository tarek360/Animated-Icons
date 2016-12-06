package tarek360.animated.icons.drawables;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Property;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Interpolator;

public class Mail extends AnimatedIcon {

  private static final float[] VIEW_BOX = { 0.000000f, 0.000000f, 64.000000f, 64.000000f };
  private int animationDuration = 200;
  private int color = Color.WHITE;
  private Interpolator interpolator;
  private float openStatePoint = 0;
  private float closedStatePoint = 39.793998f;
  private float endPoint = closedStatePoint;
  private float mailPointY = closedStatePoint;
  private float factorScale;
  private Path p = new Path();
  private Paint paint = new Paint();
  private Property<Mail, Float> mailPointYProperty =
      new Property<Mail, Float>(Float.class, "point") {
        @Override public Float get(Mail object) {
          return object.mailPointY;
        }

        @Override public void set(Mail object, Float value) {
          object.mailPointY = value;
          invalidateSelf();
        }
      };

  @Override public void draw(Canvas canvas) {

    interpolator = new AccelerateInterpolator();
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
    p.reset();
    p.moveTo(factorScale * 61.693001f, factorScale * 19.895999f);
    p.lineTo(factorScale * 2.307000f, factorScale * 19.895999f); //-3.112f // 39.793998f
    p.lineTo(factorScale * 32.000000f, factorScale * mailPointY);
    p.close();

    paint.setColor(color);
    paint.setStyle(Paint.Style.FILL);
    canvas.drawPath(p, paint);

    p.reset();
    p.moveTo(factorScale * 61.693001f, factorScale * 22.10f);
    p.lineTo(factorScale * 61.693001f, factorScale * 55.09f);
    p.lineTo(factorScale * 2.307000f, factorScale * 55.09f);
    p.lineTo(factorScale * 2.307000f, factorScale * 22.10f);
    p.lineTo(factorScale * 32.000000f, factorScale * 42.29f);
    p.close();

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

    if (endPoint == openStatePoint) {
      endPoint = closedStatePoint;
    } else {
      endPoint = openStatePoint;
    }
    ObjectAnimator animator =
        ObjectAnimator.ofFloat(this, mailPointYProperty, endPoint).setDuration(animationDuration);
    animator.setInterpolator(interpolator);
    animator.start();
  }

  public void setDuration(int animationDuration) {
    this.animationDuration = animationDuration;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public void setInterpolator(Interpolator interpolator) {
    this.interpolator = interpolator;
  }
}
