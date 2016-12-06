package tarek360.animated.icons.drawables;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

public abstract class AnimatedIcon extends Drawable {

  @Override public void draw(Canvas canvas) {

  }

  @Override public void setAlpha(int alpha) {

  }

  @Override public void setColorFilter(ColorFilter cf) {

  }

  @Override public int getOpacity() {
    return 0;
  }

  public abstract void startAnimation();
}
