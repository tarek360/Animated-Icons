package tarek360.animated.icons.drawables;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;

public class Like extends AnimatedIcon {

  private static final String TAG = Settings.class.getSimpleName();
  private float viewBoxWidth = 1024;
  private float viewBoxHeight = 1024;
  private int animationDuration;
  private int color;

  private Path p = new Path();
  private Paint paint = new Paint();
  private float translateY;
  private float scale = 1;
  private float rotation;

  public Like() {
    animationDuration = 800;
    color = Color.WHITE;
  }

  @Override public void draw(Canvas canvas) {
    paint.setAntiAlias(true);
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

    canvas.translate(0, factorScale * translateY);
    canvas.scale(scale, scale, newViewBoxWidth / 2, newViewBoxHeight / 2);
    canvas.rotate(rotation, newViewBoxWidth / 2, newViewBoxHeight / 2);

    p.reset();
    p.moveTo(factorScale * 824.710022f, factorScale * 482.136993f);
    p.rCubicTo(factorScale * -29.694000f, factorScale * -7.792000f, factorScale * -99.510002f,
        factorScale * -7.697000f, factorScale * -201.632996f, factorScale * -10.405000f);
    p.rCubicTo(factorScale * 4.822000f, factorScale * -22.282000f, factorScale * 5.939000f,
        factorScale * -42.379002f, factorScale * 5.939000f, factorScale * -78.058998f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * -85.233002f, factorScale * -62.096001f,
        factorScale * -160.298996f, factorScale * -117.016998f, factorScale * -160.298996f);
    p.rCubicTo(factorScale * -38.792000f, factorScale * 0.000000f, factorScale * -70.765999f,
        factorScale * 31.712999f, factorScale * -71.264999f, factorScale * 70.719002f);
    p.rCubicTo(factorScale * -0.523000f, factorScale * 47.842999f, factorScale * -15.322000f,
        factorScale * 130.462997f, factorScale * -95.019997f, factorScale * 172.365997f);
    p.rCubicTo(factorScale * -5.844000f, factorScale * 3.088000f, factorScale * -22.566999f,
        factorScale * 11.331000f, factorScale * -25.014000f, factorScale * 12.400000f);
    p.rLineTo(factorScale * 1.259000f, factorScale * 1.069000f);
    p.rCubicTo(factorScale * -12.471000f, factorScale * -10.761000f, factorScale * -29.764999f,
        factorScale * -19.004000f, factorScale * -47.509998f, factorScale * -19.004000f);
    p.rLineTo(factorScale * -71.264999f, 0);
    p.rCubicTo(factorScale * -39.291000f, factorScale * 0.000000f, factorScale * -71.264999f,
        factorScale * 31.974001f, factorScale * -71.264999f, factorScale * 71.264999f);
    p.rLineTo(0, factorScale * 380.079987f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 39.291000f, factorScale * 31.974001f,
        factorScale * 71.264999f, factorScale * 71.264999f, factorScale * 71.264999f);
    p.rLineTo(factorScale * 71.264999f, 0);

    p.rCubicTo(factorScale * 28.268000f, factorScale * 0.000000f, factorScale * 51.928001f,
        factorScale * -17.080000f, factorScale * 63.377998f, factorScale * -41.025002f);
    p.rCubicTo(factorScale * 0.285000f, factorScale * 0.095000f, factorScale * 0.784000f,
        factorScale * 0.238000f, factorScale * 1.116000f, factorScale * 0.285000f);
    p.rCubicTo(factorScale * 1.568000f, factorScale * 0.428000f, factorScale * 3.421000f,
        factorScale * 0.879000f, factorScale * 5.677000f, factorScale * 1.473000f);
    p.rCubicTo(factorScale * 0.428000f, factorScale * 0.119000f, factorScale * 0.641000f,
        factorScale * 0.166000f, factorScale * 1.093000f, factorScale * 0.285000f);
    p.rCubicTo(factorScale * 13.683000f, factorScale * 3.397000f, factorScale * 40.027000f,
        factorScale * 9.692000f, factorScale * 96.327003f, factorScale * 22.639000f);
    p.rCubicTo(factorScale * 12.068000f, factorScale * 2.756000f, factorScale * 75.825996f,
        factorScale * 16.343000f, factorScale * 141.865005f, factorScale * 16.343000f);
    p.rLineTo(factorScale * 129.869003f, 0);
    p.rCubicTo(factorScale * 39.576000f, factorScale * 0.000000f, factorScale * 68.106003f,
        factorScale * -15.227000f, factorScale * 85.091003f, factorScale * -45.799999f);
    p.rCubicTo(factorScale * 0.238000f, factorScale * -0.475000f, factorScale * 5.701000f,
        factorScale * -11.141000f, factorScale * 10.167000f, factorScale * -25.559999f);
    p.rCubicTo(factorScale * 3.349000f, factorScale * -10.856000f, factorScale * 4.585000f,
        factorScale * -26.226000f, factorScale * 0.546000f, factorScale * -41.808998f);
    p.rCubicTo(factorScale * 25.513000f, factorScale * -17.531000f, factorScale * 33.731998f,
        factorScale * -44.042000f, factorScale * 39.077000f, factorScale * -61.287998f);
    p.rCubicTo(factorScale * 8.956000f, factorScale * -28.292000f, factorScale * 6.271000f,
        factorScale * -49.553001f, factorScale * 0.048000f, factorScale * -64.779999f);
    p.rCubicTo(factorScale * 14.348000f, factorScale * -13.540000f, factorScale * 26.582001f,
        factorScale * -34.182999f, factorScale * 31.737000f, factorScale * -65.706001f);
    p.rCubicTo(factorScale * 3.207000f, factorScale * -19.527000f, factorScale * -0.238000f,
        factorScale * -39.623001f, factorScale * -9.241000f, factorScale * -56.347000f);
    p.rCubicTo(factorScale * 13.445000f, factorScale * -15.108000f, factorScale * 19.573999f,
        factorScale * -34.112000f, factorScale * 20.287001f, factorScale * -51.691002f);
    p.rLineTo(factorScale * 0.285000f, factorScale * -4.965000f);
    p.rCubicTo(factorScale * 0.166000f, factorScale * -3.112000f, factorScale * 0.309000f,
        factorScale * -5.036000f, factorScale * 0.309000f, factorScale * -11.878000f);
    p.cubicTo(factorScale * 892.078979f, factorScale * 533.708984f, factorScale * 871.294006f,
        factorScale * 495.440002f, factorScale * 824.710022f, factorScale * 482.136993f);
    p.lineTo(factorScale * 824.710022f, factorScale * 482.136993f);
    p.close();
    p.moveTo(factorScale * 824.710022f, factorScale * 482.136993f);
    p.moveTo(factorScale * 298.204010f, factorScale * 922.270020f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 13.136000f, factorScale * -10.618000f,
        factorScale * 23.754999f, factorScale * -23.754999f, factorScale * 23.754999f);
    p.rLineTo(factorScale * -71.264999f, 0);
    p.rCubicTo(factorScale * -13.137000f, factorScale * 0.000000f, factorScale * -23.754999f,
        factorScale * -10.619000f, factorScale * -23.754999f, factorScale * -23.754999f);
    p.lineTo(factorScale * 179.429001f, factorScale * 542.190002f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * -13.137000f, factorScale * 10.618000f,
        factorScale * -23.754999f, factorScale * 23.754999f, factorScale * -23.754999f);
    p.rLineTo(factorScale * 71.264999f, 0);

    p.rCubicTo(factorScale * 13.137000f, factorScale * 0.000000f, factorScale * 23.754999f,
        factorScale * 10.618000f, factorScale * 23.754999f, factorScale * 23.754999f);
    p.lineTo(factorScale * 298.204010f, factorScale * 922.270020f);
    p.close();
    p.moveTo(factorScale * 298.204010f, factorScale * 922.270020f);
    p.moveTo(factorScale * 795.588013f, factorScale * 637.210022f);
    p.rCubicTo(factorScale * 35.632000f, factorScale * -0.238000f, factorScale * 40.312000f,
        factorScale * 29.551001f, factorScale * 38.007999f, factorScale * 43.804001f);
    p.rCubicTo(factorScale * -2.946000f, factorScale * 17.721001f, factorScale * -11.260000f,
        factorScale * 51.216000f, factorScale * -51.382000f, factorScale * 51.216000f);
    p.rCubicTo(factorScale * -40.075001f, factorScale * 0.000000f, factorScale * -56.417999f,
        factorScale * 0.000000f, factorScale * -56.417999f, factorScale * 0.000000f);
    p.rCubicTo(factorScale * -6.580000f, factorScale * 0.000000f, factorScale * -38.230999f,
        factorScale * 5.297000f, factorScale * -38.230999f, factorScale * 11.878000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 6.533000f, factorScale * 31.650999f,
        factorScale * 11.878000f, factorScale * 38.230999f, factorScale * 11.878000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * 28.221001f,
        factorScale * 0.000000f, factorScale * 46.773998f, factorScale * 0.000000f);
    p.rCubicTo(factorScale * 40.098000f, factorScale * 0.000000f, factorScale * 36.558998f,
        factorScale * 30.573000f, factorScale * 30.809999f, factorScale * 48.817001f);
    p.rCubicTo(factorScale * -7.578000f, factorScale * 23.969000f, factorScale * -12.210000f,
        factorScale * 46.202999f, factorScale * -62.737000f, factorScale * 46.202999f);
    p.rCubicTo(factorScale * -17.080000f, factorScale * 0.000000f, factorScale * -38.743999f,
        factorScale * 0.000000f, factorScale * -38.743999f, factorScale * 0.000000f);
    p.rCubicTo(factorScale * -6.580000f, factorScale * 0.000000f, factorScale * -38.831001f,
        factorScale * 5.297000f, factorScale * -38.831001f, factorScale * 11.878000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 6.533000f, factorScale * 32.250000f,
        factorScale * 11.878000f, factorScale * 38.831001f, factorScale * 11.878000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * 16.462000f,
        factorScale * 0.000000f, factorScale * 37.248001f, factorScale * 0.000000f);
    p.rCubicTo(factorScale * 25.988001f, factorScale * 0.000000f, factorScale * 27.200001f,
        factorScale * 24.586000f, factorScale * 24.490999f, factorScale * 33.400002f);
    p.rCubicTo(factorScale * -2.969000f, factorScale * 9.645000f, factorScale * -6.485000f,
        factorScale * 16.795000f, factorScale * -6.628000f, factorScale * 17.127001f);
    p.rCubicTo(factorScale * -7.174000f, factorScale * 12.946000f, factorScale * -18.743000f,
        factorScale * 20.738001f, factorScale * -43.234001f, factorScale * 20.738001f);
    p.lineTo(factorScale * 583.906006f, factorScale * 946.027039f);
    p.rCubicTo(factorScale * -65.231003f, factorScale * 0.000000f, factorScale * -129.940002f,
        factorScale * -14.799000f, factorScale * -131.602997f, factorScale * -15.179000f);
    p.rCubicTo(factorScale * -98.678001f, factorScale * -22.733999f, factorScale * -103.880997f,
        factorScale * -24.490999f, factorScale * -110.081001f, factorScale * -26.249001f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 0.000000f, factorScale * -20.097000f,
        factorScale * -3.397000f, factorScale * -20.097000f, factorScale * -20.927999f);
    p.rLineTo(factorScale * -0.166000f, factorScale * -328.104004f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * -11.141000f, factorScale * 7.103000f,
        factorScale * -21.212999f, factorScale * 18.861000f, factorScale * -24.753000f);

    p.rCubicTo(factorScale * 1.473000f, factorScale * -0.570000f, factorScale * 3.468000f,
        factorScale * -1.188000f, factorScale * 4.894000f, factorScale * -1.782000f);
    p.rCubicTo(factorScale * 108.513000f, factorScale * -44.945000f, factorScale * 141.556000f,
        factorScale * -143.479996f, factorScale * 142.529999f, factorScale * -224.389999f);
    p.rCubicTo(factorScale * 0.143000f, factorScale * -11.379000f, factorScale * 8.908000f,
        factorScale * -23.754999f, factorScale * 23.754999f, factorScale * -23.754999f);
    p.rCubicTo(factorScale * 25.108999f, factorScale * 0.000000f, factorScale * 69.507004f,
        factorScale * 50.408001f, factorScale * 69.507004f, factorScale * 112.789001f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 56.323002f, factorScale * -2.280000f,
        factorScale * 66.063004f, factorScale * -21.997000f, factorScale * 124.761002f);
    p.rCubicTo(factorScale * 237.550003f, factorScale * 0.000000f, factorScale * 235.886993f,
        factorScale * 3.421000f, factorScale * 256.838989f, factorScale * 8.908000f);
    p.rCubicTo(factorScale * 25.988001f, factorScale * 7.435000f, factorScale * 28.221001f,
        factorScale * 28.957001f, factorScale * 28.221001f, factorScale * 36.368999f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 8.148000f, factorScale * -0.238000f,
        factorScale * 6.960000f, factorScale * -0.546000f, factorScale * 14.942000f);
    p.rCubicTo(factorScale * -0.475000f, factorScale * 11.735000f, factorScale * -5.392000f,
        factorScale * 34.800999f, factorScale * -46.964001f, factorScale * 34.800999f);
    p.rCubicTo(factorScale * -40.075001f, factorScale * 0.000000f, factorScale * -48.268002f,
        factorScale * 0.000000f, factorScale * -48.268002f, factorScale * 0.000000f);
    p.rCubicTo(factorScale * -6.580000f, factorScale * 0.000000f, factorScale * -38.230999f,
        factorScale * 5.297000f, factorScale * -38.230999f, factorScale * 11.878000f);
    p.rCubicTo(factorScale * 0.000000f, factorScale * 6.533000f, factorScale * 31.650999f,
        factorScale * 11.878000f, factorScale * 38.230999f, factorScale * 11.878000f);
    p.cubicTo(factorScale * 748.791992f, factorScale * 637.210022f, factorScale * 777.033997f,
        factorScale * 637.210022f, factorScale * 795.588013f, factorScale * 637.210022f);
    p.moveTo(factorScale * 238.815994f, factorScale * 851.005005f);
    p.rCubicTo(factorScale * -19.669001f, factorScale * 0.000000f, factorScale * -35.632999f,
        factorScale * 15.963000f, factorScale * -35.632999f, factorScale * 35.632999f);
    p.cubicTo(factorScale * 203.182999f, factorScale * 906.307983f, factorScale * 219.145996f,
        factorScale * 922.270996f, factorScale * 238.815994f, factorScale * 922.270996f);
    p.cubicTo(factorScale * 258.485992f, factorScale * 922.270996f, factorScale * 274.449005f,
        factorScale * 906.307983f, factorScale * 274.449005f, factorScale * 886.638000f);
    p.cubicTo(factorScale * 274.449005f, factorScale * 866.968018f, factorScale * 258.485992f,
        factorScale * 851.005005f, factorScale * 238.815994f, factorScale * 851.005005f);
    p.close();
    p.moveTo(factorScale * 238.815994f, factorScale * 851.005005f);
    p.moveTo(factorScale * 238.815994f, factorScale * 898.515015f);
    p.rCubicTo(factorScale * -6.533000f, factorScale * 0.000000f, factorScale * -11.878000f,
        factorScale * -5.345000f, factorScale * -11.878000f, factorScale * -11.878000f);
    p.cubicTo(factorScale * 226.937988f, factorScale * 880.104004f, factorScale * 232.282990f,
        factorScale * 874.759033f, factorScale * 238.815994f, factorScale * 874.759033f);
    p.cubicTo(factorScale * 245.348999f, factorScale * 874.759033f, factorScale * 250.694000f,
        factorScale * 880.104004f, factorScale * 250.694000f, factorScale * 886.637024f);
    p.cubicTo(factorScale * 250.694000f, factorScale * 893.170044f, factorScale * 245.348999f,
        factorScale * 898.515015f, factorScale * 238.815994f, factorScale * 898.515015f);

    p.close();
    p.moveTo(factorScale * 238.815994f, factorScale * 898.515015f);
    p.setFillType(Path.FillType.EVEN_ODD);
    paint.setShader(null);
    paint.setColor(color);
    paint.setAlpha(255);
    paint.setStyle(Paint.Style.FILL);
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

    ValueAnimator scaleAnimator = ValueAnimator.ofFloat(1, 1.15f, 1);
    //        scaleAnimator.setRepeatMode(ValueAnimator.RESTART);
    //        scaleAnimator.setRepeatCount(1);
    scaleAnimator.setDuration(400);
    scaleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

      @Override public void onAnimationUpdate(ValueAnimator animation) {

        float animatedValue = (float) animation.getAnimatedValue();
        Log.i("animation", "animatedValue " + animatedValue);
        scale = animatedValue;
        invalidateSelf();
      }
    });

    ValueAnimator rotationAnimator = ValueAnimator.ofFloat(0, -15, 0);
    //        rotationAnimator.setRepeatMode(ValueAnimator.RESTART);
    //        rotationAnimator.setRepeatCount(1);
    rotationAnimator.setDuration(400);
    rotationAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

      @Override public void onAnimationUpdate(ValueAnimator animation) {

        float animatedValue = (float) animation.getAnimatedValue();
        Log.i("animation", "animatedValue " + animatedValue);
        rotation = animatedValue;
        invalidateSelf();
      }
    });

    ValueAnimator translatAnimator = ValueAnimator.ofFloat(0, -230, 0);
    //        translatAnimator.setRepeatMode(ValueAnimator.RESTART);
    //        translatAnimator.setRepeatCount(1);
    translatAnimator.setDuration(400);
    translatAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    translatAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

      @Override public void onAnimationUpdate(ValueAnimator animation) {

        float animatedValue = (float) animation.getAnimatedValue();
        Log.i("animation", "animatedValue " + animatedValue);
        translateY = animatedValue;
        invalidateSelf();
      }
    });

    ValueAnimator vibrateAnimator = ValueAnimator.ofFloat(0, -100, 0);
    vibrateAnimator.setDuration(400);
    vibrateAnimator.setStartDelay(400);
    vibrateAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    vibrateAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

      @Override public void onAnimationUpdate(ValueAnimator animation) {

        float animatedValue = (float) animation.getAnimatedValue();
        Log.i("animation", "animatedValue " + animatedValue);
        translateY = animatedValue;
        invalidateSelf();
      }
    });

    AnimatorSet set = new AnimatorSet();
    set.playTogether(scaleAnimator, rotationAnimator, translatAnimator);
    set.start();
  }
}

