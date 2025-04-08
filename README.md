# Variant 10, Laboratory task 2, Losik Yaroslav

# Problem

Make the application, that is built on MVC pattern and take account of all the forms.

## ```pom.xml```

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>by.losik</groupId>
    <artifactId>lab2ppois4sem</artifactId>
    <version>1.0-SNAPSHOT</version>
    <name>lab2ppois4sem</name>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <junit.version>5.8.2</junit.version>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>17.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-fxml</artifactId>
            <version>17.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.controlsfx</groupId>
            <artifactId>controlsfx</artifactId>
            <version>11.1.1</version>
        </dependency>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-media</artifactId>
            <version>17.0.1</version>
        </dependency>
        <dependency>
            <groupId>com.dlsc.formsfx</groupId>
            <artifactId>formsfx-core</artifactId>
            <version>11.3.2</version>
        </dependency>
        <dependency>
            <groupId>net.synedra</groupId>
            <artifactId>validatorfx</artifactId>
            <version>0.2.1</version>
            <exclusions>
                <exclusion>
                    <groupId>org.openjfx</groupId>
                    <artifactId>*</artifactId>
                </exclusion>
                <exclusion>
                    <groupId>jakarta.enterprise</groupId>
                    <artifactId>jakarta.enterprise.cdi-api</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.5.4</version>
        </dependency>
        <dependency>
            <groupId>jakarta.persistence</groupId>
            <artifactId>jakarta.persistence-api</artifactId>
            <version>3.1.0</version>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.26</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>RELEASE</version>
            <scope>compile</scope>
        </dependency>
        <dependency>
            <groupId>org.hibernate.orm</groupId>
            <artifactId>hibernate-core</artifactId>
            <version>6.2.0.Final</version>
        </dependency>
        <dependency>
            <groupId>jakarta.enterprise</groupId>
            <artifactId>jakarta.enterprise.cdi-api</artifactId>
            <version>4.0.1</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-api</artifactId>
            <version>2.0.6</version>
        </dependency>
        <dependency>
            <groupId>ch.qos.logback</groupId>
            <artifactId>logback-classic</artifactId>
            <version>1.4.7</version>
        </dependency>
    </dependencies>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.10.1</version>
                <configuration>
                    <source>17</source>
                    <target>17</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.openjfx</groupId>
                <artifactId>javafx-maven-plugin</artifactId>
                <version>0.0.8</version>
                <executions>
                    <execution>
                        <!-- Default configuration for running with: mvn clean javafx:run -->
                        <id>default-cli</id>
                        <configuration>
                            <mainClass>by.losik.lab2ppois4sem.WindowApplication</mainClass>
                            <launcher>app</launcher>
                            <jlinkZipName>app</jlinkZipName>
                            <jlinkImageName>app</jlinkImageName>
                            <noManPages>true</noManPages>
                            <stripDebug>true</stripDebug>
                            <noHeaderFiles>true</noHeaderFiles>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
</project>
```

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

<?import java.lang.String?>
<?import java.lang.Integer?>
<VBox xmlns="http://javafx.com/javafx/16"
      xmlns:fx="http://javafx.com/fxml/1"
      fx:controller="by.losik.lab2ppois4sem.controller.MainController">
    <padding>
        <Insets bottom="10.0" left="20.0" right="20.0" top="10.0" />
    </padding>
    <TilePane hgap="5">
        <VBox maxWidth="650" spacing="20">
            <Text layoutX="10" layoutY="30" text="Welcome!">
                <font>
                    <Font name="System Italic" size="24.0" />
                </font>
            </Text>
            <Line endX="600" />
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
            <Line endX="600" />
            <TextArea fx:id="textArea" editable="false" maxWidth="600" minHeight="300">
                <tooltip>
                    <Tooltip text="This is where you get the instructions after clicking the buttons. It is not editable" />
                </tooltip>
            </TextArea>
            <Line endX="600" />
        </VBox>
        <VBox spacing="5">
            <TilePane hgap="5">
                <VBox spacing="5">
                    <Label text="Select view option:"/>
                    <ChoiceBox fx:id="treeOrTable" minWidth="70" >
                        <String fx:value="Table"/>
                        <String fx:value="Tree"/>
                        <tooltip>
                            <Tooltip text="Choose to define which view you prefer"/>
                        </tooltip>
                    </ChoiceBox>
                </VBox>
                <VBox spacing="5">
                    <Label text="Select page size:"/>
                    <ChoiceBox fx:id="paginationFactor" minWidth="70">
                        <Integer fx:value="5"/>
                        <Integer fx:value="10"/>
                        <Integer fx:value="15"/>
                        <Integer fx:value="20"/>
                        <tooltip>
                            <Tooltip text="Choose to define the amount of items shown"/>
                        </tooltip>
                    </ChoiceBox>
                </VBox>
            </TilePane>
            <fx:include fx:id="displayView" source="display-view.fxml"/>
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
      fx:controller="by.losik.lab2ppois4sem.controller.OptionsController"
      prefHeight="400.0" prefWidth="600.0">
    <padding>
        <Insets bottom="10.0" left="20.0" right="20.0" top="10.0" />
    </padding>
    <StackPane alignment="TOP_LEFT" minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT">
        <VBox fx:id="vBoxAdd" spacing="20">
            <TilePane minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT" tileAlignment="TOP_LEFT" vgap="20">
                <TilePane minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT">
                    <TextField fx:id="studName" minHeight="20" minWidth="50" promptText="Student name" />
                    <TextField fx:id="studSurname" minHeight="20" minWidth="50" promptText="Student surname" />
                    <TextField fx:id="studFatherName" minHeight="20" minWidth="50" promptText="Student father name" />
                    <TextField fx:id="fatherName" minHeight="20" minWidth="50" promptText="Father name" />
                    <TextField fx:id="fatherSurname" minHeight="20" minWidth="50" promptText="Father name" />
                    <TextField fx:id="fatherFatherName" minHeight="20" minWidth="50" promptText="Father father name" />
                    <TextField fx:id="motherName" minHeight="20" minWidth="50" promptText="Mother name" />
                    <TextField fx:id="motherSurname" minHeight="20" minWidth="50" promptText="Mother name" />
                    <TextField fx:id="motherFatherName" minHeight="20" minWidth="50" promptText="Mother father name" />
                    <TextField fx:id="amountOfBrothers" minHeight="20" minWidth="50" promptText="Brother amount" />
                    <TextField fx:id="amountOfSisters" minHeight="20" minWidth="50" promptText="Sister amount" />
                    <TextField fx:id="fatherSalary" minHeight="20" minWidth="50" promptText="Father salary" />
                    <TextField fx:id="motherSalary" minHeight="20" minWidth="50" promptText="Mother salary" />
                </TilePane>
                <Button fx:id="add" alignment="TOP_LEFT" text="Confirm" onAction="#onAddAction"/>
            </TilePane>
        </VBox>
        <VBox fx:id="vBoxToggle" maxWidth="500" spacing="20" visible="false">
            <GridPane fx:id="radButtons" hgap="5" maxHeight="300" maxWidth="600" vgap="3">
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
            <TilePane maxWidth="600" tileAlignment="TOP_LEFT">
                <StackPane alignment="TOP_LEFT" nodeOrientation="LEFT_TO_RIGHT" >
                    <TilePane fx:id="unaryInput" minHeight="100" minWidth="600" nodeOrientation="LEFT_TO_RIGHT" visible="false">
                        <TextField fx:id="input" minHeight="20" minWidth="50" />
                    </TilePane>
                    <TilePane fx:id="binaryInput" visible="false">
                        <TextField fx:id="input0" minHeight="20" minWidth="50" />
                        <TextField fx:id="input1" minHeight="20" minWidth="50" />
                    </TilePane>
                </StackPane>
                <StackPane fx:id="searchOrDeleteConfirm" alignment="TOP_LEFT" nodeOrientation="LEFT_TO_RIGHT" visible="false">
                    <Button fx:id="search" text="Confirm" onAction="#onSearchAction" visible="false" />
                    <Button fx:id="delete" text="Confirm" onAction="#onDeleteAction" visible="false" />
                </StackPane>
            </TilePane>
        </VBox>
    </StackPane>
</VBox>
```

## Display view

```
<?xml version="1.0" encoding="UTF-8"?>

<?import javafx.scene.control.*?>
<?import javafx.scene.layout.*?>

<VBox xmlns="http://javafx.com/javafx"
      xmlns:fx="http://javafx.com/fxml"
      fx:controller="by.losik.lab2ppois4sem.controller.DisplayController"
      maxHeight="600.0" prefWidth="600.0">
    <StackPane>
        <VBox fx:id="tableBox" prefHeight="600">
            <TableView fx:id="formTableView" maxWidth="600">
                <columns>
                    <TableColumn fx:id="form_id" text="Form id"/>
                    <TableColumn fx:id="student_name" text="Student name"/>
                    <TableColumn fx:id="student_surname" text="Student surname"/>
                    <TableColumn fx:id="student_father_name" text="Student father name"/>
                    <TableColumn fx:id="father_name" text="Father name"/>
                    <TableColumn fx:id="father_surname" text="Father surname"/>
                    <TableColumn fx:id="father_father_name" text="Father father name"/>
                    <TableColumn fx:id="mother_name" text="Mother name"/>
                    <TableColumn fx:id="mother_surname" text="Mother surname"/>
                    <TableColumn fx:id="mother_father_name" text="Mother father name"/>
                    <TableColumn fx:id="father_salary" text="Father salary"/>
                    <TableColumn fx:id="mother_salary" text="Mother salary"/>
                    <TableColumn fx:id="brothers" text="Brothers"/>
                    <TableColumn fx:id="sisters" text="Sisters"/>
                </columns>
                <tooltip>
                    <Tooltip text="This is all data provided with specified action. It is not editable" />
                </tooltip>
            </TableView>
            <TilePane>
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
        <VBox fx:id="treeBox" prefHeight="600" visible="false">
            <TreeView fx:id="treeView" maxWidth="600">
                <tooltip>
                    <Tooltip text="This is all data provided with specified action. It is not editable" />
                </tooltip>
            </TreeView>
        </VBox>
    </StackPane>
</VBox>
```

# Classes

[Link:  https://github.com/pYro-sudo/lab2ppois4sem/tree/main/lab2ppois4sem/src/main/java/by/losik/lab2ppois4sem/viewcontroller](https://github.com/pYro-sudo/lab2ppois4sem/tree/main/lab2ppois4sem/src/main/java/by/losik/lab2ppois4sem)

- ```WindowApplication``` is the main class for launching.
- ```Action``` is used to define the action in controller.
- ```MainController``` is the main controller.
- ```DatabaseController``` is the controller for database persistence operations.
- ```DisplayController``` is the controller for the display.
- ```OptionsController``` is the controller for delegation of CRUD operations.
- ```XMLController``` is the controller for the use of XML parsers.
- ```Form``` is a wrapper for forms.
- ```Student``` is a wrapper for students.
- ```Mother``` is a wrapper for mother.
- ```Father``` is a wrapper for father.
- ```FormService``` is the service for executing persistent operations.
- ```XMLParserService``` is the service for executing I/O operations with XML file.
