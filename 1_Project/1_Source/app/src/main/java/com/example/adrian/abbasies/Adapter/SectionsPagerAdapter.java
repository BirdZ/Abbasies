package com.example.adrian.abbasies.Adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.adrian.abbasies.R;
import com.example.adrian.abbasies.UI.FragmentMain;

import java.util.Locale;

/**
 * Created by Adrian on 05/09/2015.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private Context cntx;
    public SectionsPagerAdapter(FragmentManager fm, Context cntx) {
        super(fm);
        this.cntx = cntx;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return FragmentMain.newInstance(position + 1, cntx);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Locale l = Locale.getDefault();
        switch (position) {
            case 0:
                return cntx.getString(R.string.title_events).toUpperCase(l);
            case 1:
                return cntx.getString(R.string.title_songs).toUpperCase(l);
        }
        return null;
    }
}
