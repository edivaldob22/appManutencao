package br.ifsc.edu.prog3.manutencao.ui.ordem;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import br.ifsc.edu.prog3.manutencao.databinding.FragmentConOrdemBinding;
import br.ifsc.edu.prog3.manutencao.model.Ordem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link br.ifsc.edu.prog3.manutencao.model.Ordem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ConOrdemRecyclerViewAdapter extends RecyclerView.Adapter<ConOrdemRecyclerViewAdapter.ViewHolder> {

    private final List<Ordem> mValues;

    public ConOrdemRecyclerViewAdapter(List<Ordem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentConOrdemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(String.valueOf(mValues.get(position).getNumero()));
        holder.mContentView.setText(mValues.get(position).getMatricula());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public Ordem mItem;

        public ViewHolder(FragmentConOrdemBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}