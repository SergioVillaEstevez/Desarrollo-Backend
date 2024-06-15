package com.cromer.apiCromer.Controller;

import com.cromer.apiCromer.Service.ICromer;
import com.cromer.apiCromer.model.entity.Cromer;
import com.cromer.apiCromer.model.payload.MensajeResponsive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


@RestController
@RequestMapping("api/v1")
public class CromerController {

    @Autowired
    private ICromer cromerService;

    List<Cromer> listAll;


    @GetMapping("cromers")

    public ResponseEntity<?> showAll(){
        List<Cromer> getList= cromerService.listAll();

        if(getList==null){
            return new ResponseEntity<>(
                    MensajeResponsive.builder()
                            .mensaje("regisrto no encontrado")
                            .object(null)
                            .build(), HttpStatus.OK
            );
        }
        return new ResponseEntity<>(
                MensajeResponsive.builder()
                        .mensaje("Realizaado con exito")
                        .object(getList)
                        .build(),HttpStatus.OK
        );

    }


    @PostMapping("cromer")
    @ResponseStatus(HttpStatus.CREATED)
    public Cromer create(@RequestBody Cromer cromer){

            return cromerService.save(cromer);



    }
    @PutMapping("cromer")
    @ResponseStatus(HttpStatus.CREATED)
    public Cromer update(@RequestBody Cromer cromer){
        return cromerService.save(cromer);


    }

    @DeleteMapping("cromer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        Cromer cromer=cromerService.findById(id);

        cromerService.delete(cromer);

    }

    @GetMapping("cromer/{id}")
    public ResponseEntity<?>showById(@PathVariable Integer id) {

        if (id == null) {
            return new ResponseEntity<>(
                    MensajeResponsive.builder()
                            .mensaje("mal")
                            .object(null).build(), HttpStatus.OK
            );
        }
            return new ResponseEntity<>(MensajeResponsive.builder()
                    .mensaje("Informacion correcta")
                    .object(cromerService.findById(id))
                    .build(), HttpStatus.OK);


    }

  /*  @ResponseStatus(HttpStatus.OK)
    public Cromer showById(@PathVariable Integer id){

        return cromerService.findById(id);

    }
*/














}
