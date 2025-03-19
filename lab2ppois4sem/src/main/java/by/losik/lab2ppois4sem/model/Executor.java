package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;

import java.util.List;

public class Executor implements ExecutorActions{
    EntityManagerFactory entityManagerFactory;
    EntityManager entityManager;
    EntityTransaction entityTransaction;

    public void initEntityManagerFactory() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("Form");
    }

    public void initEntityManager() {
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void initEntityTransaction(){
        this.entityTransaction = entityManager.getTransaction();
    }
    @Override
    @Transactional
    public List<Form> getAllData() {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f", Form.class)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByStudentName(String name) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.studentName = :name", Form.class)
                    .setParameter("name", name)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by student name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByStudentSurname(String surname) {
        try {
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.studentSurname = :surname", Form.class)
                    .setParameter("surname", surname)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        } catch (Exception e) {
            System.out.println("Extracting by student surname data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByStudentFatherName(String fatherName) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.studentFatherName = :fatherName", Form.class)
                    .setParameter("fatherName", fatherName)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by student father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherName(String name) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.motherName = :name", Form.class)
                    .setParameter("name", name)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by mother name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherSurname(String surname) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.motherSurname = :surname", Form.class)
                    .setParameter("surname", surname)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by mother surname data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherFatherName(String fatherName) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.motherFatherName = :name", Form.class)
                    .setParameter("name", fatherName)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by mother father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherName(String name) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.fatherName = :name", Form.class)
                    .setParameter("name", name)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherSurname(String surname) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.fatherSurname = :name", Form.class)
                    .setParameter("name", surname)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by father surname data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherFatherName(String fatherName) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.fatherFatherName = :name", Form.class)
                    .setParameter("name", fatherName)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by father father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherSalary(float minSalary, float maxSalary) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.salary >= :minSalary " +
                            "and f.mother.salary <= :maxSalary", Form.class)
                    .setParameter("minSalary", minSalary)
                    .setParameter("maxSalary", maxSalary)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by mother salary data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherSalary(float minSalary, float maxSalary) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.salary >= :minSalary " +
                            "and f.father.salary <= :maxSalary", Form.class)
                    .setParameter("minSalary", minSalary)
                    .setParameter("maxSalary", maxSalary)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by father salary data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByAmountOfSisters(int amount) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.numOfSisters = :amount", Form.class)
                    .setParameter("amount", amount)
                    .getResultList();
            entityTransaction.commit();

            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by amount of sisters data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> getFormsByAmountOfBrothers(int amount) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.numOfBrothers = :amount", Form.class)
                    .setParameter("amount", amount)
                    .getResultList();
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Extracting by amount of brothers data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByStudentName(String name) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            if(!entityManager.isOpen()){
                initEntityManager();
            }
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.studentName = :name", Form.class)
                    .setParameter("name", name)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by student name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByStudentSurname(String surname) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.studentSurname = :surname", Form.class)
                    .setParameter("surname", surname)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by student surname data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByStudentFatherName(String fatherName) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.studentFatherName = :fatherName", Form.class)
                    .setParameter("fatherName", fatherName)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by student father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByMotherName(String name) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.motherName = :name", Form.class)
                    .setParameter("name", name)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by mother name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByMotherSurname(String surname) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.motherSurname = :surname", Form.class)
                    .setParameter("surname", surname)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by mother surname data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByMotherFatherName(String fatherName) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.motherFatherName = :fatherName", Form.class)
                    .setParameter("fatherName", fatherName)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by mother father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByFatherName(String name) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.fatherName = :name", Form.class)
                    .setParameter("name", name)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByFatherSurname(String surname) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.fatherSurname = :surname", Form.class)
                    .setParameter("surname", surname)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by father surname data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByFatherFatherName(String fatherName) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.fatherFatherName = :fatherName", Form.class)
                    .setParameter("fatherName", fatherName)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by father father name data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByMotherSalary(float minSalary, float maxSalary) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.mother.salary >= :minSalary " +
                            "and f.mother.salary <= :maxSalary", Form.class)
                    .setParameter("minSalary", minSalary)
                    .setParameter("maxSalary", maxSalary)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by mother salary data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByFatherSalary(float minSalary, float maxSalary) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.father.salary >= :minSalary " +
                            "and f.father.salary <= :maxSalary", Form.class)
                    .setParameter("minSalary", minSalary)
                    .setParameter("maxSalary", maxSalary)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by father salary data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByAmountOfSisters(Integer amount) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.numOfSisters = :amount", Form.class)
                    .setParameter("amount", amount)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by amount of sisters data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public List<Form> deleteFormsByAmountOfBrothers(Integer amount) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            List<Form> formEntities = entityManager
                    .createQuery("select f from Form f where f.student.numOfBrothers = :amount", Form.class)
                    .setParameter("amount", amount)
                    .getResultList();
            formEntities.forEach(x -> entityManager.remove(x));
            entityTransaction.commit();
            return formEntities;
        }
        catch (Exception e){
            System.out.println("Deleting by amount of brothers data error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }

    @Override
    @Transactional
    public void setForm(String studentName, String studentSurname, String studentFatherName,
                        String fatherName, String fatherSurname, String fatherFatherName,
                        String motherName, String motherSurname, String motherFatherName,
                        int amountOfSisters, int amountOfBrothers,
                        float fatherSalary, float motherSalary) {
        try{
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            Student student = new Student();
            student.setStudentName(studentName);
            student.setStudentSurname(studentSurname);
            student.setStudentFatherName(studentFatherName);
            student.setNumOfBrothers(amountOfBrothers);
            student.setNumOfSisters(amountOfSisters);
            entityManager.persist(student);
            entityTransaction.commit();
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            Father father = new Father();
            father.setFatherName(fatherName);
            father.setFatherSurname(fatherSurname);
            father.setFatherFatherName(fatherFatherName);
            father.setSalary(fatherSalary);
            entityManager.persist(father);
            entityTransaction.commit();
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            Mother mother = new Mother();
            mother.setMotherName(motherName);
            mother.setMotherSurname(motherSurname);
            mother.setMotherFatherName(motherFatherName);
            mother.setSalary(motherSalary);
            entityManager.persist(mother);
            entityTransaction.commit();
            initEntityManagerFactory();
            initEntityManager();
            initEntityTransaction();
            entityTransaction.begin();
            Form form = new Form();
            form.setFather(father);
            form.setMother(mother);
            form.setStudent(student);
            entityManager.persist(form);
            entityTransaction.commit();
            entityManagerFactory.close();
            entityManager.close();
        }
        catch (Exception e){
            System.out.println("Persistence error:");
            e.printStackTrace();
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
            throw new RuntimeException();
        }
        finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }
    }
    public Executor(){
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
    }
}
