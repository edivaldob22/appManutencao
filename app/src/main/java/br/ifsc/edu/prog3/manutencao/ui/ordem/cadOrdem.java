package br.ifsc.edu.prog3.manutencao.ui.ordem;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.ifsc.edu.prog3.manutencao.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class cadOrdem extends Fragment {

    public cadOrdem() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

            ((AppCompatActivity)getActivity()).getSupportActionBar()
                    .setDisplayShowCustomEnabled(false);
            ((AppCompatActivity) getActivity()).getSupportActionBar()
                    .setDisplayHomeAsUpEnabled(false);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cad_ordem, container, false);
    }
}