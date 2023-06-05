package br.ifsc.edu.prog3.manutencao.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Ordem {
    //ordem
    private int numero;
    private int tipo;
    private int setor;
    private String data;
    private String horaI;
    private String horaF;
    private String obs;
    //tecnico
    private String matricula;
    private String nome;
    //maquina
    private String codigo;
    private String nomeMaq;

    //construtor
    public Ordem(JSONObject jo) {
        try {
            this.numero = jo.getInt("numero");
            this.tipo = jo.getInt("tipo");
            this.setor = jo.getInt("codsetor");
            this.data = jo.getString("dataos");
            this.horaI = jo.getString("horai");
            this.horaF = jo.getString("horaf");
            this.obs = jo.getString("obs");
            this.matricula = jo.getString("matricula");
            this.nome = jo.getString("mtnome");
            this.codigo = jo.getString("codmaquina");
            this.nomeMaq = jo.getString("mqnome");
        }catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Ordem() {
        this.numero = 0;
        this.tipo = 0;
        this.setor = 0;
        this.data = "0000-00-00";
        this.horaI = "00:00";
        this.horaF = "00:00";
        this.obs = "";
        this.matricula = "0";
        this.nome = " ";
        this.codigo = "0";
        this.nomeMaq = " ";
    }

    //METODOS
    //Metodo retorna o objeto com dados no formato JSON
    public JSONObject toJsonObject() {
        JSONObject json = new JSONObject();
        try {
            json.put("numero", this.numero);
            json.put("tipo", this.tipo);
            json.put("codsetor", this.setor);
            json.put("dataos", this.data);
            json.put("horai", this.horaI);
            json.put("horaf", this.horaF);
            json.put("obs", this.obs);
            json.put("matricula", this.matricula);
            json.put("mtnome", this.nome);
            json.put("codmaquina", this.codigo);
            json.put("mqnome", this.nomeMaq);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    //metodos Set
    public boolean setNumero(int num) { //se não tiver retorno usa-se public void
        boolean valido = false;
        if (num > 100000) {
            this.numero = num;
            valido = true;
        }
        else {
            this.numero = 0;
        }
        return valido;
    }

    public boolean setTipo(int tp) {
        boolean valido = false;
        if (tp > 0 && tp < 6) {
            this.tipo = tp;
            valido = true;
        }
        else {
            this.tipo = 0;
        }
        return valido;
    }

    public boolean setSetor(int st) {
        boolean valido = false;
        if (st > 0 && st < 10) {
            this.setor = st;
            valido = true;
        }
        else {
            this.setor = 0;
        }
        return valido;
    }

    public boolean setData(String dt) {
        boolean valido = false;
        if ((dt.length() > 7) && (dt.length() < 11)) {
            this.data = dt;
            valido = true;
        }
        else {
            this.data = "0000-00-00";
        }
        return valido;
    }

    public boolean setHoraI(String hi) {
        boolean valido = false;
        if (hi.length() == 5) {
            this.horaI = hi + ":00";
        }
        if (this.horaI.matches("([0-9]{2}):([0-9]{2}):([0-9]{2})")) {
            valido = true;
        } else {
            this.horaI = "00:00:00";
            valido = true;
        }
        return valido;
    }

    public boolean setHoraF(String hf) {
        boolean valido = false;
        if (hf.length() == 5) {
            this.horaF = hf + ":00";
        }
        if (this.horaF.matches("([0-9]{2}):([0-9]{2}):([0-9]{2})")) {
            valido = true;
        }
        else {
            this.horaF = "00:00:00";
            valido = true;
        }
        return valido;
    }

    public boolean setObs(String obs) {
        boolean valido = false;
        if (obs.length() > 5) {
            this.obs = obs;
            valido = true;
        }
        else {
            this.obs = "Sem descrição";
        }
        return valido;
    }

    public boolean setMatricula(String mt) {
        boolean valido = false;
        if ((mt.matches("[0-9]+")) && (mt.length() > 3)) {
            this.matricula = mt;
            valido = true;
        }
        else {
            this.matricula = " ";
        }
        return valido;
    }

    public void setNome(String nom) {
        this.nome = nom;
    }

    public boolean setMaquina(String cd) {
        boolean valido = false;
        if ((cd.matches("[0-9]+"))) {
            this.codigo = cd;
            valido = true;
        }
        else {
            this.codigo = " ";
        }
        return valido;
    }

    public void setNomeMaq(String nomeMaq) {
        this.nomeMaq = nomeMaq;
    }

    //metodos Get

    public int getNumero() {
        return this.numero;
    }

    public int getTipo() {
        return this.tipo;
    }

    public int getSetor() {
        return this.setor;
    }

    public String getData() {
        return this.data;
    }

    public String getHoraI() {
        return this.horaI;
    }

    public String getHoraF() {
        return this.horaF;
    }

    public String getObs() {
        return this.obs;
    }

    public String getMatricula() {
        return this.matricula;
    }

    public String getNome() {
        return this.nome;
    }

    public String getMaquina() {
        return this.codigo;
    }

    public String getNomeMaq() {
        return nomeMaq;
    }

}