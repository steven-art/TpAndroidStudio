package com.example.examplenavigationmmm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment1.OnFragment1InteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment implements ContactsAdapter.ContactsAdapterListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private RecyclerView recyclerView;
    private List<Contact> contactList;
    private ContactsAdapter mAdapter;
    private SearchView searchView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // my Shared data between the fragments
    private SharedInfoVM myData;

    private OnFragment1InteractionListener mListener;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment1, container, false);
        FloatingActionButton b = v.findViewById(R.id.myFAB);
        // create the data
        contactList = new ArrayList<>();
        contactList.add(new Contact("Nabila", "https://voi.img.pmdstatic.net/fit/http.3A.2F.2Fprd2-bone-image.2Es3-website-eu-west-1.2Eamazonaws.2Ecom.2Fvoi.2F2018.2F03.2F20.2Fd3bc6b27-9de7-4fd2-a9d5-010f117d02fa.2Ejpeg/480x270/quality/80/photos-nabilla-affiche-ses-formes-dans-un-bikini-qui-ne-cache-pas-grand-chose.jpg","06 66 66"));
        contactList.add(new Contact("Jean-Claude", "https://loopnewslive.blob.core.windows.net/liveimage/sites/default/files/2017-12/tb4klb9tqc.jpg","06 66 66"));
        contactList.add(new Contact("Patrick", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/Patrick_Bruel_Cabourg_2012.jpg/220px-Patrick_Bruel_Cabourg_2012.jpg","06 66 66"));
        contactList.add(new Contact("Brit'", "https://upload.wikimedia.org/wikipedia/commons/d/da/Britney_Spears_2013_%28Straighten_Crop%29.jpg","+31 66 66"));

        // handle the recycler view
        recyclerView = v.findViewById(R.id.recycler_view);
        mAdapter = new ContactsAdapter(getActivity(), contactList, this);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactList.add(new Contact("Brit'", "https://upload.wikimedia.org/wikipedia/commons/d/da/Britney_Spears_2013_%28Straighten_Crop%29.jpg","+31 66 66"));
                mAdapter.notifyDataSetChanged();
            }

        });

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {

            mListener.onFragment1Interaction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment1InteractionListener) {
            mListener = (OnFragment1InteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragment1InteractionListener {
        // TODO: Update argument type and name
        void onFragment1Interaction(Uri uri);
    }

    public void onContactSelected(Contact contact) {
        Toast.makeText(getActivity(), "Selected: " + contact.getName() + ", " + contact.getPhone(), Toast.LENGTH_LONG).show();
    }


}
