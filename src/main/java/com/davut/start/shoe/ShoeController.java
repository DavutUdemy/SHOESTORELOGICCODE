package com.davut.start.shoe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "api/v1/shoe")
public class ShoeController {
    private  final ShoeService shoeService;
    private final ShoeRepository shoeRepository;
    @Autowired
    public ShoeController(ShoeService shoeService, ShoeRepository shoeRepository){
        this.shoeService = shoeService;
        this.shoeRepository = shoeRepository;
    }

    @GetMapping
    public List<Shoe> getShoes(){
         return ShoeService.getShoes(shoeRepository);
    }
    @PostMapping
    public void registerNewShoe(@RequestBody  Shoe shoe){
        shoeService.addNewShoe(shoe);
    }
    @DeleteMapping(path = "{shoeID}")
    public void deleteShoes(@PathVariable("shoeID")Long shoeID){
        ShoeService.deleteShoe(shoeID,shoeRepository);
    }

    //@GetMapping(path = "{shoeID}")
    //public  List<Shoe> getUserByID(@PathVariable String shoeID){
//return ShoeService.getShoeById(shoeID,shoeRepository);
   // }
    @GetMapping(path = "{shoeID}")
    public Optional<Shoe> FilterById(@PathVariable Long shoeID){
        return ShoeService.findById(shoeID,shoeRepository);
    }


}

