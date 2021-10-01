package com.bluesoft.petclinic.services.map;

import com.bluesoft.petclinic.model.Owner;
import com.bluesoft.petclinic.model.Pet;
import com.bluesoft.petclinic.services.OwnerService;
import com.bluesoft.petclinic.services.PetService;
import com.bluesoft.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default","map"})
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(final PetTypeService petTypeService, final PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }


    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner object) {
          super.delete(object);
    }

    @Override
    public Owner save(final Owner object) {

        if(object != null){

            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        pet.setPetType(petTypeService.save(pet.getPetType()));
                    }else{
                        throw new RuntimeException("Pet Type is required!");
                    }

                    if(pet.getId() == null){
                        final Pet savePet = petService.save(pet);
                        pet.setId(savePet.getId());
                    }
                });
            }

            return super.save(object);
        }else {
            return null;
        }


    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return null;
    }
}
