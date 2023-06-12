package br.ifsc.edu.prog3.manutencao.ui.ordem;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.ifsc.edu.prog3.manutencao.R;
import br.ifsc.edu.prog3.manutencao.model.Ordem;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CadOrdemFragment extends Fragment implements View.OnClickListener, Response.ErrorListener, Response.Listener{
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
    //volley
    private RequestQueue requestQueue;
    private JsonObjectRequest jsonObjectReq;

    public CadOrdemFragment() {
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
        this.btInserir.setOnClickListener(this);
        //instanciando a fila de requests - caso o objeto seja o root
        this.requestQueue = Volley.newRequestQueue(root.getContext());
        //inicializando a fila de requests do SO
        this.requestQueue.start();

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
                            SimpleDateFormat("yyyy-MM-dd");
                    String dataSelecionada = sdf.format(new Date(cvData.getDate()));
                    o.setData(dataSelecionada);

                    jsonObjectReq = new JsonObjectRequest(
                            Request.Method.POST, "http://10.0.2.2/cadordem.php",
                            o.toJsonObject(), this, this);
                    requestQueue.add(jsonObjectReq);
                    break;
            }
        }
                @Override
                public void onResponse(Object response) {
                    String resposta = response.toString();
                    try {
                        if(resposta.equals("500")) {
                            Snackbar mensagem = Snackbar.make(root,
                                    "Erro! = " + resposta,
                                    Snackbar.LENGTH_LONG);
                            mensagem.show();
                        } else {
                            //sucesso //limpar campos da tela
                            this.etNumero.setText("0");
                            this.etMatricula.setText("");
                            this.etCodigo.setText("");
                            this.etHoraI.setText("");
                            this.etHoraF.setText("");
                            this.etObs.setText("");
                            this.spSetor.setSelection(0);
                            this.spTipo.setSelection(0);
                            //mensagem de sucesso
                            Snackbar mensagem = Snackbar.make(root,
                                    "Sucesso! = " + resposta,
                                    Snackbar.LENGTH_LONG);
                            mensagem.show();
                        }
                    } catch (Exception e) {  e.printStackTrace(); }
                }

                @Override
                public void onErrorResponse(VolleyError error) {
                    Snackbar mensagem = Snackbar.make(root,
                            "Ops! Houve um problema ao realizar o cadastro: " +
                                    error.toString(),Snackbar.LENGTH_LONG);
                    mensagem.show();

                }
    }
