package com.moringaschool.plenty20;

import android.content.Context;
import android.widget.ArrayAdapter;

public class ShopArrayAdapter extends ArrayAdapter{
    private Context mContext;
    private String[] mShops;
    private String[] mItems;

    public ShopArrayAdapter(Context mContext, int resource, String[] mShops, String[] mItems) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mShops = mShops;
        this.mItems = mItems;
    }

    @Override
    public Object getItem(int position) {
        String shops = mShops[position];
        String items = mItems[position];
        return String.format("%s \nSells cool: %s", shops, items);
    }

    @Override
    public int getCount() {
        return mShops.length;
    }
}
