package org.example.tp_parc.service;

import org.example.tp_parc.dao.ComputerDao;
import org.example.tp_parc.entity.Computer;
import org.example.tp_parc.entity.Identification;

import javax.persistence.EntityNotFoundException;
import java.util.List;

public class ComputerService {

    private ComputerDao computerDao;

    public ComputerService() {
        this.computerDao = new ComputerDao();
    }

    public Computer create (String model, Identification identification){
        Computer computer = Computer.builder().model(model).identification(identification).build();
        return computerDao.createComputer(computer);
    }

    public Computer getComputerById(int id) { return computerDao.getById(id); }

    public Computer getComputerByIdentification (Identification identification){ return computerDao.getComputerByIdentification(identification); }

    public List<Computer> getComputersByModel (String model){
        return computerDao.getComputersByModel(model);
    }

    public void updateComputer (Computer computer) {
        try{
            computerDao.getById(computer.getId());
            computerDao.updateComputer(computer);
        } catch (EntityNotFoundException e){
            System.out.println("L'ordinateur n'existe pas");
        }
    }

    public void deleteComputer(Computer computer) {
        computerDao.deleteComputer(computer);
    }
}
