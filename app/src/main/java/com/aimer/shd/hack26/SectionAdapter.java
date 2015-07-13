package com.aimer.shd.hack26;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by shd on 2015/7/13.
 */
public class SectionAdapter extends ArrayAdapter<String> {

    private Activity mActivity;

    public SectionAdapter(Activity context, String[] objects) {
        super(context, R.layout.list_item, R.id.label, objects);
        mActivity = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = mActivity.getLayoutInflater().inflate(R.layout.list_item, parent, false);
        }
        TextView header = (TextView) convertView.findViewById(R.id.header);
        String label = getItem(position);
        if (position == 0 || getItem(position - 1).charAt(0) != label.charAt(0)) {
            header.setVisibility(View.VISIBLE);
            header.setText(label.substring(0, 1));
        } else {
            header.setVisibility(View.GONE);
        }
        return super.getView(position, convertView, parent);
    }
}
