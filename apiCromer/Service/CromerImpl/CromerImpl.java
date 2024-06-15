package com.cromer.apiCromer.Service.CromerImpl;

import com.cromer.apiCromer.Service.ICromer;
import com.cromer.apiCromer.model.Dao.CromerDao;
import com.cromer.apiCromer.model.entity.Cromer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

public class CromerImpl implements ICromer {
    @Autowired
    private CromerDao cromerDao;



    @Override

    public List<Cromer> listAll(){
        return (List) cromerDao.findAll();
    }

    @Transactional
    @Override
    public Cromer save(Cromer cromer){

        return cromerDao.save(cromer);

    }

    @Transactional(readOnly = true)
    @Override
    public Cromer findById(Integer id) {
        return  cromerDao.findById(id).orElse(null);

    }

    @Override
    public void delete(Cromer cromer) {
        cromerDao.delete(cromer);


    }


}
