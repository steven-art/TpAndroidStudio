package com.example.examplenavigationmmm;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment2.OnFragment2InteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragment2InteractionListener mListener;
    private View view;
    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
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
        view = inflater.inflate(R.layout.fragment_fragment2, container, false);
        return view;

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragment2Interaction(uri);
        }
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // MC: once the view is created, we can initialize the data (here in First Fragment)
        SharedInfoVM myData = new ViewModelProvider(requireActivity()).get(SharedInfoVM.class);

        // and set a value to it. De note that as soon as setdata is called, all the interfaces connected to the Viewmodel are notified.
        // So if there's no other fragment, then nothing happens, but if the Fragment2 is displayed at the same time (eg on a tablet), then
        // the second fragment is updated!
        myData.setdata(new MyData(32,"Toto","12/12/2020"));
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragment2InteractionListener) {
            mListener = (OnFragment2InteractionListener) context;
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
    public interface OnFragment2InteractionListener {
        // TODO: Update argument type and name
        void onFragment2Interaction(Uri uri);
    }

    @OnClick(R.id.buttonCheck)
    public void validation(View view) {
        Toast.makeText(getActivity(),((EditText) view.findViewById(R.id.editTextName)).getText().toString()
                , Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),((EditText) view.findViewById(R.id.editTextFirstName)).getText().toString()
                , Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),((EditText) view.findViewById(R.id.editTextVilleN)).getText().toString()
                , Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),((EditText) view.findViewById(R.id.editTextDate)).getText().toString()
                , Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.buttonReset)
    public void resetfield(View view){
        String chaineVide = "";
        ((EditText) view.findViewById(R.id.editTextName)).setText(chaineVide);
        ((EditText) view.findViewById(R.id.editTextFirstName)).setText(chaineVide);
        ((EditText) view.findViewById(R.id.editTextVilleN)).setText(chaineVide);
        ((EditText) view.findViewById(R.id.editTextDate)).setText(chaineVide);
        ((EditText) view.findViewById(R.id.editTextPhone)).setText(chaineVide);

    }


}
