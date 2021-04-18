package com.devarun.project;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        InfoEntity infoEntity = new InfoEntity();
        InfoEntityDAO infoEntityDAO = new InfoEntityDAO();

        // add book
       /* infoEntityDAO.saveInfo("Mindfire","Bhubaneswar");
        infoEntityDAO.saveInfo("TCS","Mumbai");
        infoEntityDAO.saveInfo("Infosy","Bhubaneswar");*/

        // getListOfRecords
        System.out.println("GetList of records");
        List<InfoEntity> listOfRecords = infoEntityDAO.getListOfRecord();
        for (InfoEntity records : listOfRecords){
            System.out.println(records);
        }

        // updateRecord
        infoEntity.setName("Tech Mahendra");
        infoEntity.setAddress("Noida");
        infoEntity.setId(49);
        System.out.println(infoEntityDAO.updateRecord(infoEntity));

        // deleteRecord
        System.out.println(infoEntityDAO.deleteBook(50));

    }
}
