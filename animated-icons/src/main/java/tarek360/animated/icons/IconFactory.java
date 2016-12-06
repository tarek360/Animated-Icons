package tarek360.animated.icons;

import tarek360.animated.icons.drawables.Bin;
import tarek360.animated.icons.drawables.HorizontalArrow;
import tarek360.animated.icons.drawables.Like;
import tarek360.animated.icons.drawables.Location;
import tarek360.animated.icons.drawables.Mail;
import tarek360.animated.icons.drawables.NotificationAlert;
import tarek360.animated.icons.drawables.Settings;
import tarek360.animated.icons.drawables.VerticalArrow;

/**
 * Created by tarek on 11/23/16.
 */

public class IconFactory {

  public static Bin iconBin() {
    return new Bin();
  }

  public static VerticalArrow iconVerticalArrow() {
    return new VerticalArrow();
  }

  public static HorizontalArrow iconHorizontalArrow() {
    return new HorizontalArrow();
  }

  public static Like iconLike() {
    return new Like();
  }

  public static Location iconLocation() {
    return new Location();
  }

  public static Mail iconMail() {
    return new Mail();
  }

  public static Settings iconSettings() {
    return new Settings();
  }

  public static NotificationAlert iconNotificationAlert() {
    return new NotificationAlert();
  }
}
