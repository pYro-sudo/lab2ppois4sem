package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class Executor implements ExecutorActions{
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    EntityManagerFactory entityManagerFactory;
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
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

    public Executor(){
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
    }
    @Override
    @Transactional
    public List<Form> getAllData() {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findAll", Form.class)
                .getResultList();
        entityTransaction.commit();
        logger.info("Extracting all data");
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByStudentName(String name) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByStudentName", Form.class)
                .setParameter("name", name)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by student name = {}", name);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByStudentSurname(String surname) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByStudentSurname", Form.class)
                .setParameter("surname", surname)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by student surname = {}", surname);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByStudentFatherName(String fatherName) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByStudentFatherName", Form.class)
                .setParameter("fatherName", fatherName)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by student father name = {}", fatherName);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherName(String name) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByMotherName", Form.class)
                .setParameter("name", name)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by mother name = {}", name);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherSurname(String surname) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByMotherSurname", Form.class)
                .setParameter("surname", surname)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by mother surname = {}", surname);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherFatherName(String fatherName) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByMotherFatherName", Form.class)
                .setParameter("fatherName", fatherName)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by mother father name = {}", fatherName);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherName(String name) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByFatherName", Form.class)
                .setParameter("name", name)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by father name = {}", name);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherSurname(String surname) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByFatherSurname", Form.class)
                .setParameter("surname", surname)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by father surname = {}", surname);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherFatherName(String fatherName) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByFatherFatherName", Form.class)
                .setParameter("fatherName", fatherName)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by father father surname = {}", fatherName);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByMotherSalary(float minSalary, float maxSalary) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByMotherSalary", Form.class)
                .setParameter("minSalary", minSalary)
                .setParameter("maxSalary", maxSalary)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by mother salary between {} and {}", minSalary, maxSalary);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByFatherSalary(float minSalary, float maxSalary) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByFatherSalary", Form.class)
                .setParameter("minSalary", minSalary)
                .setParameter("maxSalary", maxSalary)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by father salary between {} and {}", minSalary, maxSalary);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByAmountOfSisters(int amount) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findBySisterAmount", Form.class)
                .setParameter("amount", amount)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by amount of sisters: {}", amount);
        return formEntities;
    }

    @Override
    @Transactional
    public List<Form> getFormsByAmountOfBrothers(int amount) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        List<Form> formEntities = entityManager
                .createNamedQuery("Forms.findByBrotherAmount", Form.class)
                .setParameter("amount", amount)
                .getResultList();
        entityTransaction.commit();
        logger.info("Search by amount of brothers: {}", amount);
        return formEntities;
    }

    @Override
    @Transactional
    public int deleteFormsByStudentName(String name) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByStudentName")
                .setParameter("name", name)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by student name = {}", name);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByStudentSurname(String surname) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByStudentSurname")
                .setParameter("surname", surname)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by mother surname = {}", surname);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByStudentFatherName(String fatherName) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByStudentFatherName")
                .setParameter("fatherName", fatherName)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by student father name = {}", fatherName);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByMotherName(String name) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByMotherName")
                .setParameter("name", name)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by mother name = {}", name);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByMotherSurname(String surname) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByMotherSurname")
                .setParameter("surname", surname)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by mother surname = {}", surname);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByMotherFatherName(String fatherName) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByMotherFatherName")
                .setParameter("fatherName", fatherName)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by mother father name = {}", fatherName);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByFatherName(String name) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByFatherSurname")
                .setParameter("name", name)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by father name = {}", name);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByFatherSurname(String surname) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByFatherSurname")
                .setParameter("surname", surname)
                .executeUpdate();
        logger.info("Deletion by father surname = {}", surname);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByFatherFatherName(String fatherName) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByFatherFatherName")
                .setParameter("fatherName", fatherName)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by father father name = {}", fatherName);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByMotherSalary(float minSalary, float maxSalary) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByMotherSalary")
                .setParameter("maxSalary", maxSalary)
                .setParameter("minSalary", minSalary)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by mother salary between {} and {}", minSalary, maxSalary);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByFatherSalary(float minSalary, float maxSalary) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByFatherSalary")
                .setParameter("maxSalary", maxSalary)
                .setParameter("minSalary", minSalary)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by father salary between {} and {}", minSalary, maxSalary);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByAmountOfSisters(Integer amount) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeBySisterAmount")
                .setParameter("amount", amount)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by amount of sisters: {}", amount);
        return count;
    }

    @Override
    @Transactional
    public int deleteFormsByAmountOfBrothers(Integer amount) {
        initEntityManagerFactory();
        initEntityManager();
        initEntityTransaction();
        entityTransaction.begin();
        int count = entityManager
                .createNamedQuery("Forms.removeByBrotherAmount")
                .setParameter("amount", amount)
                .executeUpdate();
        entityTransaction.commit();
        logger.info("Deletion by amount of brothers: {}", amount);
        return count;
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
            Father father = new Father();
            father.setFatherName(fatherName);
            father.setFatherSurname(fatherSurname);
            father.setFatherFatherName(fatherFatherName);
            father.setSalary(fatherSalary);
            entityManager.persist(father);
            Mother mother = new Mother();
            mother.setMotherName(motherName);
            mother.setMotherSurname(motherSurname);
            mother.setMotherFatherName(motherFatherName);
            mother.setSalary(motherSalary);
            entityManager.persist(mother);
            Form form = new Form();
            form.setFather(father);
            form.setMother(mother);
            form.setStudent(student);
            entityManager.persist(form);
            entityTransaction.commit();
            entityManagerFactory.close();
            entityManager.close();
            logger.info("Insertion of form:\n" + form);
        }
        catch (Exception e){
            logger.error("Persistence error");
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
    }
}
