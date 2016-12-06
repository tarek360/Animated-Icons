package com.tarek360.animated_icons_sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.AbstractList;
import java.util.ArrayList;
import tarek360.animated.icons.drawables.AnimatedIcon;
import tarek360.animated.icons.IconFactory;

public class IconsFragment extends Fragment {

  private ArrayList<AnimatedIcon> animatedIcons = new ArrayList<>();
  private IconAdapter mAdapter;

  public static IconsFragment newInstance() {
    Bundle bundle = new Bundle();

    IconsFragment fragment = new IconsFragment();

    fragment.setArguments(bundle);

    return fragment;
  }

  @Override public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.icons_fragment, null, false);
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    // Init and Setup RecyclerView
    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.list);
    recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
    //animator not yet working
    recyclerView.setItemAnimator(new DefaultItemAnimator());

    mAdapter = new IconAdapter();
    recyclerView.setAdapter(mAdapter);

    animatedIcons.add(IconFactory.iconNotificationAlert().setNotificationCount(2));
    animatedIcons.add(IconFactory.iconBin());
    animatedIcons.add(IconFactory.iconHorizontalArrow());
    animatedIcons.add(IconFactory.iconVerticalArrow());
    animatedIcons.add(IconFactory.iconLike());
    animatedIcons.add(IconFactory.iconSettings());
    animatedIcons.add(IconFactory.iconMail());
    animatedIcons.add(IconFactory.iconLocation());

    mAdapter.setAnimatedIcons(animatedIcons);
  }

  public void onSearch(String s) {
    Log.i("IconsFragment", "onSearch: " + s);

    AbstractList<AnimatedIcon> tmpList = new ArrayList<>();
    for (AnimatedIcon animatedIcon : animatedIcons) {
      if (animatedIcon.getClass().getSimpleName().toLowerCase().contains(s.toLowerCase())) {
        tmpList.add(animatedIcon);
      }
    }

    Log.i("IconsFragment", "animatedIcons-size: " + animatedIcons.size() + "\n" +
        "tmp-size: " + tmpList.size());

    mAdapter.clear();
    mAdapter.setAnimatedIcons(tmpList);
    mAdapter.notifyDataSetChanged();
  }
}
