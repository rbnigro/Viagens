package br.com.aluraviagens.ui.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.alura.viagem.R;
import br.com.aluraviagens.model.Pacote;

import static br.com.aluraviagens.moedaUtils.formataMoeda;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context) {

        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        montaTela(viewCriada, pacote);

        return viewCriada;
    }

    void montaTela(View viewCriada, Pacote pacote) {
        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);
    }

    void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String MoedaBR = formataMoeda(pacote.getPreco());
        preco.setText(MoedaBR);
    }

    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);

        int iDias = pacote.getDias();
        String sDias = " dia";
        if(iDias > 1) {
            sDias = " dias";
        }

        dias.setText(iDias + sDias);
    }

    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imagem = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = devolveDrawble(pacote);
        imagem.setImageDrawable(drawableImagemPacote);
    }

    private Drawable devolveDrawble(Pacote pacote) {
        Resources resources = context.getResources();
        int idDrawble = resources.getIdentifier(pacote.getImagem(), "drawble", context.getPackageName());
        Resources.Theme tema = ((Activity)context).getTheme();
        Drawable drawableImagemPacote = resources.getDrawable(idDrawble, tema);
        return drawableImagemPacote;
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
