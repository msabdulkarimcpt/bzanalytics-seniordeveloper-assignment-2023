-- create a table
CREATE TABLE Technology (
  id INTEGER PRIMARY KEY,
  name TEXT NOT NULL
);
-- insert some values
INSERT INTO Technology VALUES (1, 'ML');
INSERT INTO Technology VALUES (2, 'BE');
INSERT INTO Technology VALUES (3, 'FE');
INSERT INTO Technology VALUES (4, 'NT');


CREATE TABLE Employee (
    EmployeeId	INTEGER NOT NULL,
    FirstName	VARCHAR(512),
    LastName	VARCHAR(512),
    Technology	INTEGER,
    StartDate	DATE,
    EndDate	DATE,
    PrimarySKill INT,
    SecondarySKill INT,
    PRIMARY KEY (EmployeeId),
    FOREIGN KEY (Technology) REFERENCES Technology(Id),
    FOREIGN KEY (PrimarySKill) REFERENCES Technology(Id),
    FOREIGN KEY (SecondarySKill) REFERENCES Technology(Id)
);

-- fetch some values
--SELECT * FROM Technology;

INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('1', 'Vivek', 'Nair', '1','2', '09/08/2022', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('2', 'Kareem', 'Adbulla', '2','3', '03/04/2020', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('3', 'Swathy', 'Ravi', '1','undefined', '03/04/2020', '31/03/2022');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('4', 'Ramesh', 'Iyer', '4','undefined', '19/06/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('5', 'Xavier', 'Sebastian', '3', '2', '21/08/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('6', 'Don', 'David', '3', '2', '09/08/2022', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('7', 'Amritha', 'S', '2', '1', '09/08/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('8', 'Kavya', 'Menon', '3', '2','09/08/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('9', 'Merin', 'Anthony', '4', '1', '19/06/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('10', 'Jacob', 'Thomas', '2', '3', '21/08/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('11', 'Hussain', 'Nigam', '1', '3', '14/04/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('12', 'Majid', 'Anwar', '1', '3', '19/06/2021', '17/08/2022');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('13', 'Javed', 'B', '3', 'undefined', '14/04/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('14', 'Suresh', 'Kotha', '2', 'undefined', '14/04/2023', 'undefined');
INSERT INTO Employee (EmployeeId, FirstName, LastName, PrimarySKill, SecondarySKill, StartDate, EndDate) VALUES ('15', 'Bobby', 'M', '3', '2', '03/04/2020', 'undefined');

--SELECT * FROM Employee;

CREATE TABLE Projects 
(
    ProjectId	INT,
    ProjectName	VARCHAR(512),
    PRIMARY KEY (ProjectId)
);

INSERT INTO Projects (ProjectId, ProjectName) VALUES ('1', 'Trade Bot');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('2', 'Car Data Scrapper');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('3', 'BCask');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('4', 'UMart');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('5', 'Sent Intel');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('6', 'CliniQwik');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('7', 'NGO Bot');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('8', 'Z-dic');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('9', 'FurniOS');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('10', 'B-Verse');
INSERT INTO Projects (ProjectId, ProjectName) VALUES ('11', 'NTech');

--SELECT * FROM Projects;

CREATE TABLE ProjectAllocation 
(
    EmployeeId	INT,
    ProjectId	INT,
    StartMonth	INT,
    StartYear	INT,
    EndMonth	INT,
    EndYear	INT,
    FOREIGN KEY (EmployeeId) REFERENCES Employee(EmployeeId),
    FOREIGN KEY (ProjectId) REFERENCES Project(ProjectId)
    
);

INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('1', '7', '08', '2022', '', '');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('2', '1', '04', '2020', '08', '2021');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('2', '3', '09', '2021', '02', '2022');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('2', '4', '05', '2022', '12', '2022');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('2', '6', '02', '2023', '08', '2023');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('3', '1', '04', '2020', '08', '2020');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('3', '2', '09', '2020', '03', '2021');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('3', '5', '04', '2021', '03', '2021');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('4', '10', '06', '2023', '', '');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('9', '10', '06', '2023', '', '');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('6', '8', '08', '2022', '04', '2023');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('6', '6', '04', '2023', '08', '2023');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('8', '9', '08', '2023', '', '');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('11', '11', '04', '2023', '', '');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('12', '5', '06', '2021', '08', '2022');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('13', '8', '04', '2023', '08', '2023');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('14', '8', '04', '2023', '08', '2023');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('15', '1', '04', '2020', '08', '2020');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('15', '3', '09', '2021', '02', '2022');
INSERT INTO ProjectAllocation (EmployeeId, ProjectId, StartMonth, StartYear, EndMonth, EndYear) VALUES ('15', '4', '05', '2022', '12', '2022');

