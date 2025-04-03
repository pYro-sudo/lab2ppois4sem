# Variant 10, Laboratory task 2, Losik Yaroslav

# Problem

Make the application, that is built on MVC pattern and take account on all the forms.

# Tables

## Form (DDL)

```
create table father_info
(
    id                 serial
        primary key,
    father_name        varchar(20) not null,
    father_surname     varchar(20) not null,
    father_father_name varchar(20) not null,
    salary             double precision
        constraint father_info_salary_check
            check (salary >= (0)::double precision)
);
```

## Father (DDL)

```
create table form
(
    id         serial
        primary key,
    student_id integer not null
        references student_info,
    father_id  integer not null
        references father_info,
    mother_id  integer not null
        references mother_info
);
```

## Mother (DDL)

```
create table mother_info
(
    id                 serial
        primary key,
    mother_name        varchar(20) not null,
    mother_surname     varchar(20) not null,
    mother_father_name varchar(20) not null,
    salary             double precision
        constraint mother_info_salary_check
            check (salary >= (0)::double precision)
);
```

## Student (DDL)

```
create table student_info
(
    id                  serial
        primary key,
    student_name        varchar(20),
    student_surname     varchar(20),
    student_father_name varchar(20),
    num_of_sisters      integer
        constraint student_info_num_of_sisters_check
            check (num_of_sisters >= 0),
    num_of_brothers     integer
        constraint student_info_num_of_brothers_check
            check (num_of_brothers >= 0)
);
```

# Used modules

## Modules
```
module by.losik.lab2ppois4sem {
    requires javafx.controls;
    requires javafx.fxml;

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
    exports by.losik.lab2ppois4sem.viewcontroller;
    opens by.losik.lab2ppois4sem.viewcontroller to javafx.fxml, org.hibernate.orm.core;
}
```

# Persistence configuration

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<persistence xmlns="https://jakarta.ee/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="https://jakarta.ee/xml/ns/persistence https://jakarta.ee/xml/ns/persistence/persistence_3_0.xsd"
             version="3.0">
    <persistence-unit name="Form">
        <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
        <class>by.losik.lab2ppois4sem.model.Father</class>
        <class>by.losik.lab2ppois4sem.model.Mother</class>
        <class>by.losik.lab2ppois4sem.model.Student</class>
        <class>by.losik.lab2ppois4sem.model.Form</class>
        <properties>
            <property name="jakarta.persistence.jdbc.url" value="jdbc:postgresql://localhost:5432/lab2ppois4sem"/>
            <property name="jakarta.persistence.jdbc.user" value="#{user}"/>
            <property name="jakarta.persistence.jdbc.password" value="#{password}"/>
            <property name="jakarta.persistence.jdbc.driver" value="org.postgresql.Driver"/>
            <property name="hibernate.dialect" value="org.hibernate.dialect.PostgreSQLDialect"/>
            <property name="hibernate.show_sql" value="true"/>
            <property name="hibernate.format_sql" value="true"/>
            <property name="hibernate.generate_statistics" value="true"/>
            <property name="hibernate.jdbc.batch_size" value="50"/>
            <property name="hibernate.order_inserts" value="true"/>
        </properties>
    </persistence-unit>
</persistence>
```

# View configuration

## Main window

```
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.geometry.*?>
<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>
<?import javafx.scene.shape.*?>
<?import javafx.scene.text.*?>

<VBox xmlns="http://javafx.com/javafx/16"
      xmlns:fx="http://javafx.com/fxml/1"
      fx:controller="by.losik.lab2ppois4sem.viewcontroller.HelloController">
    <padding>
        <Insets bottom="10.0" left="20.0" right="20.0" top="10.0" />
    </padding>
    <TilePane hgap="10">
        <VBox maxWidth="650" spacing="20">
            <Text layoutX="10" layoutY="30" text="Welcome!">
                <font>
                    <Font name="System Italic" size="24.0" />
                </font>
            </Text>
            <Line endX="600" stroke="slategray" strokeLineCap="ROUND" strokeLineJoin="ROUND" strokeWidth="2" />
            <TilePane hgap="10" maxWidth="600">
                <Button maxWidth="70" minWidth="70" onAction="#onHelpButtonClick" text="Help">
                    <tooltip>
                        <Tooltip text="Get help" />
                    </tooltip>
                </Button>
                <Button maxWidth="70" minWidth="70" onAction="#onAddButtonClick" text="Add">
                    <tooltip>
                        <Tooltip text="Click to add new data" />
                    </tooltip>
                </Button>
                <Button maxWidth="70" minWidth="70" onAction="#onSearchButtonClick" text="Search">
                    <tooltip>
                        <Tooltip text="Click to search data" />
                    </tooltip>
                </Button>
                <Button maxWidth="70" minWidth="70" onAction="#onDeleteButtonClick" text="Delete">
                    <tooltip>
                        <Tooltip text="Click to delete data" />
                    </tooltip>
                </Button>
                <Button maxWidth="70" minWidth="70" onAction="#onShowAllAction" text="Show all">
                    <tooltip>
                        <Tooltip text="Click to see all rows" />
                    </tooltip>
                </Button>
                <Button maxWidth="70" minWidth="70" onAction="#onSaveXMLAction" text="Save XML">
                    <tooltip>
                        <Tooltip text="Click to save the data in XML" />
                    </tooltip>
                </Button>
                <Button maxWidth="80" minWidth="70" onAction="#onShowXMLAction" text="Show XML">
                    <tooltip>
                        <Tooltip text="Click to see the data in XML" />
                    </tooltip>
                </Button>
            </TilePane>
            <Line endX="600" stroke="slategray" strokeLineCap="ROUND" strokeLineJoin="ROUND" strokeWidth="2" />
            <TextArea fx:id="textArea" editable="false" maxWidth="600" minHeight="100">
                <tooltip>
                    <Tooltip text="This is where you get the instructions after clicking the buttons. It is not editable" />
                </tooltip>
            </TextArea>
            <Line endX="600" stroke="slategray" strokeLineCap="ROUND" strokeLineJoin="ROUND" strokeWidth="2" />
        </VBox>
        <VBox maxWidth="700" spacing="10">
            <TilePane>
                <ChoiceBox fx:id="choice" maxWidth="70" minWidth="70">
                    <tooltip>
                        <Tooltip text="Click it twice to see the views." />
                    </tooltip>
                </ChoiceBox>
                <ChoiceBox fx:id="factorChoice" maxWidth="70" minWidth="70">
                    <tooltip>
                        <Tooltip text="Click it twice to see the factors." />
                    </tooltip>
                </ChoiceBox>
            </TilePane>
            <StackPane fx:id="treeOrTable">
                <VBox fx:id="tableBox" maxHeight="600" visible="false">
                    <TableView fx:id="formTableView" maxWidth="600">
                        <tooltip>
                            <Tooltip text="This is all data provided with specified action. It is not editable" />
                        </tooltip>
                    </TableView>
                    <TilePane fx:id="navigableTile" visible="false">
                        <Button onAction="#jumpToFirst" text="First" maxWidth="70" minWidth="70">
                            <tooltip>
                                <Tooltip text="Click to move to the first page." />
                            </tooltip>
                        </Button>
                        <Button onAction="#moveToPrevious" text="Previous" maxWidth="70" minWidth="70">
                            <tooltip>
                                <Tooltip text="Click to move to the previous page." />
                            </tooltip>
                        </Button>
                        <TextField fx:id="shownPage" maxWidth="50" minWidth="50" maxHeight="20" minHeight="20" text="0" editable="false">
                            <tooltip>
                                <Tooltip text="The current page." />
                            </tooltip>
                        </TextField>
                        <Button onAction="#moveToNext" text="Next" maxWidth="70" minWidth="70">
                            <tooltip>
                                <Tooltip text="Click to move to the next page." />
                            </tooltip>
                        </Button>
                        <Button onAction="#jumpToLast" text="Last" maxWidth="70" minWidth="70">
                            <tooltip>
                                <Tooltip text="Click to move to the last page." />
                            </tooltip>
                        </Button>
                    </TilePane>
                </VBox>
                <VBox fx:id="treeBox" maxHeight="600" visible="false">
                    <TreeView fx:id="treeView" maxWidth="600">
                        <tooltip>
                            <Tooltip text="This is all data provided with specified action. It is not editable" />
                        </tooltip>
                    </TreeView>
                </VBox>
            </StackPane>
        </VBox>
    </TilePane>
</VBox>
```

## Options window 

```
<?xml version="1.0" encoding="UTF-8"?>


<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<?import javafx.geometry.Insets?>
<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      prefHeight="400.0" prefWidth="600.0">
    <padding>
        <Insets bottom="10.0" left="20.0" right="20.0" top="10.0" />
    </padding>
    <StackPane fx:id="stackPane" alignment="TOP_LEFT" minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT">
        <VBox fx:id="vBoxAdd" spacing="20" visible="false">
            <TilePane fx:id="addTile" minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT" tileAlignment="TOP_LEFT" vgap="20" visible="false">
                <TilePane fx:id="tilePane" minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT">
                    <TextField fx:id="studName" minHeight="20" minWidth="50" promptText="Student name" />
                    <TextField fx:id="studSurname" minHeight="20" minWidth="50" promptText="Student surname" />
                    <TextField fx:id="studFatherName" minHeight="20" minWidth="50" promptText="Student father name" />
                    <TextField fx:id="fatherName" minHeight="20" minWidth="50" promptText="Father name" />
                    <TextField fx:id="fatherSurname" minHeight="20" minWidth="50" promptText="Father name" />
                    <TextField fx:id="fatherFatherName" minHeight="20" minWidth="50" promptText="Father name" />
                    <TextField fx:id="motherName" minHeight="20" minWidth="50" promptText="Mother name" />
                    <TextField fx:id="motherSurname" minHeight="20" minWidth="50" promptText="Mother name" />
                    <TextField fx:id="motherFatherName" minHeight="20" minWidth="50" promptText="Mother name" />
                    <TextField fx:id="amountOfBrothers" minHeight="20" minWidth="50" promptText="Brother amount" />
                    <TextField fx:id="amountOfSisters" minHeight="20" minWidth="50" promptText="Sister amount" />
                    <TextField fx:id="fatherSalary" minHeight="20" minWidth="50" promptText="Father salary" />
                    <TextField fx:id="motherSalary" minHeight="20" minWidth="50" promptText="Mother salary" />
                </TilePane>
                <Button fx:id="execute" alignment="TOP_LEFT" text="Confirm" visible="false" />
            </TilePane>
        </VBox>
        <VBox fx:id="vBoxToggle" maxWidth="500" spacing="20" visible="false">
            <GridPane fx:id="radButtons" hgap="5" maxHeight="300" maxWidth="600" vgap="3" visible="false">
                <RadioButton fx:id="radStudentName" alignment="TOP_LEFT" text="Student name" GridPane.columnIndex="0" GridPane.rowIndex="0" />
                <RadioButton fx:id="radStudentSurname" alignment="TOP_LEFT" text="Student surname" GridPane.columnIndex="0" GridPane.rowIndex="1" />
                <RadioButton fx:id="radStudentFatherName" alignment="TOP_LEFT" text="Student father name" GridPane.columnIndex="0" GridPane.rowIndex="2" />
                <RadioButton fx:id="radFatherName" alignment="TOP_LEFT" text="Father name" GridPane.columnIndex="1" GridPane.rowIndex="0" />
                <RadioButton fx:id="radFatherSurname" alignment="TOP_LEFT" text="Father surname" GridPane.columnIndex="1" GridPane.rowIndex="1" />
                <RadioButton fx:id="radFatherFatherName" alignment="TOP_LEFT" text="Father father name" GridPane.columnIndex="1" GridPane.rowIndex="2" />
                <RadioButton fx:id="radMotherName" alignment="TOP_LEFT" text="Mother name" GridPane.columnIndex="2" GridPane.rowIndex="0" />
                <RadioButton fx:id="radMotherSurname" alignment="TOP_LEFT" text="Mother surname" GridPane.columnIndex="2" GridPane.rowIndex="1" />
                <RadioButton fx:id="radMotherFatherName" alignment="TOP_LEFT" text="Mother father name" GridPane.columnIndex="2" GridPane.rowIndex="2" />
                <RadioButton fx:id="radNumOfBrothers" alignment="TOP_LEFT" text="Brother amount" GridPane.columnIndex="0" GridPane.rowIndex="3" />
                <RadioButton fx:id="radNumOfSisters" alignment="TOP_LEFT" text="Sister amount" GridPane.columnIndex="0" GridPane.rowIndex="4" />
                <RadioButton fx:id="radFatherSalary" alignment="TOP_LEFT" text="Father salary" GridPane.columnIndex="1" GridPane.rowIndex="3" />
                <RadioButton fx:id="radMotherSalary" alignment="TOP_LEFT" text="Mother salary" GridPane.columnIndex="2" GridPane.rowIndex="3" />
            </GridPane>
            <TilePane fx:id="searchOrDeleteInput" maxWidth="600" tileAlignment="TOP_LEFT" vgap="-60" visible="false">
                <StackPane fx:id="searchOrDeletePane" alignment="TOP_LEFT" nodeOrientation="LEFT_TO_RIGHT" visible="false">
                    <TilePane fx:id="unaryInput" minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT" visible="false">
                        <TextField fx:id="input" minHeight="20" minWidth="50" />
                    </TilePane>
                    <TilePane fx:id="binaryInput" visible="false">
                        <TextField fx:id="input0" minHeight="20" minWidth="50" />
                        <TextField fx:id="input1" minHeight="20" minWidth="50" />
                    </TilePane>
                </StackPane>
                <StackPane fx:id="searchOrDeleteConfirm" alignment="TOP_LEFT" nodeOrientation="LEFT_TO_RIGHT" visible="false">
                    <Button fx:id="search" text="Confirm" visible="false" />
                    <Button fx:id="delete" text="Confirm" visible="false" />
                </StackPane>
            </TilePane>
        </VBox>
    </StackPane>
</VBox>
```

# Classes

Link:  https://github.com/pYro-sudo/lab2ppois4sem/tree/main/lab2ppois4sem/src/main/java/by/losik/lab2ppois4sem/model

- ```Executor``` used for executing queries.
- ```ExecutorActions``` used as an interface of ```Executor```.
- ```Form``` is a wrapper for forms.
- ```Student``` is a wrapper for students.
- ```Mother``` is a wrapper for mother.
- ```Father``` is a wrapper for father.

Link:  https://github.com/pYro-sudo/lab2ppois4sem/tree/main/lab2ppois4sem/src/main/java/by/losik/lab2ppois4sem/viewcontroller

- ```Action``` is used to define the action in controller.
- ```HelloController``` is a controller.
- ```HelloApplication``` is the main class for launching.
