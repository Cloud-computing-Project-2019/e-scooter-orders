package si.fri.rso.escooterental.escooterorders.services.beans;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import si.fri.rso.escooterental.escooterorders.lib.EscooterOrders;
import si.fri.rso.escooterental.escooterorders.models.converters.EscooterOrderConverter;
import si.fri.rso.escooterental.escooterorders.models.entities.EscooterOrdersEntity;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@ApplicationScoped
public class EscooterOrderBean {
    private Logger log = Logger.getLogger(EscooterOrderBean.class.getName());

    @Inject
    private EntityManager em;

    private Client httpClient;

    private String baseUrl;

    public List<EscooterOrders> getEscooterOrders(){
        TypedQuery<EscooterOrdersEntity> query = em.createNamedQuery("EscooterOrdersEntity.getall",EscooterOrdersEntity.class);
        return query.getResultList().stream().map(EscooterOrderConverter::toDto).collect(Collectors.toList());

    }

    public List<EscooterOrders> getEscooterOrders(UriInfo uriInfo){
        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery())
                .defaultOffset(0)
                .build();
        return JPAUtils.queryEntities(em,EscooterOrdersEntity.class,queryParameters).stream().map(EscooterOrderConverter::toDto).collect(Collectors.toList());
    }

    public EscooterOrders getEscooter(Integer id){
        EscooterOrdersEntity entity = em.find(EscooterOrdersEntity.class,id);
        if (entity == null){
            throw new NotFoundException();
        }

        EscooterOrders escooter = EscooterOrderConverter.toDto(entity);
        return escooter;
    }


    public EscooterOrders createEscooterOrder(EscooterOrders escooter){
        EscooterOrdersEntity entity = EscooterOrderConverter.toEntity(escooter);
        try {
            beginTx();
            em.persist(entity);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        if (entity.getId() == null) {
            throw new RuntimeException("Entity was not persisted");
        }

        return EscooterOrderConverter.toDto(entity);
    }

    public EscooterOrders putEscooterOrder(Integer id, EscooterOrders escooter) {

        EscooterOrdersEntity c = em.find(EscooterOrdersEntity.class, id);

        if (c == null) {
            return null;
        }

        EscooterOrdersEntity updatedEntity = new EscooterOrdersEntity();

        try {
            beginTx();
            updatedEntity.setId(c.getId());
            updatedEntity = em.merge(updatedEntity);
            commitTx();
        } catch (Exception e) {
            rollbackTx();
        }

        return EscooterOrderConverter.toDto(updatedEntity);
    }

    public boolean deleteEscooterOrder(Integer id){
        EscooterOrdersEntity entity = em.find(EscooterOrdersEntity.class,id);
        if (entity != null) {
            try {
                beginTx();
                em.remove(entity);
                commitTx();
            } catch (Exception e) {
                rollbackTx();
            }
        } else
            return false;

        return true;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive())
            em.getTransaction().begin();
    }

    private void commitTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().commit();
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive())
            em.getTransaction().rollback();
    }


}
