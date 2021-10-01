package com.bluesoft.petclinic.services.map;

import com.bluesoft.petclinic.model.Visit;
import com.bluesoft.petclinic.repositories.VisitRepository;
import com.bluesoft.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VisitMapService extends AbstractMapService<Visit,Long> implements VisitService {


    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(final Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(final Visit object) {
        if(object.getPet() == null
                || object.getPet().getOwner() == null
                || object.getPet().getId() == null
                || object.getPet().getOwner().getId() == null){
            throw new RuntimeException("Invalid Visist");
        }
        return super.save(object);
    }

    @Override
    public void delete(final Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long aLong) {
        super.deleteById(aLong);
    }
}
