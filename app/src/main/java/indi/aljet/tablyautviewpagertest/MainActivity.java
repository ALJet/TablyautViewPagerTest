package indi.aljet.tablyautviewpagertest;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import indi.aljet.tablyautviewpagertest.fragment.ContactsFragment;
import indi.aljet.tablyautviewpagertest.fragment.EmailFragment;
import indi.aljet.tablyautviewpagertest.fragment.HomeFragment;
import indi.aljet.tablyautviewpagertest.fragment.MoreFragment;
import indi.aljet.tablyautviewpagertest.fragment.SearchFragmnet;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    private List<Fragment> list;
    private MyAdapter adapter;

    private String[] titles =  {"主页", "群组", "搜索", "消息", "更多"};
    private int images[] = {R.drawable.home_selector,
    R.drawable.contacts_selector,R.drawable.search_selector,
    R.drawable.email_selector,R.drawable.more_selector};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initData();
    }

    private void init(){
        viewPager = (ViewPager)findViewById(R.id
        .viewpager);
        tabLayout = (TabLayout)findViewById(R.id
        .tablayout);
    }

    private void initData(){
        list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new ContactsFragment());
        list.add(new SearchFragmnet());
        list.add(new EmailFragment());
        list.add(new MoreFragment());

        adapter = new MyAdapter(getSupportFragmentManager(),this);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0;i < tabLayout.getTabCount();i++){
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            tab.setCustomView(adapter.getTabView(i));
        }
    }


    class MyAdapter extends FragmentPagerAdapter{

        private Context context;

        public MyAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        public View getTabView(int position){
            View v = LayoutInflater.from(context)
                    .inflate(R.layout.tab_custom,null);

            //注意了 下面是view v.findViewById
            TextView textView = (TextView)v.findViewById(
                    R.id.tv_title);
            ImageView imageView = (ImageView)v.findViewById(R
            .id.tv_icon);
            textView.setText(titles[position]);
            imageView.setImageResource(images[position]);
            textView.setTextColor(tabLayout.getTabTextColors());
            return v;
        }

    }
}
