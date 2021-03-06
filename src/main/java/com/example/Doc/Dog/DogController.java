package com.example.Doc.Dog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/dog")
public class DogController {

    private final DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @GetMapping
    public List<DogModel> getDog(){
         return dogService.getDog();
    }

    @PostMapping
    public void registerNewdog(@RequestBody DogModel dogModel){
        dogService.addNewDog(dogModel);
    }

    @DeleteMapping(path="{dogID}")
    public void deleteDog(@PathVariable("dogID") Long dogID){
        dogService.deleteDog(dogID);
    }

    @PutMapping (path="{dogID}")
    public void updateDog(
            @PathVariable("dogID") Long DogID,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String origem,
            @RequestParam(required = false) Integer idade
       ) {
        dogService.updateDog(DogID,nome,origem,idade);
    }

}
