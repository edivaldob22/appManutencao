package br.ifsc.edu.prog3.manutencao.ui.ordem;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import br.ifsc.edu.prog3.manutencao.R;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class cadOrdem extends Fragment {
    //atributos
    private EditText etNumero;
    private EditText etMatricula;
    private EditText etCodigo;
    private EditText etHoraI;
    private EditText etHoraF;
    private EditText etObs;
    private Spinner spSetor;
    private Spinner spTipo;
    private CalendarView cvData;
    private Button btInserir;
    private View root;

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
        this.root = inflater.inflate(R.layout.fragment_cad_ordem, container, false);

        this.etNumero = (EditText) root.findViewById(R.id.etnumero);
        this.etMatricula = (EditText) root.findViewById(R.id.etmatricula);
        this.etCodigo = (EditText) root.findViewById(R.id.etcodigo);
        this.etHoraI = (EditText) root.findViewById(R.id.ethorai);
        this.etHoraF = (EditText) root.findViewById(R.id.ethoraf);
        this.etObs = (EditText) root.findViewById(R.id.etobs);
        this.spSetor = (Spinner) root.findViewById(R.id.spsetor);
        this.spTipo = (Spinner) root.findViewById(R.id.sptipo);
        this.cvData = (CalendarView) root.findViewById(R.id.cvdata);
        this.btInserir = (Button) root.findViewById(R.id.btinserir);

        return root;
    }
}