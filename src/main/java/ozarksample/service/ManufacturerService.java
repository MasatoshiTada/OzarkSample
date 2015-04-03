package ozarksample.service;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import ozarksample.entity.Manufacturer;

@RequestScoped
public class ManufacturerService {
    @PersistenceContext(unitName = "ozarkPU")
    private EntityManager manager;
    
    @Transactional(Transactional.TxType.REQUIRED)
    public Manufacturer findById(Integer id) {
        Manufacturer manufacturer = manager.find(Manufacturer.class, id);
        return manufacturer;
    }
    
    // other methods for CRUD operations
}
