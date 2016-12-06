package com.tarek360.animated_icons_sample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

  private IconsFragment mIconsFragment;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    loadIcons();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu items for use in the action bar
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.menu_main, menu);

    final SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
    searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

      @Override public boolean onQueryTextSubmit(String s) {
        search(s);
        return true;
      }

      @Override public boolean onQueryTextChange(String s) {
        search(s);
        return true;
      }

      private void search(String s) {
        if (mIconsFragment != null) mIconsFragment.onSearch(s);
      }
    });

    return super.onCreateOptionsMenu(menu);
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle presses on the action bar items
    switch (item.getItemId()) {
      case R.id.action_github:
        startActivity(new Intent(Intent.ACTION_VIEW,
            Uri.parse("https://github.com/tarek360/Animated-Icons")));
        return true;

      default:
        return super.onOptionsItemSelected(item);
    }
  }

  private void loadIcons() {
    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
    mIconsFragment = IconsFragment.newInstance();
    ft.replace(R.id.container, mIconsFragment);
    ft.commit();
  }
}
