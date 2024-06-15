package com.cromer.apiCromer.Service;

import com.cromer.apiCromer.model.Dao.CromerDao;
import com.cromer.apiCromer.model.entity.Cromer;

import java.util.List;

public interface ICromer {
    List<Cromer> listAll();
    Cromer save(Cromer cromer);
    Cromer findById(Integer id);

    void delete(Cromer cromer);





}
