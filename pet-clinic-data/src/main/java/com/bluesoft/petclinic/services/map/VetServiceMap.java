package com.bluesoft.petclinic.services.map;

import com.bluesoft.petclinic.model.Speciality;
import com.bluesoft.petclinic.model.Vet;
import com.bluesoft.petclinic.services.SpecialtyService;
import com.bluesoft.petclinic.services.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    private final SpecialtyService specialtyService;

    public VetServiceMap(final SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
         super.deleteById(id);
    }

    @Override
    public void delete(final Vet object) {
         super.delete(object);
    }

    @Override
    public Vet save(final Vet object) {

        if (object.getSpecialities().size() > 0){
            object.getSpecialities().forEach(speciality -> {
                if(speciality.getId() == null){
                    Speciality savedSpecialty = specialtyService.save(speciality);
                    speciality.setId(savedSpecialty.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }
}
