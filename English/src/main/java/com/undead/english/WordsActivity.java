package com.undead.english;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.undead.english.base.MyDatabase;
import com.undead.english.model.Word;

import java.util.List;

public class WordsActivity extends FragmentActivity {

    DemoCollectionPagerAdapter mDemoCollectionPagerAdapter;
    ViewPager mViewPager;

    private MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_words);

        db = new MyDatabase(this);
        Intent intent = getIntent();
        int theme = intent.getIntExtra("theme", 0);
        mDemoCollectionPagerAdapter = new DemoCollectionPagerAdapter(getSupportFragmentManager(), db.getWords(theme));

        // Specify that the Home button should show an "Up" caret, indicating that touching the
        // button will take the user one step up in the application's hierarchy.
        //final ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mDemoCollectionPagerAdapter);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.words, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // This is called when the Home (Up) button is pressed in the action bar.
                // Create a simple intent that starts the hierarchical parent activity and
                // use NavUtils in the Support Package to ensure proper handling of Up.
                Intent upIntent = new Intent(this, MainActivity.class);
                if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                    TaskStackBuilder.from(this).addNextIntent(upIntent).startActivities();
                    finish();
                } else {
                    NavUtils.navigateUpTo(this, upIntent);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class DemoCollectionPagerAdapter extends FragmentStatePagerAdapter {

        List<Word> words;

        public DemoCollectionPagerAdapter(FragmentManager fm, List<Word> words) {
            super(fm);
            this.words = words;
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment = new DemoObjectFragment(this.words);
            Bundle args = new Bundle();
            args.putInt(DemoObjectFragment.ARG_OBJECT, i); // Our object is just an integer :-P
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public int getCount() {
            return words.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return "OBJECT " + (position);
        }
    }

    public static class DemoObjectFragment extends Fragment {

        public static final String ARG_OBJECT = "object";
        List<Word> words;

        public DemoObjectFragment(List<Word> words) {
            this.words = words;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_collection_object, container, false);
//            Bundle args = getArguments();
//            ((TextView) rootView.findViewById(android.R.id.text1)).setText(
//                    Integer.toString(args.getInt(ARG_OBJECT)));

            Bundle args = getArguments();
            int position = args.getInt(ARG_OBJECT);

            View rootView = inflater.inflate(R.layout.item_word, container, false);

            TextView themeEng = (TextView) rootView.findViewById(R.id.txtEng);
            themeEng.setText(words.get(position).getWordEng());

            TextView themeRus = (TextView) rootView.findViewById(R.id.txtRus);
            themeRus.setText(words.get(position).getWordRus());


            return rootView;
        }
    }

}
