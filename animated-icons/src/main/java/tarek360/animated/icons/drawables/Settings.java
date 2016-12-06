package tarek360.animated.icons.drawables;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;
import android.util.Property;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

public class Settings extends AnimatedIcon {

  private static final String TAG = Settings.class.getSimpleName();
  private static final float[] VIEW_BOX = { 0.0f, 0.0f, 512.0f, 512.0f };
  private final static float ANIMATION_DEGREE = 180;
  float factorScale;
  private int animationDuration;
  private int color1;
  private int color2;
  private Interpolator interpolator;
  private Path p = new Path();
  private Paint paint = new Paint();
  private float animationDegree;
  private AnimationType animationType;
  private float degree = 0;
  private Property<Settings, Float> degreeProperty =
      new Property<Settings, Float>(Float.class, "point") {
        @Override public Float get(Settings object) {
          return object.degree;
        }

        @Override public void set(Settings object, Float value) {
          Log.i("degree", "degree = " + degree);
          object.degree = value;
          invalidateSelf();
        }
      };

  public Settings() {
    animationDuration = 1500;
    animationDegree = ANIMATION_DEGREE;
    color1 = Color.WHITE;
    color2 = Color.WHITE;

    p = new Path();
    paint = new Paint();
    paint.setAntiAlias(true);

    animationType = AnimationType.BOUNCE;
    interpolator = new DecelerateInterpolator();
  }

  @Override public void draw(Canvas canvas) {

    float viewBoxWidth = VIEW_BOX[2];
    float viewBoxHeight = VIEW_BOX[3];
    Rect bounds = getBounds();
    if (viewBoxHeight <= 0 || viewBoxWidth <= 0 || bounds.width() <= 0 || bounds.height() <= 0) {
      return;
    }
    canvas.save();
    float viewBoxRatio = viewBoxWidth / viewBoxHeight;
    float boundsRatio = bounds.width() / (float) bounds.height();
    if (boundsRatio > viewBoxRatio) {
      // canvas larger than viewbox
      factorScale = bounds.height() / viewBoxHeight;
    } else {
      // canvas higher (or equals) than viewbox
      factorScale = bounds.width() / viewBoxWidth;
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

    canvas.save();

    canvas.rotate(degree, factorScale * 185.34f, factorScale * 185.49f);
    drawFirst(canvas); // big red

    canvas.restore();
    canvas.save();

    canvas.rotate(-degree * 1.5f, factorScale * 374.4f, factorScale * 376.19f);
    drawSecond(canvas); // small black

    canvas.restore();
  }

  private void drawFirst(Canvas canvas) {

    p.reset();
    p.moveTo(factorScale * 42.167999f, factorScale * 164.438004f);
    p.rCubicTo(factorScale * 11.052000f, factorScale * 0.043000f, factorScale * 11.012000f,
        factorScale * 0.033000f, factorScale * 13.798000f, factorScale * -10.870000f);
    p.rCubicTo(factorScale * 0.975000f, factorScale * -3.813000f, factorScale * 1.917000f,
        factorScale * -7.678000f, factorScale * 3.393000f, factorScale * -11.308000f);
    p.rCubicTo(factorScale * 1.462000f, factorScale * -3.596000f, factorScale * 0.398000f,
        factorScale * -5.483000f, factorScale * -2.858000f, factorScale * -7.114000f);
    p.rCubicTo(factorScale * -3.797000f, factorScale * -1.902000f, factorScale * -7.450000f,
        factorScale * -4.120000f, factorScale * -11.047000f, factorScale * -6.387000f);
    p.rCubicTo(factorScale * -10.525000f, factorScale * -6.633000f, factorScale * -13.629000f,
        factorScale * -18.959999f, factorScale * -7.436000f, factorScale * -29.160999f);
    p.rCubicTo(factorScale * 5.995000f, factorScale * -9.876000f, factorScale * 18.294001f,
        factorScale * -12.778000f, factorScale * 28.983999f, factorScale * -6.791000f);
    p.rCubicTo(factorScale * 3.850000f, factorScale * 2.156000f, factorScale * 7.689000f,
        factorScale * 4.343000f, factorScale * 11.432000f, factorScale * 6.677000f);
    p.rCubicTo(factorScale * 2.234000f, factorScale * 1.393000f, factorScale * 3.824000f,
        factorScale * 1.426000f, factorScale * 5.631000f, factorScale * -0.815000f);
    p.rCubicTo(factorScale * 4.360000f, factorScale * -5.410000f, factorScale * 9.300000f,
        factorScale * -10.298000f, factorScale * 14.694000f, factorScale * -14.682000f);
    p.rCubicTo(factorScale * 1.997000f, factorScale * -1.623000f, factorScale * 2.187000f,
        factorScale * -3.100000f, factorScale * 0.902000f, factorScale * -5.245000f);

    p.rCubicTo(factorScale * -2.590000f, factorScale * -4.325000f, factorScale * -5.193000f,
        factorScale * -8.662000f, factorScale * -7.445000f, factorScale * -13.167000f);
    p.rCubicTo(factorScale * -5.387000f, factorScale * -10.775000f, factorScale * -1.863000f,
        factorScale * -22.417999f, factorScale * 8.321000f, factorScale * -28.153999f);
    p.rCubicTo(factorScale * 9.697000f, factorScale * -5.462000f, factorScale * 21.701000f,
        factorScale * -2.219000f, factorScale * 28.000999f, factorScale * 7.708000f);
    p.rCubicTo(factorScale * 2.616000f, factorScale * 4.122000f, factorScale * 4.992000f,
        factorScale * 8.401000f, factorScale * 7.364000f, factorScale * 12.671000f);
    p.rCubicTo(factorScale * 1.208000f, factorScale * 2.175000f, factorScale * 2.625000f,
        factorScale * 2.695000f, factorScale * 5.037000f, factorScale * 1.831000f);
    p.rCubicTo(factorScale * 6.234000f, factorScale * -2.235000f, factorScale * 12.627000f,
        factorScale * -3.994000f, factorScale * 19.148001f, factorScale * -5.167000f);
    p.rCubicTo(factorScale * 3.159000f, factorScale * -0.568000f, factorScale * 4.613000f,
        factorScale * -1.928000f, factorScale * 4.403000f, factorScale * -5.355000f);
    p.rCubicTo(factorScale * -0.278000f, factorScale * -4.555000f, factorScale * -0.162000f,
        factorScale * -9.142000f, factorScale * -0.060000f, factorScale * -13.711000f);
    p.rCubicTo(factorScale * 0.235000f, factorScale * -10.538000f, factorScale * 8.117000f,
        factorScale * -19.344000f, factorScale * 18.122000f, factorScale * -20.368000f);
    p.rCubicTo(factorScale * 11.421000f, factorScale * -1.169000f, factorScale * 20.596001f,
        factorScale * 5.355000f, factorScale * 23.094000f, factorScale * 16.403999f);
    p.rCubicTo(factorScale * 1.304000f, factorScale * 5.770000f, factorScale * 0.690000f,
        factorScale * 11.629000f, factorScale * 0.696000f, factorScale * 17.441999f);
    p.rCubicTo(factorScale * 0.004000f, factorScale * 3.452000f, factorScale * 1.171000f,
        factorScale * 5.209000f, factorScale * 4.636000f, factorScale * 5.788000f);
    p.rCubicTo(factorScale * 6.069000f, factorScale * 1.013000f, factorScale * 12.035000f,
        factorScale * 2.581000f, factorScale * 17.778999f, factorScale * 4.777000f);
    p.rCubicTo(factorScale * 3.243000f, factorScale * 1.240000f, factorScale * 4.940000f,
        factorScale * 0.177000f, factorScale * 6.424000f, factorScale * -2.636000f);
    p.rCubicTo(factorScale * 2.059000f, factorScale * -3.900000f, factorScale * 4.312000f,
        factorScale * -7.704000f, factorScale * 6.622000f, factorScale * -11.463000f);
    p.rCubicTo(factorScale * 6.344000f, factorScale * -10.325000f, factorScale * 18.413000f,
        factorScale * -13.469000f, factorScale * 28.747999f, factorScale * -7.561000f);
    p.rCubicTo(factorScale * 9.690000f, factorScale * 5.538000f, factorScale * 13.056000f,
        factorScale * 17.525999f, factorScale * 7.691000f, factorScale * 27.948000f);
    p.rCubicTo(factorScale * -2.234000f, factorScale * 4.340000f, factorScale * -4.715000f,
        factorScale * 8.563000f, factorScale * -7.272000f, factorScale * 12.724000f);
    p.rCubicTo(factorScale * -1.405000f, factorScale * 2.285000f, factorScale * -1.231000f,
        factorScale * 3.820000f, factorScale * 0.857000f, factorScale * 5.648000f);
    p.rCubicTo(factorScale * 5.219000f, factorScale * 4.570000f, factorScale * 10.214000f,
        factorScale * 9.407000f, factorScale * 14.604000f, factorScale * 14.793000f);
    p.rCubicTo(factorScale * 1.708000f, factorScale * 2.096000f, factorScale * 3.270000f,
        factorScale * 1.924000f, factorScale * 5.293000f, factorScale * 0.723000f);
    p.rCubicTo(factorScale * 3.930000f, factorScale * -2.333000f, factorScale * 7.871000f,
        factorScale * -4.656000f, factorScale * 11.894000f, factorScale * -6.823000f);

    p.rCubicTo(factorScale * 11.094000f, factorScale * -5.977000f, factorScale * 23.379000f,
        factorScale * -2.793000f, factorScale * 29.125000f, factorScale * 7.465000f);
    p.rCubicTo(factorScale * 5.829000f, factorScale * 10.407000f, factorScale * 2.353000f,
        factorScale * 22.414000f, factorScale * -8.388000f, factorScale * 28.900000f);
    p.rCubicTo(factorScale * -3.913000f, factorScale * 2.363000f, factorScale * -7.802000f,
        factorScale * 4.774000f, factorScale * -11.806000f, factorScale * 6.973000f);
    p.rCubicTo(factorScale * -2.229000f, factorScale * 1.225000f, factorScale * -2.728000f,
        factorScale * 2.670000f, factorScale * -1.843000f, factorScale * 5.009000f);
    p.rCubicTo(factorScale * 2.401000f, factorScale * 6.350000f, factorScale * 4.280000f,
        factorScale * 12.874000f, factorScale * 5.350000f, factorScale * 19.576000f);
    p.rCubicTo(factorScale * 0.493000f, factorScale * 3.086000f, factorScale * 2.134000f,
        factorScale * 3.800000f, factorScale * 4.868000f, factorScale * 3.741000f);
    p.rCubicTo(factorScale * 4.412000f, factorScale * -0.095000f, factorScale * 8.828000f,
        factorScale * -0.030000f, factorScale * 13.242000f, factorScale * 0.021000f);
    p.rCubicTo(factorScale * 12.056000f, factorScale * 0.138000f, factorScale * 21.433001f,
        factorScale * 9.366000f, factorScale * 21.547001f, factorScale * 21.176001f);
    p.rCubicTo(factorScale * 0.106000f, factorScale * 10.916000f, factorScale * -9.460000f,
        factorScale * 20.448999f, factorScale * -21.055000f, factorScale * 20.834999f);
    p.rCubicTo(factorScale * -4.724000f, factorScale * 0.157000f, factorScale * -9.460000f,
        factorScale * 0.101000f, factorScale * -14.187000f, factorScale * -0.007000f);
    p.rCubicTo(factorScale * -2.662000f, factorScale * -0.061000f, factorScale * -3.922000f,
        factorScale * 0.928000f, factorScale * -4.441000f, factorScale * 3.658000f);
    p.rCubicTo(factorScale * -1.264000f, factorScale * 6.658000f, factorScale * -2.932000f,
        factorScale * 13.240000f, factorScale * -5.293000f, factorScale * 19.604000f);
    p.rCubicTo(factorScale * -0.964000f, factorScale * 2.599000f, factorScale * -0.261000f,
        factorScale * 4.037000f, factorScale * 2.104000f, factorScale * 5.312000f);
    p.rCubicTo(factorScale * 4.298000f, factorScale * 2.317000f, factorScale * 8.551000f,
        factorScale * 4.747000f, factorScale * 12.658000f, factorScale * 7.385000f);
    p.rCubicTo(factorScale * 9.906000f, factorScale * 6.361000f, factorScale * 12.858000f,
        factorScale * 18.579000f, factorScale * 7.051000f, factorScale * 28.566999f);
    p.rCubicTo(factorScale * -5.641000f, factorScale * 9.702000f, factorScale * -17.632999f,
        factorScale * 13.024000f, factorScale * -28.028999f, factorScale * 7.618000f);
    p.rCubicTo(factorScale * -4.331000f, factorScale * -2.252000f, factorScale * -8.529000f,
        factorScale * -4.770000f, factorScale * -12.724000f, factorScale * -7.273000f);
    p.rCubicTo(factorScale * -2.290000f, factorScale * -1.366000f, factorScale * -3.851000f,
        factorScale * -1.072000f, factorScale * -5.634000f, factorScale * 1.067000f);
    p.rCubicTo(factorScale * -4.343000f, factorScale * 5.210000f, factorScale * -9.100000f,
        factorScale * 10.075000f, factorScale * -14.418000f, factorScale * 14.295000f);
    p.rCubicTo(factorScale * -2.283000f, factorScale * 1.812000f, factorScale * -2.228000f,
        factorScale * 3.366000f, factorScale * -0.887000f, factorScale * 5.601000f);
    p.rCubicTo(factorScale * 2.593000f, factorScale * 4.324000f, factorScale * 5.220000f,
        factorScale * 8.647000f, factorScale * 7.473000f, factorScale * 13.151000f);
    p.rCubicTo(factorScale * 5.206000f, factorScale * 10.407000f, factorScale * 1.605000f,
        factorScale * 22.285000f, factorScale * -8.225000f, factorScale * 27.823999f);

    p.rCubicTo(factorScale * -9.968000f, factorScale * 5.617000f, factorScale * -21.625000f,
        factorScale * 2.622000f, factorScale * -28.041000f, factorScale * -7.363000f);
    p.rCubicTo(factorScale * -2.638000f, factorScale * -4.106000f, factorScale * -5.030000f,
        factorScale * -8.378000f, factorScale * -7.381000f, factorScale * -12.658000f);
    p.rCubicTo(factorScale * -1.309000f, factorScale * -2.383000f, factorScale * -2.907000f,
        factorScale * -2.886000f, factorScale * -5.448000f, factorScale * -1.996000f);
    p.rCubicTo(factorScale * -6.249000f, factorScale * 2.189000f, factorScale * -12.604000f,
        factorScale * 4.050000f, factorScale * -19.148001f, factorScale * 5.164000f);
    p.rCubicTo(factorScale * -2.922000f, factorScale * 0.498000f, factorScale * -3.681000f,
        factorScale * 2.330000f, factorScale * -3.749000f, factorScale * 5.060000f);
    p.rCubicTo(factorScale * -0.141000f, factorScale * 5.658000f, factorScale * 0.621000f,
        factorScale * 11.343000f, factorScale * -0.533000f, factorScale * 16.976999f);
    p.rCubicTo(factorScale * -2.308000f, factorScale * 11.274000f, factorScale * -11.856000f,
        factorScale * 18.617001f, factorScale * -22.841999f, factorScale * 17.506001f);
    p.rCubicTo(factorScale * -10.757000f, factorScale * -1.088000f, factorScale * -18.469000f,
        factorScale * -10.002000f, factorScale * -18.538000f, factorScale * -21.443001f);
    p.rCubicTo(factorScale * -0.026000f, factorScale * -4.414000f, factorScale * -0.131000f,
        factorScale * -8.832000f, factorScale * 0.001000f, factorScale * -13.242000f);
    p.rCubicTo(factorScale * 0.085000f, factorScale * -2.833000f, factorScale * -0.899000f,
        factorScale * -4.441000f, factorScale * -3.817000f, factorScale * -4.897000f);
    p.rCubicTo(factorScale * -6.558000f, factorScale * -1.025000f, factorScale * -12.943000f,
        factorScale * -2.804000f, factorScale * -19.173000f, factorScale * -5.050000f);
    p.rCubicTo(factorScale * -2.786000f, factorScale * -1.004000f, factorScale * -4.467000f,
        factorScale * -0.289000f, factorScale * -5.839000f, factorScale * 2.171000f);
    p.rCubicTo(factorScale * -2.149000f, factorScale * 3.854000f, factorScale * -4.349000f,
        factorScale * 7.684000f, factorScale * -6.660000f, factorScale * 11.442000f);
    p.rCubicTo(factorScale * -6.911000f, factorScale * 11.243000f, factorScale * -18.808001f,
        factorScale * 14.299000f, factorScale * -29.728001f, factorScale * 7.706000f);
    p.rCubicTo(factorScale * -9.646000f, factorScale * -5.824000f, factorScale * -12.368000f,
        factorScale * -18.403999f, factorScale * -6.291000f, factorScale * -29.135000f);
    p.rCubicTo(factorScale * 2.097000f, factorScale * -3.703000f, factorScale * 4.131000f,
        factorScale * -7.447000f, factorScale * 6.376000f, factorScale * -11.059000f);
    p.rCubicTo(factorScale * 1.514000f, factorScale * -2.437000f, factorScale * 1.354000f,
        factorScale * -4.261000f, factorScale * -0.953000f, factorScale * -6.094000f);
    p.rCubicTo(factorScale * -5.076000f, factorScale * -4.034000f, factorScale * -9.659000f,
        factorScale * -8.603000f, factorScale * -13.665000f, factorScale * -13.700000f);
    p.rCubicTo(factorScale * -2.105000f, factorScale * -2.679000f, factorScale * -4.188000f,
        factorScale * -2.669000f, factorScale * -6.905000f, factorScale * -0.985000f);
    p.rCubicTo(factorScale * -4.016000f, factorScale * 2.489000f, factorScale * -8.094000f,
        factorScale * 4.915000f, factorScale * -12.312000f, factorScale * 7.036000f);
    p.rCubicTo(factorScale * -10.245000f, factorScale * 5.151000f, factorScale * -22.315001f,
        factorScale * 1.662000f, factorScale * -27.572001f, factorScale * -7.788000f);
    p.rCubicTo(factorScale * -5.920000f, factorScale * -10.641000f, factorScale * -2.918000f,
        factorScale * -22.440001f, factorScale * 7.401000f, factorScale * -28.785000f);

    p.rCubicTo(factorScale * 3.893000f, factorScale * -2.394000f, factorScale * 7.844000f,
        factorScale * -4.702000f, factorScale * 11.858000f, factorScale * -6.885000f);
    p.rCubicTo(factorScale * 2.630000f, factorScale * -1.430000f, factorScale * 3.554000f,
        factorScale * -3.074000f, factorScale * 2.380000f, factorScale * -6.102000f);
    p.rCubicTo(factorScale * -2.337000f, factorScale * -6.031000f, factorScale * -3.978000f,
        factorScale * -12.291000f, factorScale * -5.056000f, factorScale * -18.679001f);
    p.rCubicTo(factorScale * -0.462000f, factorScale * -2.742000f, factorScale * -1.786000f,
        factorScale * -4.106000f, factorScale * -4.764000f, factorScale * -4.000000f);
    p.rCubicTo(factorScale * -4.408000f, factorScale * 0.158000f, factorScale * -8.828000f,
        factorScale * 0.052000f, factorScale * -13.241000f, factorScale * -0.014000f);
    p.rCubicTo(factorScale * -12.354000f, factorScale * -0.185000f, factorScale * -21.499001f,
        factorScale * -9.170000f, factorScale * -21.490999f, factorScale * -21.070999f);
    p.rCubicTo(factorScale * 0.008000f, factorScale * -11.937000f, factorScale * 9.123000f,
        factorScale * -20.823000f, factorScale * 21.518999f, factorScale * -20.966999f);
    p.cubicTo(factorScale * 38.383999f, factorScale * 164.419006f, factorScale * 40.276001f,
        factorScale * 164.438004f, factorScale * 42.167999f, factorScale * 164.438004f);
    p.close();
    p.moveTo(factorScale * 42.167999f, factorScale * 164.438004f);
    p.moveTo(factorScale * 283.772003f, factorScale * 185.623993f);
    p.rCubicTo(factorScale * 0.713000f, factorScale * -52.366001f, factorScale * -41.918999f,
        factorScale * -99.487999f, factorScale * -100.019997f, factorScale * -99.183998f);
    p.rCubicTo(factorScale * -53.327999f, factorScale * 0.279000f, factorScale * -97.678001f,
        factorScale * 45.424000f, factorScale * -97.300003f, factorScale * 99.239998f);
    p.rCubicTo(factorScale * 0.378000f, factorScale * 53.806999f, factorScale * 42.730000f,
        factorScale * 99.177002f, factorScale * 99.704002f, factorScale * 98.572998f);
    p.cubicTo(factorScale * 244.278000f, factorScale * 283.638000f, factorScale * 284.162994f,
        factorScale * 236.335999f, factorScale * 283.772003f, factorScale * 185.623993f);
    p.close();
    p.moveTo(factorScale * 283.772003f, factorScale * 185.623993f);
    p.setFillType(Path.FillType.EVEN_ODD);

    paint.setColor(color1);
    paint.setStyle(Paint.Style.FILL);

    canvas.drawPath(p, paint);
  }

  private void drawSecond(Canvas canvas) {
    p.reset();
    p.moveTo(factorScale * 394.660004f, factorScale * 277.920990f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 1.734000f, factorScale * 0.036000f,
        factorScale * 3.468000f, factorScale * -0.009000f, factorScale * 5.200000f);
    p.rCubicTo(factorScale * -0.062000f, factorScale * 2.415000f, factorScale * 1.049000f,
        factorScale * 3.754000f, factorScale * 3.414000f, factorScale * 4.349000f);
    p.rCubicTo(factorScale * 8.470000f, factorScale * 2.130000f, factorScale * 16.382000f,
        factorScale * 5.638000f, factorScale * 23.823000f, factorScale * 10.166000f);
    p.rCubicTo(factorScale * 2.345000f, factorScale * 1.427000f, factorScale * 3.987000f,
        factorScale * 1.003000f, factorScale * 5.807000f, factorScale * -0.832000f);
    p.rCubicTo(factorScale * 3.103000f, factorScale * -3.129000f, factorScale * 6.164000f,
        factorScale * -6.356000f, factorScale * 9.608000f, factorScale * -9.081000f);
    p.rCubicTo(factorScale * 7.911000f, factorScale * -6.259000f, factorScale * 18.789000f,
        factorScale * -5.201000f, factorScale * 25.615999f, factorScale * 2.196000f);
    p.rCubicTo(factorScale * 6.611000f, factorScale * 7.163000f, factorScale * 6.806000f,
        factorScale * 17.995001f, factorScale * 0.261000f, factorScale * 25.423000f);

    p.rCubicTo(factorScale * -2.912000f, factorScale * 3.305000f, factorScale * -6.118000f,
        factorScale * 6.361000f, factorScale * -9.301000f, factorScale * 9.415000f);
    p.rCubicTo(factorScale * -1.514000f, factorScale * 1.452000f, factorScale * -1.683000f,
        factorScale * 2.702000f, factorScale * -0.590000f, factorScale * 4.525000f);
    p.rCubicTo(factorScale * 4.645000f, factorScale * 7.750000f, factorScale * 8.158000f,
        factorScale * 16.006001f, factorScale * 10.222000f, factorScale * 24.809999f);
    p.rCubicTo(factorScale * 0.633000f, factorScale * 2.698000f, factorScale * 2.039000f,
        factorScale * 3.487000f, factorScale * 4.625000f, factorScale * 3.535000f);
    p.rCubicTo(factorScale * 4.558000f, factorScale * 0.085000f, factorScale * 9.137000f,
        factorScale * -0.374000f, factorScale * 13.676000f, factorScale * 0.492000f);
    p.rCubicTo(factorScale * 9.879000f, factorScale * 1.884000f, factorScale * 16.249001f,
        factorScale * 9.410000f, factorScale * 16.155001f, factorScale * 19.174999f);
    p.rCubicTo(factorScale * -0.093000f, factorScale * 9.720000f, factorScale * -6.751000f,
        factorScale * 17.101000f, factorScale * -16.663000f, factorScale * 18.684999f);
    p.rCubicTo(factorScale * -4.400000f, factorScale * 0.703000f, factorScale * -8.808000f,
        factorScale * 0.427000f, factorScale * -13.211000f, factorScale * 0.483000f);
    p.rCubicTo(factorScale * -2.801000f, factorScale * 0.036000f, factorScale * -4.298000f,
        factorScale * 1.121000f, factorScale * -5.051000f, factorScale * 3.854000f);
    p.rCubicTo(factorScale * -2.270000f, factorScale * 8.239000f, factorScale * -5.463000f,
        factorScale * 16.117001f, factorScale * -10.022000f, factorScale * 23.375000f);
    p.rCubicTo(factorScale * -1.413000f, factorScale * 2.249000f, factorScale * -1.287000f,
        factorScale * 3.964000f, factorScale * 0.686000f, factorScale * 5.796000f);
    p.rCubicTo(factorScale * 2.654000f, factorScale * 2.465000f, factorScale * 5.174000f,
        factorScale * 5.079000f, factorScale * 7.673000f, factorScale * 7.703000f);
    p.rCubicTo(factorScale * 7.414000f, factorScale * 7.785000f, factorScale * 7.308000f,
        factorScale * 19.764000f, factorScale * -0.200000f, factorScale * 27.285999f);
    p.rCubicTo(factorScale * -7.264000f, factorScale * 7.277000f, factorScale * -19.063999f,
        factorScale * 7.195000f, factorScale * -26.886999f, factorScale * -0.142000f);
    p.rCubicTo(factorScale * -3.436000f, factorScale * -3.223000f, factorScale * -6.030000f,
        factorScale * -8.312000f, factorScale * -10.397000f, factorScale * -9.299000f);
    p.rCubicTo(factorScale * -4.273000f, factorScale * -0.966000f, factorScale * -7.980000f,
        factorScale * 3.704000f, factorScale * -12.224000f, factorScale * 5.328000f);
    p.rCubicTo(factorScale * -4.860000f, factorScale * 1.859000f, factorScale * -9.651000f,
        factorScale * 3.937000f, factorScale * -14.750000f, factorScale * 4.998000f);
    p.rCubicTo(factorScale * -3.098000f, factorScale * 0.645000f, factorScale * -4.130000f,
        factorScale * 2.250000f, factorScale * -4.001000f, factorScale * 5.259000f);
    p.rCubicTo(factorScale * 0.156000f, factorScale * 3.617000f, factorScale * 0.113000f,
        factorScale * 7.253000f, factorScale * -0.049000f, factorScale * 10.871000f);
    p.rCubicTo(factorScale * -0.480000f, factorScale * 10.726000f, factorScale * -8.759000f,
        factorScale * 18.504000f, factorScale * -19.459000f, factorScale * 18.396000f);
    p.rCubicTo(factorScale * -10.306000f, factorScale * -0.104000f, factorScale * -18.379999f,
        factorScale * -8.095000f, factorScale * -18.743000f, factorScale * -18.646000f);
    p.rCubicTo(factorScale * -0.130000f, factorScale * -3.779000f, factorScale * -0.184000f,
        factorScale * -7.569000f, factorScale * -0.034000f, factorScale * -11.345000f);

    p.rCubicTo(factorScale * 0.104000f, factorScale * -2.626000f, factorScale * -0.814000f,
        factorScale * -4.095000f, factorScale * -3.416000f, factorScale * -4.760000f);
    p.rCubicTo(factorScale * -8.765000f, factorScale * -2.238000f, factorScale * -16.980000f,
        factorScale * -5.831000f, factorScale * -24.683001f, factorScale * -10.552000f);
    p.rCubicTo(factorScale * -1.992000f, factorScale * -1.221000f, factorScale * -3.443000f,
        factorScale * -0.931000f, factorScale * -4.985000f, factorScale * 0.670000f);
    p.rCubicTo(factorScale * -2.623000f, factorScale * 2.724000f, factorScale * -5.297000f,
        factorScale * 5.403000f, factorScale * -8.033000f, factorScale * 8.013000f);
    p.rCubicTo(factorScale * -7.334000f, factorScale * 6.997000f, factorScale * -18.121000f,
        factorScale * 7.405000f, factorScale * -25.798000f, factorScale * 1.031000f);
    p.rCubicTo(factorScale * -7.601000f, factorScale * -6.311000f, factorScale * -8.941000f,
        factorScale * -17.080000f, factorScale * -3.146000f, factorScale * -25.593000f);
    p.rCubicTo(factorScale * 2.594000f, factorScale * -3.811000f, factorScale * 6.050000f,
        factorScale * -6.856000f, factorScale * 9.376000f, factorScale * -9.969000f);
    p.rCubicTo(factorScale * 2.355000f, factorScale * -2.204000f, factorScale * 2.840000f,
        factorScale * -4.071000f, factorScale * 1.011000f, factorScale * -6.911000f);
    p.rCubicTo(factorScale * -4.392000f, factorScale * -6.816000f, factorScale * -7.261000f,
        factorScale * -14.365000f, factorScale * -9.110000f, factorScale * -22.204000f);
    p.rCubicTo(factorScale * -0.924000f, factorScale * -3.918000f, factorScale * -2.785000f,
        factorScale * -5.163000f, factorScale * -6.563000f, factorScale * -4.858000f);
    p.rCubicTo(factorScale * -3.130000f, factorScale * 0.253000f, factorScale * -6.304000f,
        factorScale * 0.115000f, factorScale * -9.451000f, factorScale * -0.024000f);
    p.rCubicTo(factorScale * -10.536000f, factorScale * -0.466000f, factorScale * -19.049000f,
        factorScale * -9.092000f, factorScale * -19.013000f, factorScale * -19.176001f);
    p.rCubicTo(factorScale * 0.039000f, factorScale * -10.776000f, factorScale * 8.267000f,
        factorScale * -18.878000f, factorScale * 19.403000f, factorScale * -19.066999f);
    p.rCubicTo(factorScale * 3.624000f, factorScale * -0.062000f, factorScale * 7.252000f,
        factorScale * -0.129000f, factorScale * 10.874000f, factorScale * -0.020000f);
    p.rCubicTo(factorScale * 2.633000f, factorScale * 0.079000f, factorScale * 3.990000f,
        factorScale * -0.927000f, factorScale * 4.632000f, factorScale * -3.570000f);
    p.rCubicTo(factorScale * 2.062000f, factorScale * -8.489000f, factorScale * 5.715000f,
        factorScale * -16.356001f, factorScale * 10.129000f, factorScale * -23.846001f);
    p.rCubicTo(factorScale * 1.434000f, factorScale * -2.434000f, factorScale * 1.568000f,
        factorScale * -4.097000f, factorScale * -0.703000f, factorScale * -6.075000f);
    p.rCubicTo(factorScale * -2.726000f, factorScale * -2.374000f, factorScale * -5.207000f,
        factorScale * -5.045000f, factorScale * -7.663000f, factorScale * -7.708000f);
    p.rCubicTo(factorScale * -7.455000f, factorScale * -8.083000f, factorScale * -7.285000f,
        factorScale * -19.947001f, factorScale * 0.320000f, factorScale * -27.233999f);
    p.rCubicTo(factorScale * 7.735000f, factorScale * -7.411000f, factorScale * 19.247999f,
        factorScale * -7.180000f, factorScale * 27.159000f, factorScale * 0.561000f);
    p.rCubicTo(factorScale * 2.478000f, factorScale * 2.425000f, factorScale * 5.043000f,
        factorScale * 4.778000f, factorScale * 7.338000f, factorScale * 7.368000f);
    p.rCubicTo(factorScale * 1.875000f, factorScale * 2.115000f, factorScale * 3.515000f,
        factorScale * 2.556000f, factorScale * 6.070000f, factorScale * 0.982000f);

    p.rCubicTo(factorScale * 7.287000f, factorScale * -4.489000f, factorScale * 15.145000f,
        factorScale * -7.747000f, factorScale * 23.480000f, factorScale * -9.723000f);
    p.rCubicTo(factorScale * 3.004000f, factorScale * -0.712000f, factorScale * 4.059000f,
        factorScale * -2.309000f, factorScale * 3.982000f, factorScale * -5.341000f);
    p.rCubicTo(factorScale * -0.112000f, factorScale * -4.398000f, factorScale * -0.268000f,
        factorScale * -8.818000f, factorScale * 0.559000f, factorScale * -13.199000f);
    p.rCubicTo(factorScale * 1.786000f, factorScale * -9.470000f, factorScale * 9.493000f,
        factorScale * -16.164000f, factorScale * 18.754000f, factorScale * -16.198999f);
    p.rCubicTo(factorScale * 9.479000f, factorScale * -0.036000f, factorScale * 17.330999f,
        factorScale * 6.747000f, factorScale * 18.892000f, factorScale * 16.489000f);
    p.rCubicTo(factorScale * 0.471000f, factorScale * 2.942000f, factorScale * 0.546000f,
        factorScale * 5.947000f, factorScale * 0.802000f, factorScale * 8.924000f);
    p.cubicTo(factorScale * 394.789001f, factorScale * 277.911011f, factorScale * 394.723999f,
        factorScale * 277.915985f, factorScale * 394.660004f, factorScale * 277.920990f);
    p.close();
    p.moveTo(factorScale * 394.660004f, factorScale * 277.920990f);
    p.moveTo(factorScale * 315.098999f, factorScale * 376.335999f);
    p.rCubicTo(factorScale * -1.277000f, factorScale * 30.687000f, factorScale * 25.295000f,
        factorScale * 60.476002f, factorScale * 61.019001f, factorScale * 59.773998f);
    p.rCubicTo(factorScale * 31.896000f, factorScale * -0.627000f, factorScale * 58.290001f,
        factorScale * -27.672001f, factorScale * 58.035000f, factorScale * -60.150002f);
    p.rCubicTo(factorScale * -0.263000f, factorScale * -33.605999f, factorScale * -27.266001f,
        factorScale * -59.987000f, factorScale * -61.014000f, factorScale * -59.606998f);
    p.cubicTo(factorScale * 340.895996f, factorScale * 316.716003f, factorScale * 314.816986f,
        factorScale * 343.667999f, factorScale * 315.098999f, factorScale * 376.335999f);
    p.close();
    p.moveTo(factorScale * 315.098999f, factorScale * 376.335999f);
    p.setFillType(Path.FillType.EVEN_ODD);

    paint.setColor(color2);
    paint.setStyle(Paint.Style.FILL);

    canvas.drawPath(p, paint);
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

  public void setType(AnimationType animationType) {
    this.animationType = animationType;
  }

  public void setDegree(float animationDegree) {
    this.animationDegree = animationDegree;
  }

  @Override public void startAnimation() {

    ObjectAnimator animator = null;

    if (animationType == AnimationType.BOUNCE) {
      animator = ObjectAnimator.ofFloat(this, degreeProperty, degree, degree + 20, degree + 10,
          degree + 20, degree + 15, degree + 20);
    }

    if (animationType == AnimationType.ROTATION) {
      animator = ObjectAnimator.ofFloat(this, degreeProperty, degree, degree + animationDegree);
    } else {
      if (animationDegree != ANIMATION_DEGREE) {
        Log.w(TAG, "Animation degree is changed but Animation Type is not AnimationType.ROTATION");
      }
    }

    animator.setDuration(animationDuration);
    animator.setInterpolator(interpolator);
    animator.start();
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

  public void setInterpolator(Interpolator interpolator) {
    this.interpolator = interpolator;
  }

  public enum AnimationType {
    ROTATION,
    BOUNCE
  }
}

