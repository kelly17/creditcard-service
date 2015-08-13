package com.compareglobal.service.resource;

import com.compareglobal.service.transformer.CreditCardPublicTransformer;
import com.compareglobal.service.dao.CreditCardDAOImpl;
import com.compareglobal.service.dao.GenericDAOImpl;
import com.compareglobal.service.model.Compare;
import com.compareglobal.service.model.CreditCardPublic;
import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Template;
import com.compareglobal.service.model.CreditCard;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


import com.compareglobal.service.helper.ContainsHelper;
import com.compareglobal.service.helper.IsInHelper;
import org.json.simple.JSONValue;

@Path(value = "/creditcard")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CreditCardResource {

    protected CreditCardDAOImpl creditCardDAOImpl;
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected GenericDAOImpl genericDAOImpl;

    private Handlebars handlebars = new Handlebars();

    @Inject
    public CreditCardResource(final CreditCardDAOImpl ccDao) {
        emf = Persistence.createEntityManagerFactory("Default");
        em = emf.createEntityManager();

        this.creditCardDAOImpl = ccDao;
        creditCardDAOImpl.setEntityManager(em);

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
    @Path("/compare")
    public Object template(Compare compare) throws IOException {

        Template template = handlebars.compile("templates/creditCardTemplate" + compare.getCountrySuffix());
        handlebars = handlebars.registerHelper(IsInHelper.NAME, IsInHelper.INSTANCE)
                .registerHelper(ContainsHelper.NAME, ContainsHelper.INSTANCE);

        List<Object> resultTemplate = new ArrayList<>();
        List<CreditCard> ccList = creditCardDAOImpl.findCreditCards(compare.getLocale());
        for (CreditCard cc :  ccList){
            CreditCardPublic ccv =  CreditCardPublicTransformer.valueOfDefault(cc);
            String templateResult = template.apply(ccv).replaceAll("\n", "")
                    .replaceAll(" },]", "}]")
                    .replaceAll("&quot;", "\"\"");
            resultTemplate.add(JSONValue.parse(templateResult));
        }

        return resultTemplate;
    }

}
