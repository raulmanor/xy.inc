/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import modelo.PontoDeInteresseDO;

/**
 * Nome: PoiController <br/>
 * Propósito: Classe de controle das logicas de negocio <br/>
 *
 * Data: <10/08/2019> <br/>
 *
 * @author Raul Manor <br/>
 * copyright Copyright (c) 2019 <br/>
 *
 * @version 1.0
 *
 */
public class PoiController {

    /**
     * Nome: buscarProximo <br/>
     * Propósito: Metodo buscarProximo consiste em um algorito que busca os <br/>
     * pontos de interesse até 10 unidades de distancia das coordenadas X e Y <br/>
     * fornecidas via parametro <br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     * @param lista
     * @param cooX
     * @param cooY
     * @return lista dos pontos mais proximos
     *
     */
    public List<PontoDeInteresseDO> buscarProximo(List<PontoDeInteresseDO> lista, String cooX, String cooY) {
        List<PontoDeInteresseDO> poisProximos = new ArrayList<>();

        int cx = Integer.parseInt(cooX);
        int cy = Integer.parseInt(cooY);

        for (PontoDeInteresseDO p : lista) {
            int coordenadaX = Integer.parseInt(p.getCooX());
            int coordenadaY = Integer.parseInt(p.getCooY());
            int refX = coordenadaX - cx;
            int refY = coordenadaY - cy;
            int lado = ((refX * refX) + (refY * refY));
            Double distancia = Math.sqrt(lado);
            if (distancia <= 10) {
                poisProximos.add(p);
            }
        }
        return poisProximos;
    }

}
