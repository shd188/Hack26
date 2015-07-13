package com.aimer.shd.hack26;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {

    TextView topView;
    int topVisiblePosition=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        topView= (TextView) findViewById(R.id.header);
        setListAdapter(new SectionAdapter(this,Countries.COUNTRIES));
        getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

                if (i!=topVisiblePosition){
                    topVisiblePosition=i;
                    setTopHeader(i);
                }
            }
        });
        setTopHeader(0);
    }

    private void setTopHeader(int pos) {
        final String text = Countries.COUNTRIES[pos].substring(0, 1);
        topView.setText(text);
    }
}
