package tablayout.bmpl.com.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    private int[] tabIcons = {
            R.drawable.facebook,
            R.drawable.googleplus
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //step-1: downcast tablayout and view pager

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        //step-2: call method for setting tablayout and view pager
        // these methods are created by us and not predefined

        setupViewPager(viewPager);//customized method
        tabLayout.setupWithViewPager(viewPager);

        //this method is used for setting icon on tab
        setupTabIcons();
    }


private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
    }

    private void setupViewPager(ViewPager viewPager)
    {
        //ViewPagerAdapter class is created by us and FragementPagerAdapter is predefined
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        //addFragment method is created by us and defined in ViewPagerAdapter class
        //FragmentOne and FragmentTwo are classes and "ONE" and "TWO" are title of tabs

        adapter.addFragment(new FragmentOne(),"ONE");//will add tabs on tablayout
        adapter.addFragment(new FragmentTwo(),"TWO");
        viewPager.setAdapter(adapter);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter{//FragmentPagerAdapter is Predefined class

        private final List<Fragment> fragmentList = new ArrayList<>();
        private final List<String> fragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragmentList.get(position);
        }

        @Override
        public int getCount()
        {
            return fragmentTitleList.size();
        }

        public void addFragment(Fragment fragment, String  title)
        {
            fragmentList.add(fragment);     //data and view
            fragmentTitleList.add(title);   //title
        }

        @Override
        public CharSequence getPageTitle(int position){
            //return null; //--> if we don't want to show a title on tablayout
            return fragmentTitleList.get(position);
        }
    }
}
