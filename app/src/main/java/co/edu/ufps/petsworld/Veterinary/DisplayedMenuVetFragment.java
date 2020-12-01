package co.edu.ufps.petsworld.Veterinary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import co.edu.ufps.petsworld.R;

public class DisplayedMenuVetFragment extends Fragment {

    private static final String TEXT = "text";

    public static DisplayedMenuVetFragment newInstance(String text) {
        DisplayedMenuVetFragment frag = new DisplayedMenuVetFragment();

        Bundle args = new Bundle();
        args.putString(TEXT, text);
        frag.setArguments(args);

        return frag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.home_fragment, container, false);

        if (getArguments() != null) {
            ((TextView) layout.findViewById(R.id.text)).setText(getArguments().getString(TEXT));
        }

        return layout;
    }

}
