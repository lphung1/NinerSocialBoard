package com.example.ninerstudentorgboard;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;


import com.example.ninerstudentorgboard.JavaClasses.Post;

/**
 * Fragment representing a list of post founded by a search
 */
public class SearchListFragment extends Fragment {
    CustomAdapterPostList adapter;

    public void updateFragment2ListView(){

        adapter.notifyDataSetChanged();

    }
    private static final String ARG_COLUMN_COUNT = "column-count";
    private String search;
    private int mColumnCount = 1;
    private PostListFragment.OnListFragmentInteractionListener mListener;


    public SearchListFragment(){
    }

    public static SearchListFragment newInstance(int columnCount){
        SearchListFragment sFragment = new SearchListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        sFragment.setArguments(args);

        return sFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        adapter = new CustomAdapterPostList(getActivity(), R.layout.post_item, MainActivity.postArrayList);
        View view = inflater.inflate(R.layout.content_main, container, false);
        ListView listView = view.findViewById(R.id.content_main_listview);
        // Set the adapter
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);

        if (container != null) {
            container.removeAllViews();
        }

        //for if we want to use fragments for adding comments
        ImageView comment = listView.findViewById(R.id.commentsCountImageView);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                PostDetailsFragment postDetailsFragment = new PostDetailsFragment();
//
//                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container_main, postDetailsFragment).commit();
//
//                Log.d("Item pressed ", "From PostListFragment " + i);
//            }
//        });


        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
