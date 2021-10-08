package com.bluesoft.petclinic.services.springdatajpa;

import com.bluesoft.petclinic.model.Owner;
import com.bluesoft.petclinic.repositories.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    @Mock
    OwnerRepository ownerRepository;

    @InjectMocks
    OwnerSDJpaService ownerSDJpaService;

    Owner owner;
    Long ownerId = 1l;
    String lastName = "Nowak";

    @BeforeEach
    void setUp() {
        owner = Owner.builder().id(ownerId).lastName(lastName).build();
    }

    @Test
    void findAll() {
        Owner owner1 = Owner.builder().build();

        Set<Owner> owners = new HashSet<>();
        owners.add(owner1);
        owners.add(owner);

        when(ownerRepository.findAll()).thenReturn(owners);

        assertEquals(2,ownerSDJpaService.findAll().size());
        verify(ownerRepository, times(1)).findAll();
    }

    @Test
    void findById() {
         when(ownerRepository.findById(anyLong())).thenReturn(java.util.Optional.ofNullable(owner));

         Owner byIdOwner = ownerSDJpaService.findById(3L);
         assertNotNull(byIdOwner);
         verify(ownerRepository,times(1)).findById(any());
    }

    @Test
    void findByIdNotFound(){
       when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
       Owner emptyOwner = ownerSDJpaService.findById(1L);
       assertNull(emptyOwner);

    }

    @Test
    void save() {
        when(ownerRepository.save(any())).thenReturn(owner);
        Owner savedOwner = ownerSDJpaService.save(owner);

        assertNotNull(savedOwner);
        verify(ownerRepository,times(1)).save(any());
    }

    @Test
    void delete() {
        ownerSDJpaService.delete(owner);
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        ownerSDJpaService.deleteById(ownerId);
        verify(ownerRepository,times(1)).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(anyString())).thenReturn(owner);
        Owner foundOwner = ownerSDJpaService.findByLastName(lastName);
        assertNotNull(foundOwner);
        assertEquals(lastName,foundOwner.getLastName());
        verify(ownerRepository,times(1)).findByLastName(anyString());
    }
}