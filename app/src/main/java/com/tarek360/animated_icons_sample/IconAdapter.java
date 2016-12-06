package com.tarek360.animated_icons_sample;

/**
 * Created by tarek on 8/29/15.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import tarek360.animated.icons.AnimatedIconView;
import tarek360.animated.icons.drawables.AnimatedIcon;

public class IconAdapter extends RecyclerView.Adapter<IconAdapter.ViewHolder> {

  private List<AnimatedIcon> animatedIcons = new ArrayList<>();

  public void setAnimatedIcons(List<AnimatedIcon> animatedIcons) {
    this.animatedIcons.addAll(animatedIcons);
    this.notifyItemRangeInserted(0, animatedIcons.size() - 1);
  }

  @Override public ViewHolder onCreateViewHolder(final ViewGroup viewGroup, int i) {
    View v =
        LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_icon, viewGroup, false);
    return new ViewHolder(v);
  }

  @Override public void onBindViewHolder(final ViewHolder viewHolder, int i) {

    viewHolder.animatedIconView.setAnimatedIcon(animatedIcons.get(i));

    viewHolder.name.setText(animatedIcons.get(i).getClass().getSimpleName());
  }

  @Override public int getItemCount() {
    return animatedIcons == null ? 0 : animatedIcons.size();
  }

  public void clear() {
    animatedIcons.clear();
  }

  public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView name;
    public AnimatedIconView animatedIconView;

    public ViewHolder(View itemView) {
      super(itemView);
      name = (TextView) itemView.findViewById(R.id.name);
      animatedIconView = (AnimatedIconView) itemView.findViewById(R.id.icon);
      animatedIconView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
          //animatedIconView.startAnimation();
          for (AnimatedIcon a : animatedIcons) {
            a.startAnimation();
          }
        }
      });
    }
  }
}