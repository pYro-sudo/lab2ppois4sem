module by.losik.lab2ppois4sem {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;
    requires org.testng;
    requires org.hibernate.orm.core;
    requires jakarta.transaction;
    requires org.slf4j;

    opens by.losik.lab2ppois4sem.model to org.hibernate.orm.core;

    exports by.losik.lab2ppois4sem.test;
    exports by.losik.lab2ppois4sem.model;
    exports by.losik.lab2ppois4sem.controller;
    opens by.losik.lab2ppois4sem.controller to javafx.fxml, org.hibernate.orm.core;
    exports by.losik.lab2ppois4sem.service;
    opens by.losik.lab2ppois4sem.service to org.hibernate.orm.core;
    exports by.losik.lab2ppois4sem.repository;
    opens by.losik.lab2ppois4sem.repository to org.hibernate.orm.core;
    exports by.losik.lab2ppois4sem;
    opens by.losik.lab2ppois4sem to javafx.fxml, org.hibernate.orm.core;
}