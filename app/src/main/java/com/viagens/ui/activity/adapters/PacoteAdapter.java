package com.viagens.ui.activity.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.viagens.R;
import com.viagens.models.Pacote;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PacoteAdapter extends BaseAdapter {
    private String quantidadeDias = "";
    private final List<Pacote> pacotes;
    private Context context;
    ImageView imagem;
    TextView local;    TextView dias;    TextView valor;    public PacoteAdapter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int i) {
        return pacotes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context)
                .inflate(R.layout.item_pacotes
                        , viewGroup
                        , false);
        Pacote pacote = pacotes.get(i);
        setTextView(inflate);
        setText(pacote);
        Drawable drawable = getDrawable(inflate, pacote);
        imagem.setImageDrawable(drawable);
        return inflate;

    }

    private void setText(Pacote pacote) {
        local.setText(pacote.getLocal());
        NumberFormat numberFormat = DecimalFormat
                .getCurrencyInstance(new Locale("pt", "br"));
        String moeda = numberFormat.format(pacote.getPreco()).replace("R$", "R$ ");
        valor.setText(moeda);
        quantidadeDias = pacote.getDias()+" dia";
        if(pacote.getDias()>1)
            quantidadeDias = pacote.getDias()+" dias";
        dias.setText(quantidadeDias);

    }

    private void setTextView(View inflate) {
        local = inflate.findViewById(R.id.item_pacote_cidade_name);
        dias = inflate.findViewById(R.id.item_pacote_dias);
        valor = inflate.findViewById(R.id.item_pacote_valor);
    }

    private Drawable getDrawable(View inflate, Pacote pacote) {
        imagem = inflate.findViewById(R.id.item_image_pacote);
        Resources resources = context.getResources();
        int idDoDawable = resources.getIdentifier(pacote.getImagem(), "drawable", context.getPackageName());
        return resources.getDrawable(idDoDawable);
    }
}
