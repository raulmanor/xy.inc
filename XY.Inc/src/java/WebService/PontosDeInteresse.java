/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebService;

import com.google.gson.Gson;
import controller.PoiController;
import dao.PoiDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import modelo.PontoDeInteresseDO;

/**
 * REST Web Service
 *
 * @author rmanor
 */
@Path("xyInc")
public class PontosDeInteresse {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PontosDeInteresse
     */
    public PontosDeInteresse() {
    }

    @GET
    @Produces("application/json")
    @Path("Poi/getPontoProximo/{cooX},{cooY}")
    public String getPontoProximo(@PathParam("cooX") String cooX,@PathParam("cooY") String cooY ) {
        List<PontoDeInteresseDO> lista;
        PontoDeInteresseDO poi = new PontoDeInteresseDO();
        poi.setCooX(cooX);
        poi.setCooY(cooY);
        PoiDAO dao = new PoiDAO();
        lista = dao.listar();
        PoiController ctr = new PoiController();
        
        //converter para Json
        Gson g = new Gson();
        return g.toJson(ctr.buscarProximo(lista,cooX,cooY));
    }

    @GET
    @Produces("application/json")
    @Path("Poi/getListaPoi")
    public String getListaPoi() {
        List<PontoDeInteresseDO> lista;

        PoiDAO dao = new PoiDAO();

        lista = dao.listar();
        Gson g = new Gson();
        return g.toJson(lista);
    }

    @POST
    @Consumes({"application/json"})
    @Path("Poi/cadastrar/")
    public boolean  cadastrar(String conteudo) {
        Gson g =  new Gson();
        PontoDeInteresseDO poi  = (PontoDeInteresseDO) g.fromJson(conteudo, PontoDeInteresseDO.class);
        PoiDAO dao = new PoiDAO();
        return  dao.inserir(poi);
            
    }

    /**
     * PUT method for updating or creating an instance of PontosDeInteresse
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }
}
