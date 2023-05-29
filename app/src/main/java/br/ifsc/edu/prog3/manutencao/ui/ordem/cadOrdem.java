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

import java.text.SimpleDateFormat;
import java.util.Date;

import br.ifsc.edu.prog3.manutencao.R;
import br.ifsc.edu.prog3.manutencao.model.Ordem;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class cadOrdem extends Fragment implements View.OnClickListener{
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
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
            //verificando se é o botão salvar
                case R.id.btinserir:
                //instanciando a classe de negócio
                    Ordem o = new Ordem();
                    //populando objeto com dados da tela
                    o.setNumero(Integer.valueOf(this.etNumero.getText().toString()));
                    o.setMatricula(this.etMatricula.getText().toString());
                    o.setMaquina(this.etCodigo.getText().toString());
                    o.setHoraI(this.etHoraI.getText().toString());
                    o.setHoraF(this.etHoraF.getText().toString());
                    o.setObs(this.etObs.getText().toString());
                    //pegando dados do Spinner
                    o.setSetor((byte) this.spSetor.getSelectedItemPosition());
                    o.setTipo((byte) this.spTipo.getSelectedItemPosition());
                    //Pegando a Data do CalendarView
                    SimpleDateFormat sdf = new
                            SimpleDateFormat("dd/MM/yyyy");
                    String dataSelecionada = sdf.format(new Date(cvData.getDate()));
                    o.setData(dataSelecionada);
                 /*
                //mensagem de sucesso
                    Context context =  view.getContext();
                    CharSequence text = "salvo com sucesso!";
                    18int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText (context, text, duration);
                    toast.show();
                    break;*/

                    this.btInserir.setOnClickListener(this);
            }
        }
    }
