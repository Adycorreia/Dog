package com.example.Doc.Dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

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

    @Transactional
    public void updateDog(Long DogID, String nome,String origem, Integer idade){

        DogModel dogModel = dogRepository.findById(DogID).orElseThrow(() ->new IllegalStateException(
                "cao com esse Id nao existe"
        ));

        if(!Objects.equals(dogModel.getNome(),nome)){
            dogModel.setNome(nome);
        }

        if(!Objects.equals(dogModel.getOrigem(),origem)){
            dogModel.setOrigem(origem);
        }

        if(!Objects.equals(dogModel.getIdade(),idade)){
            dogModel.setIdade(idade);
        }

    }

}
