package com.tarek360.animated_icons_sample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import tarek360.animated.icons.NotificationAlertIcon;

public class MainActivity extends AppCompatActivity {

  private NotificationAlertIcon toolbarIcon;
  private NotificationAlertIcon bigPreviewIcon;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    toolbarIcon = (NotificationAlertIcon) findViewById(R.id.toolbarIcon);
    toolbarIcon.setNotificationCount(3);
    toolbarIcon.setColors(Color.WHITE, Color.WHITE, Color.RED);

    bigPreviewIcon = (NotificationAlertIcon) findViewById(R.id.bigPreviewIcon);
    bigPreviewIcon.setNotificationCount(59);
    bigPreviewIcon.setColors(ContextCompat.getColor(this, R.color.colorAccent), Color.WHITE,
        ContextCompat.getColor(this, R.color.colorPrimary));

    // Repeat animation for 4 times
    //bigPreviewIcon.setRepeatCount(4);

    startAnimations();
  }

  private void startAnimations() {
    toolbarIcon.startAnimation();
    bigPreviewIcon.startAnimation();
  }

  public void startAnimation(View view) {
    startAnimations();
  }
}
