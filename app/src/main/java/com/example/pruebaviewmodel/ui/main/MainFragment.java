package com.example.pruebaviewmodel.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pruebaviewmodel.R;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private TextView textViewNormal, textViewViewModel;
    private MainViewModel enteroViewModel;
    private Button boton;
    private int contador = 0;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        // TODO: Use the ViewModel
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewNormal = view.findViewById(R.id.idTVContadorMal);
        textViewViewModel = view.findViewById(R.id.idTVContadorBien);
        boton = view.findViewById(R.id.idBTSumar);
        enteroViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        textViewNormal.setText(("Entero sin ViewModel: " + contador));
        textViewViewModel.setText("Entero con ViewModel: " + enteroViewModel.getNumero());

        boton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                textViewNormal.setText("Entero sin ViewModel: " + (++contador));
                enteroViewModel.setNumero(enteroViewModel.getNumero() + 1);
                textViewViewModel.setText("Entero con ViewModel: " + enteroViewModel.getNumero());
            }
        });
    }
}