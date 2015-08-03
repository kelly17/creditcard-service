package com.compareglobal.service.resource;

import com.compareglobal.service.dao.CreditCardDAOImpl;
import com.compareglobal.service.dao.FeeDAOImpl;
import com.compareglobal.service.dao.GenericDAOImpl;
import com.compareglobal.service.model.Compare;
import com.compareglobal.service.model.CreditCardPublic;
import com.yammer.metrics.annotation.Timed;
import com.compareglobal.service.model.CreditCard;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.LinkedList;
import java.util.List;

import com.compareglobal.service.transformer.CreditCardPublicTransformer;

@Path(value = "/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreditCardResource {

    //private final CreditCardDAO creditCardDao;
    protected CreditCardDAOImpl creditCardDAOImpl;
    protected FeeDAOImpl feeDAOImpl;
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected GenericDAOImpl genericDAOImpl;

    @Inject
    public CreditCardResource(final CreditCardDAOImpl ccDao,
                              final FeeDAOImpl feeDao) {
        emf = Persistence.createEntityManagerFactory("Default");
        em = emf.createEntityManager();

        this.creditCardDAOImpl = ccDao;
        this.feeDAOImpl = feeDao;
        creditCardDAOImpl.setEntityManager(em);
        feeDAOImpl.setEntityManager(em);
    }

    @GET
    @Path("/{id}")
    public CreditCard getCreditCardById(@PathParam("id") final long id){
        try {
            CreditCard cc = creditCardDAOImpl.find(id);
            return cc;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @POST
    @Timed
    @Path("/compare")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CreditCardPublic> home(Compare compare){
        List<CreditCardPublic> jsonList = new LinkedList<>();
        try {
            List<CreditCard> ccList = creditCardDAOImpl.findCreditCards(compare.getLocale());
            for (CreditCard cc :  ccList){
                CreditCardPublic ccp =  CreditCardPublicTransformer.valueOfDefault(cc);
                jsonList.add(ccp);
           }
            return jsonList;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return jsonList;
    }

}
