package tarek360.animated.icons;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import tarek360.animated.icons.drawables.AnimatedIcon;

public class AnimatedIconView extends ImageView {

  private AnimatedIcon animatedIcon;

  public AnimatedIconView(Context context) {
    super(context);
    init();
  }

  public AnimatedIconView(Context context, AttributeSet attrs) {
    super(context, attrs);
    init();
  }

  public AnimatedIconView(Context context, AttributeSet attrs, int defStyle) {
    super(context, attrs, defStyle);

    // prevent exception in Android Studio / ADT interface builder
    if (this.isInEditMode()) {
      return;
    }
    init();
  }

  private void init() {

  }

  public void setAnimatedIcon(AnimatedIcon animatedIcon) {
    setImageDrawable(animatedIcon);
    this.animatedIcon = animatedIcon;
  }

  public void startAnimation() {
    animatedIcon.startAnimation();
  }
}
