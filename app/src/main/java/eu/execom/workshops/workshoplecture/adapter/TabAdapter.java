package eu.execom.workshops.workshoplecture.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import eu.execom.workshops.workshoplecture.R;
import eu.execom.workshops.workshoplecture.fragment.StudentsFragment;

/**
 * {@link FragmentPagerAdapter Adapter} that provides a data source for
 * {@link android.support.v4.view.ViewPager ViewPager}.
 * Created by Alex on 10/24/16.
 */

public class TabAdapter extends FragmentPagerAdapter {

    /**
     * {@link List List} of {@link Fragment fragments} for the
     * {@link android.support.v4.view.ViewPager ViewPager}.
     */
    private final List<Fragment> fragments = new ArrayList<>();

    /**
     * Used for localization in this class.
     */
    private final Context context;

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragments.add(new StudentsFragment());
        fragments.add(new StudentsFragment());
        fragments.add(new StudentsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return context.getString(R.string.fragment_tab_naming, position);
    }
}
