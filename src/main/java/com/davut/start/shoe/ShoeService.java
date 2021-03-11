package com.davut.start.shoe;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoeService {
    private final ShoeRepository shoeRepository;
@Autowired
    public ShoeService(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    public static List<Shoe> getShoes(ShoeRepository shoeRepository) {
        return shoeRepository.findAll();
    }

    public static void FindById(Long shoeID,ShoeRepository shoeRepository) {
    shoeRepository.findById(shoeID);

    }
    static Optional<Shoe> findById(Long shoeID,ShoeRepository shoeRepository) {
        return shoeRepository.findById(shoeID);
    }


    //static List<Shoe> getShoeById(String shoeID,ShoeRepository shoeRepository) {
//return  shoeRepository.findByShoeId(shoeID);
    //}

    public void addNewShoe(Shoe shoe) {
        Optional<Shoe> shoeByEmail = shoeRepository.findShoeByModel(shoe.getModel());
        if(shoeByEmail.isPresent()){
            throw  new IllegalStateException("model is taken");
        }
        shoeRepository.save(shoe);

    }

    public static void deleteShoe(Long shoeID,ShoeRepository shoeRepository) {

        boolean b = shoeRepository.existsById(shoeID);
        if(!b){

            throw  new IllegalStateException("student is unnormal");     }
        shoeRepository.deleteById(shoeID);

    }



}

