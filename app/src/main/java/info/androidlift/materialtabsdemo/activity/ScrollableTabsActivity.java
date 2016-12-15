package info.androidlift.materialtabsdemo.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import info.androidlift.materialtabsdemo.R;
import info.androidlift.materialtabsdemo.fragments.FriFragment;
import info.androidlift.materialtabsdemo.fragments.ThuFragment;
import info.androidlift.materialtabsdemo.fragments.MonFragment;
import info.androidlift.materialtabsdemo.fragments.SunFragment;
import info.androidlift.materialtabsdemo.fragments.SatFragment;
import info.androidlift.materialtabsdemo.fragments.WedFragment;
import info.androidlift.materialtabsdemo.fragments.TueFragment;

public class ScrollableTabsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollable_tabs);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new MonFragment(), "MONDAY");
        adapter.addFrag(new TueFragment(), "TUESDAY");
        adapter.addFrag(new WedFragment(), "WEDNESDAY");
        adapter.addFrag(new ThuFragment(), "THURSDAY");
        adapter.addFrag(new FriFragment(), "FRIDAY");
        adapter.addFrag(new SatFragment(), "SATURDAY");
        adapter.addFrag(new SunFragment(), "SUNDAY");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
