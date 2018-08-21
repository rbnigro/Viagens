package br.com.aluraviagens;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import br.com.aluraviagens.model.Pacote;

public class moedaUtils {

    public static String formataMoeda(BigDecimal pacote) {
        BigDecimal precoPacote = pacote;
        NumberFormat formatoBR = DecimalFormat.getCurrencyInstance(new Locale("pt", "br"));
        return formatoBR.format(precoPacote).replace("R$", "R$ ");
    }
}
