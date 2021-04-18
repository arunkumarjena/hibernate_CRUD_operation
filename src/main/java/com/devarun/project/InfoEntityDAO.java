package com.devarun.project;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class InfoEntityDAO {
    // method for insert record
    public void saveInfo(String officeName, String OfficeAddress){
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            InfoEntity infoEntity = new InfoEntity();
            infoEntity.setName(officeName);
            infoEntity.setAddress(OfficeAddress);

            session.save(infoEntity);
            transaction.commit();
            System.out.println("Record inserted successfully");
        }catch (HibernateException hibernateException){
            transaction.rollback();
            hibernateException.printStackTrace();
        }finally {
            session.close();
        }

    }
    // method for retrive record
    public List<InfoEntity> getListOfRecord(){
        Session session = FactoryProvider.getSessionFactory().openSession();
        Query query = session.createQuery("from InfoEntity ");
        List<InfoEntity> records = query.getResultList();
        session.close();
        return records;
    }
    // method for update record
    public int updateRecord(InfoEntity infoEntity){
        if (infoEntity.getId() <= 0)
            return 0;
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        String hql = "update InfoEntity set name = :name, address = :address where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", infoEntity.getId());
        query.setString("name", infoEntity.getName());
        query.setString("address", infoEntity.getAddress());
        int rowCount = query.executeUpdate();

        System.out.println("Rows affected: " + rowCount);
        transaction.commit();
        session.close();
        return rowCount;
    }
    // method for delete record
    public int deleteBook(int id){
        Session session = FactoryProvider.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        String hql = "delete from InfoEntity where id = :id";
        Query query = session.createQuery(hql);
        query.setInteger("id", id);
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
        tx.commit();
        session.close();
        return rowCount;
    }
}
