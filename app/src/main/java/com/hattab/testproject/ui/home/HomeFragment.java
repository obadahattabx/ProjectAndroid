package com.hattab.testproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.hattab.testproject.BlankFragment;
import com.hattab.testproject.Contact;
import com.hattab.testproject.ContactAdapter;
import com.hattab.testproject.HomeActivity;
import com.hattab.testproject.PostFragment;
import com.hattab.testproject.PostFragmentArgs;
import com.hattab.testproject.R;
import com.hattab.testproject.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;
    ListView contactview;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_home, container, false);

    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        contactview= getActivity().findViewById(R.id.contactlist);
//        ArrayList<Contact> contacts=new ArrayList<>();
//        contacts.add(new Contact("contact 2",2312));
//        contacts.add(new Contact("contact 3",2312));
//        contacts.add(new Contact("contact 4",2312));
//        contacts.add(new Contact("contact 5",2312));
//        contacts.add(new Contact("contact 6",2312));
//
//        ContactAdapter contactAdapter=new ContactAdapter(getActivity(),R.layout.contact,contacts);
//        contactview.setAdapter(contactAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();

        ArrayList<Contact> contacts=new ArrayList<>();
        contacts.add(new Contact("contact 2",2312));
        contacts.add(new Contact("contact 3",2312));
        contacts.add(new Contact("contact 4",2312));
        contacts.add(new Contact("contact 5",2312));
        contacts.add(new Contact("contact 6",2312));
        BlankFragment blankFragment=new BlankFragment();
        contactview= getActivity().findViewById(R.id.contactlist);

        ContactAdapter contactAdapter=new ContactAdapter(getActivity(),R.layout.contact,contacts);
        contactview.setAdapter(contactAdapter);
        NavController navController= Navigation.findNavController(getView());
        final PostFragment.communicator communicator =
                (PostFragment.communicator)getActivity();
        contactview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                HomeFragmentDirections.ActionNavHomeToPostFragment action=HomeFragmentDirections.actionNavHomeToPostFragment("obada");
                action.setMessage("hattab");
                navController.navigate(action);


            }
        });

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}