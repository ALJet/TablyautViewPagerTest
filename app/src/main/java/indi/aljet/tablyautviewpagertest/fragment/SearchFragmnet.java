package indi.aljet.tablyautviewpagertest.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import indi.aljet.tablyautviewpagertest.R;

/**
 * Created by LJL-lenovo on 2017/7/13.
 */

public class SearchFragmnet extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.search_activity,null);
    }
}
