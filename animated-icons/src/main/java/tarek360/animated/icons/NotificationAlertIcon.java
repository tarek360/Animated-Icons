package tarek360.animated.icons;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.view.View;

public class NotificationAlertIcon extends View {

  private Drawer drawer;

  public NotificationAlertIcon(Context context) {
    super(context);
    init();
  }

  public NotificationAlertIcon(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public NotificationAlertIcon(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    // prevent exception in Android Studio / ADT interface builder
    if (this.isInEditMode()) {
      return;
    }
    init();
  }

  private void init() {
    drawer = new Drawer(new Drawer.InvalidateListener() {
      @Override public void invalidate() {
        NotificationAlertIcon.this.invalidate();
      }
    });
  }

  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    drawer.onSizeChanged(w, h, oldw, oldh);
  }

  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);

    drawer.drawIcon(canvas);
  }

  public void startAnimation() {
    drawer.startAnimation();
  }


  /**
   * @param bellColor
   * @param countColor
   * @param counterBackgroundColor
   */
  public void setColors(@ColorInt int bellColor, @ColorInt int countColor,
      @ColorInt int counterBackgroundColor) {
    drawer.setColors(bellColor, countColor, counterBackgroundColor);
  }

  public void setNotificationCount(int count) {
    drawer.setNotificationCount(count);
  }
  public int getNotificationCount() {
    return drawer.getNotificationCount();
  }

  public void setRepeatCount(int repeatCount) {
    drawer.setRepeatCount(repeatCount);
  }
}
