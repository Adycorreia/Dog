package com.example.Doc.Dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogService {

    private final DogRepository dogRepository;

    @Autowired
    public DogService(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public List<DogModel> getDog(){
        return  dogRepository.findAll();
    }

    public void addNewDog(DogModel dogModel){
        dogRepository.save(dogModel);
    }

    public void deleteDog(Long dogID){
        boolean exist=dogRepository.existsById(dogID);
        if(!exist){
            throw new IllegalStateException(
                    "Dog Com Id=" +dogID+ " nao existe");
        }
        dogRepository.deleteById(dogID);

    }

}
