/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PontoDeInteresseDO;

/**
 * Nome: PoiDAO <br/>
 * Propósito: metodo DATA ACCESS OBJECT usado para acessar as entidades do banco
 * de dados <br/>
 *
 * Data: <10/08/2019> <br/>
 *
 * @author Raul Manor <br/>
 * copyright Copyright (c) 2019 <br/>
 *
 * @version 1.0
 *
 */
public class PoiDAO {

    //contrutor
    public PoiDAO() {

    }

    /**
     * Nome: inserir <br/>
     * Propósito: metodo responsavel por inserir os dados no banco de dados
     * <br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     *
     */
    public boolean inserir(PontoDeInteresseDO poi) {
        String sql = "INSERT INTO poi(ponto,cooX,cooY) VALUES(?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setString(1, poi.getPonto());
            pst.setString(2, poi.getCooX());
            pst.setString(3, poi.getCooY());

            if (pst.executeUpdate() > 0) {
                retorno = true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(PoiDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }

        return retorno;

    }

    /**
     * Nome: listar <br/>
     * Propósito: metodo responsavel por listar os dados no banco de dados <br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     *
     */
    public List<PontoDeInteresseDO> listar() {
        String sql = "SELECT * FROM poi";
        List<PontoDeInteresseDO> retorno = new ArrayList<PontoDeInteresseDO>();

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            ResultSet res = pst.executeQuery();
            while (res.next()) {
                PontoDeInteresseDO poi = new PontoDeInteresseDO();
                poi.setPonto(res.getString("ponto"));
                poi.setCooX(res.getString("cooX"));
                poi.setCooY(res.getString("cooY"));

                retorno.add(poi);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PoiDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

    /**
     * Nome: buscar <br/>
     * Propósito: metodo responsavel por buscar os dados no banco de dados <br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     *
     */

    public PontoDeInteresseDO buscar(PontoDeInteresseDO usuario) {
        String sql = "SELECT * FROM poi where ponto=?";
        PontoDeInteresseDO retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, usuario.getPonto());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new PontoDeInteresseDO();
                retorno.setPonto(res.getString("ponto"));
                retorno.setCooX(res.getString("cooX"));
                retorno.setCooY(res.getString("cooY"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PoiDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

    /**
     * Nome: inserir <br/>
     * Propósito: metodo responsavel por buscar por proximidade os dados no
     * banco de dados <br/>
     *
     * Data: <10/08/2019> <br/>
     *
     * @author Raul Manor <br/>
     * copyright Copyright (c) 2019 <br/>
     *
     * @version 1.0
     *
     */
    public PontoDeInteresseDO buscarProximo(PontoDeInteresseDO poi) {
        String sql = "SELECT * FROM poi where cooX=? AND cooY=?";
        PontoDeInteresseDO retorno = null;

        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {

            pst.setString(1, poi.getCooX());
            pst.setString(2, poi.getCooY());
            ResultSet res = pst.executeQuery();

            if (res.next()) {
                retorno = new PontoDeInteresseDO();
                retorno.setPonto(res.getString("ponto"));
                retorno.setCooX(res.getString("cooX"));
                retorno.setCooY(res.getString("cooY"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(PoiDAO.class.getName()).log(Level.SEVERE, null, ex);

        }

        return retorno;

    }

}
