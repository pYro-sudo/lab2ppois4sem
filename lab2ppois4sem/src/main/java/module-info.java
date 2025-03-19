module by.losik.lab2ppois4sem {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.postgresql.jdbc;
    requires jakarta.persistence;
    requires static lombok;
    requires org.testng;
    requires org.hibernate.orm.core;
    requires jakarta.transaction;

    opens by.losik.lab2ppois4sem.model to org.hibernate.orm.core;

    exports by.losik.lab2ppois4sem.test;
    exports by.losik.lab2ppois4sem.model;
    exports by.losik.lab2ppois4sem.viewcontroller;
    opens by.losik.lab2ppois4sem.viewcontroller to javafx.fxml, org.hibernate.orm.core;
}