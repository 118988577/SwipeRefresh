package com.example.swiperefresh;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.Fragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;


public class swiperefreshFragment extends Fragment {
    private ListView mListView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private ArrayAdapter<String> mListAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Notify the system to allow an options menu for this fragment.
        setHasOptionsMenu(true);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.example_list, container, false);
        mSwipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swiperefresh);
        // Retrieve the ListView
        mListView = (ListView) view.findViewById(android.R.id.list);
        return view;
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mListAdapter = new ArrayAdapter<String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                Cheeses.randomList(10));

        // Set the adapter between the ListView and its backing data.
        mListView.setAdapter(mListAdapter);

        // BEGIN_INCLUDE (setup_refreshlistener)
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //在这里实现数据更新
                initiateRefresh();
                //完成数据更新后，调用setRefreshing(false)。调用此方法可指示 SwipeRefreshLayout 移除进度指示器并更新视图内容。
            }
        });
        // END_INCLUDE (setup_refreshlistener)
    }
    private void initiateRefresh() {

        new DummyBackgroundTask().execute();
    }
    private void onRefreshComplete(List<String> result) {

        // Remove all items from the ListAdapter, and then replace them with the new items
        mListAdapter.clear();
        for (String cheese : result) {
            mListAdapter.add(cheese);
        }
        // Stop the refreshing indicator
        mSwipeRefreshLayout.setRefreshing(false);
    }
    private class DummyBackgroundTask extends AsyncTask<Void, Void, List<String>> {

        static final int TASK_DURATION = 3 * 1000; // 3 seconds

        @Override
        protected List<String> doInBackground(Void... params) {
            // Sleep for a small amount of time to simulate a background-task
            try {
                Thread.sleep(TASK_DURATION);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Return a new random list of cheeses
            return Cheeses.randomList(10);
        }

        @Override
        protected void onPostExecute(List<String> result) {
            super.onPostExecute(result);

            // Tell the Fragment that the refresh has completed
            onRefreshComplete(result);
        }

    }
    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public void onPause() {
        super.onPause();
    }
}


