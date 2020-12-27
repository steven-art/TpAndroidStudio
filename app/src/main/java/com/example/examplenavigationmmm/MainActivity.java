package com.example.examplenavigationmmm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.navigation.NavigationView;

/**
 *  A Activity class that loads Fragments
 *  To perform ACTIONS, different listeners are implemented do event go from the fragment to activity, which then navigates to a new fragment
 *  To transfer DATA between fragments, we use a ViewModel, the benefit of which is that it can interactively update the fragments when needed.
 * */
public class MainActivity extends AppCompatActivity implements Fragment1.OnFragment1InteractionListener,Fragment2.OnFragment2InteractionListener {

    private NavController navController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
    }


    @Override
    public void onFragment1Interaction(Uri uri) {

        navController.navigate(R.id.action_fragment1_to_fragment2);

    }

    @Override
    public void onFragment2Interaction(Uri uri) {

    }
}
