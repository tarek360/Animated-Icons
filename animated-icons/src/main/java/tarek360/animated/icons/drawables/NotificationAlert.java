package tarek360.animated.icons.drawables;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.ColorInt;
import tarek360.animated.icons.drawers.NotificationAlertDrawer;

public class NotificationAlert extends AnimatedIcon {

  private NotificationAlertDrawer drawer;

  public NotificationAlert() {
    init();
  }

  private void init() {
    drawer = new NotificationAlertDrawer(new NotificationAlertDrawer.InvalidateListener() {
      @Override public void invalidate() {
        invalidateSelf();
      }
    });
  }

  @Override public void draw(Canvas canvas) {

    Rect bounds = getBounds();
    drawer.onSizeChanged(bounds.right, bounds.bottom, 0, 0);

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

  public int getNotificationCount() {
    return drawer.getNotificationCount();
  }

  public NotificationAlert setNotificationCount(int count) {
    drawer.setNotificationCount(count);
    return this;
  }
}

