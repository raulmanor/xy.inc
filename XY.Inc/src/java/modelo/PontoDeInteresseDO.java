package modelo;

/**
 * Nome: PontoDeInteresseDO <br/>
 * Propósito: Classe DATA OBJECT responsavel por servir de modelo padão para os
 * Pontos de Interesse<br/>
 *
 * Data: <10/08/2019> <br/>
 *
 * @author Raul Manor <br/>
 * copyright Copyright (c) 2019 <br/>
 *
 * @version 1.0
 *
 */
public class PontoDeInteresseDO {

    private String ponto;
    private String cooX;
    private String cooY;

    //contrutor padrão
    public PontoDeInteresseDO() {
        super();
    }

    /**
     * Nome: getPonto <br/>
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     * @version 1.0
     * @return ponto
     */
    public String getPonto() {
        return ponto;
    }

    /**
     * Nome: setPonto <br/>
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     * @version 1.0
     * @param ponto
     */
    public void setPonto(String ponto) {
        this.ponto = ponto;
    }

    /**
     * Nome: getCooX <br/>
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     * @version 1.0
     * @return coox
     */
    public String getCooX() {
        return cooX;
    }

    /**
     * Nome: setCooX <br/>
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     * @version 1.0
     * @param cooX
     */
    public void setCooX(String cooX) {
        this.cooX = cooX;
    }

    /**
     * Nome: getCooY <br/>
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     * @version 1.0
     * @return  cooy
     */
    public String getCooY() {
        return cooY;
    }

    /**
     * Nome: setCooY <br/>
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     * @version 1.0
     * @param cooY
     */
    public void setCooY(String cooY) {
        this.cooY = cooY;
    }

}
