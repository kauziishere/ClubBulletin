package com.example.itlab.clubbulletin;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by IT lab on 4/13/2017.
 */

public class CustomSwipeAdapter12 extends PagerAdapter {
    private  int [] image_resources = {R.drawable.mesa_1,R.drawable.mesa_2, R.drawable.mesa_3,R.drawable.mesa_4, R.drawable.mesa_5,R.drawable.mesa_6};
    private Context ctx;
    private LayoutInflater layoutInflater;
    public CustomSwipeAdapter12(Context ctx)
    {
        this.ctx = ctx;
    }
    @Override
    public int getCount() {
        return image_resources.length;

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }
    public Object instantiateItem(ViewGroup container,int position)
    {
        layoutInflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout,container,false);
        ImageView imageView = (ImageView)item_view.findViewById(R.id.image_view);
        // TextView textView = (TextView)item_view.findViewById(R.id.image_count);
        imageView.setImageResource(image_resources[position]);
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}

