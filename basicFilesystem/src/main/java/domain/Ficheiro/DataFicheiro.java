package domain.Ficheiro;


import utils.DDD.ValueObject;

import java.util.Date;

/**
 * Classe auxiliar para guardar as datas.
 */
public class DataFicheiro implements ValueObject {

    /**
     * Data de modificacao
     */
    private Date dataModificacao;

    /**
     * Construtor completo
     */
    public DataFicheiro() {
        this.dataModificacao = new Date();
    }

    /**
     * Devolve data no formato DIA MES ANO HH:MM:SS
     * @return data
     */
    public String dataFormatada() {
        String[] data = dataModificacao.toString().split(" ");
        return data[0] + " " + data[1] + " " + data[2] + " " + data[3];
    }
}
