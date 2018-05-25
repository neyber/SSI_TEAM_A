/******************************************************************************
**  Name: schema team A
**  Desc: add sentences to create tables for all tables for our system
**
**  Author: Henry Bustamante
**
**  Date: 05/24/2018
*******************************************************************************/
/******************************************************************************
**  Name: schema team A
**  Desc: add sentences to create tables for all tables for our system
**
**  Modified: Marcelo Loayza
**  Added: Department, Role, Employee, Function Manual, Audit, SafetyRule, FileDocument
**  Date: 05/24/2018
*******************************************************************************/

-- Create Department

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Department')
)
BEGIN
	CREATE TABLE Department(Id INT IDENTITY(1,1) NOT NULL
					,createdOn DATETIME NOT NULL
					,updatedOn DATETIME NOT NULL
					,isDeleted BIT
					,version BIGINT
					,description VARCHAR(100) NOT NULL

					CONSTRAINT PK_DepartmentId PRIMARY KEY (Id)
	);
	ALTER TABLE [dbo].[Department] ADD CONSTRAINT [DF_Department_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
	ALTER TABLE [dbo].[Department] ADD CONSTRAINT [DF_Department_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
  ALTER TABLE [dbo].[Department] ADD CONSTRAINT [DF_Department_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table Department created!';
END
ELSE
 BEGIN
  PRINT 'Table Department already exists into the database';
 END
GO

-- Create Role

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Role')
)
BEGIN
	CREATE TABLE Role(Id INT IDENTITY(1,1) NOT NULL
				,createdOn DATETIME NOT NULL
				,updatedOn DATETIME NOT NULL
                ,isDeleted BIT
                ,version BIGINT
				,description VARCHAR(100) NOT NULL
				,name VARCHAR(50) NOT NULL

	CONSTRAINT PK_RoleId PRIMARY KEY (Id)
	);
	ALTER TABLE [dbo].[Role] ADD CONSTRAINT [DF_Role_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
	ALTER TABLE [dbo].[Role] ADD CONSTRAINT [DF_Role_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
  ALTER TABLE [dbo].[Role] ADD CONSTRAINT [DF_Role_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table Role created!';
END
ELSE
 BEGIN
  PRINT 'Table Role already exists into the database';
 END
GO


-- Create Employee

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Employee')
)
BEGIN
	CREATE TABLE Employee(Id INT IDENTITY(1,1) NOT NULL
					,createdOn DATETIME NOT NULL
					,updatedOn DATETIME NOT NULL
					,isDeleted BIT
					,version BIGINT
					,dateOfBirt DATE NOT NULL
					,firstName VARCHAR(50) NOT NULL
					,gender VARCHAR(50) NOT NULL
					,healthConditionStartingAtCompany VARCHAR(100) NOT NULL
					,indentificationNumber INT NOT NULL
					,lastName VARCHAR(50) NOT NULL
					,startDateInCompany VARCHAR(50) NOT NULL
					,departmentEmployeeId INT NOT NULL
					,photoFileDocumentId INT NOT NULL
					,RoleEmployeeId INT NOT NULL
					,SupervisorId INT NOT NULL

					CONSTRAINT PK_EmployeeId PRIMARY KEY (Id)
	);
	 ALTER TABLE [dbo].[Employee] ADD CONSTRAINT [DF_Employee_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
   ALTER TABLE [dbo].[Employee] ADD CONSTRAINT [DF_Employee_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
   ALTER TABLE [dbo].[Employee] ADD CONSTRAINT [DF_Employee_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table SaCategory created!';
END
ELSE
 BEGIN
  PRINT 'Table SaCategory already exists into the database';
 END
GO


-- Create Audit

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Audit')
)
BEGIN
	CREATE TABLE Audit(Id INT IDENTITY(1,1) NOT NULL
				,createdOn DATETIME NOT NULL
				,updatedOn DATETIME NOT NULL
                ,isDeleted BIT
                ,version BIGINT
				,auditCode INT NOT NULL
				,auditCriteria VARCHAR(100) NOT NULL
				,auditName VARCHAR(50) NOT NULL
				,auditObjective VARCHAR(100) NOT NULL
				,auditScope VARCHAR(100) NOT NULL
				,auditType VARCHAR(50) NOT NULL
				,employeeId INT NOT NULL
				,periodicity VARCHAR(50) NOT NULL
				,DepartmentId INT NOT NULL

				CONSTRAINT PK_AuditId PRIMARY KEY (Id)
	);
	ALTER TABLE [dbo].[Audit] ADD CONSTRAINT [DF_Audit_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
	ALTER TABLE [dbo].[Audit] ADD CONSTRAINT [DF_Audit_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
  ALTER TABLE [dbo].[Audit] ADD CONSTRAINT [DF_Audit_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table Audit created!';
END
ELSE
 BEGIN
  PRINT 'Table Audit already exists into the database';
 END
GO


-- Create SafetyRule
IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.SafetyRule')
)
BEGIN
	CREATE TABLE SafetyRule(Id INT IDENTITY(1,1) NOT NULL
						,createdOn DATETIME NOT NULL
						,updatedOn DATETIME NOT NULL
						,isDeleted BIT
						,version BIGINT
						,accomplishment VARCHAR(50) NOT NULL
						,auditId VARCHAR(50) NOT NULL
						,complianceMetric VARCHAR(50) NOT NULL
						,complianceParameter VARCHAR(50) NOT NULL
						,policyCode VARCHAR(50) NOT NULL
						,policyName VARCHAR(50) NOT NULL

						CONSTRAINT PK_SafetyRuleId PRIMARY KEY (Id)
	);
	ALTER TABLE [dbo].[SafetyRule] ADD CONSTRAINT [DF_SafetyRule_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
	ALTER TABLE [dbo].[SafetyRule] ADD CONSTRAINT [DF_SafetyRule_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
  ALTER TABLE [dbo].[SafetyRule] ADD CONSTRAINT [DF_SafetyRule_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table SafetyRule created!';
END
ELSE
 BEGIN
  PRINT 'Table SafetyRule already exists into the database';
 END
GO


-- Create Function Manual
IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.FunctionManual')
)
BEGIN
	CREATE TABLE FunctionManual(Id INT IDENTITY(1,1) NOT NULL
							,createdOn DATETIME NOT NULL
							,updatedOn DATETIME NOT NULL
							,isDeleted BIT
							,version BIGINT
							,dependentPersonal VARCHAR(200) NOT NULL
							,externalRelation VARCHAR(200) NOT NULL
							,generalActivity VARCHAR(100) NOT NULL
							,hierarchicalLevel VARCHAR(50) NOT NULL
							,internalRelation VARCHAR(200) NOT NULL
							,name VARCHAR(50) NOT NULL
							,position VARCHAR(50) NOT NULL
							,principalFunction VARCHAR(100) NOT NULL
							,superiorBoss VARCHAR(50) NOT NULL
							,roleFunctionId INT NOT NULL

							CONSTRAINT PK_FunctionManualId PRIMARY KEY (Id)
	);
	ALTER TABLE [dbo].[FunctionManual] ADD CONSTRAINT [DF_FunctionManual_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
	ALTER TABLE [dbo].[FunctionManual] ADD CONSTRAINT [DF_FunctionManual_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
    ALTER TABLE [dbo].[FunctionManual] ADD CONSTRAINT [DF_FunctionManual_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table FunctionManual created!';
END
ELSE
 BEGIN
  PRINT 'Table FunctionManual already exists into the database';
 END
GO

-- Create File Document
IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.FileDocument')
)
BEGIN
	CREATE TABLE FileDocument(Id INT IDENTITY(1,1) NOT NULL
						,createdOn DATETIME NOT NULL
						,updatedOn DATETIME NOT NULL
						,isDeleted BIT
						,version BIGINT
						,contentType VARCHAR(50) NOT NULL
						,data VARCHAR(250) NOT NULL
						,fileName VARCHAR(50) NOT NULL
						,size VARCHAR(50) NOT NULL

						CONSTRAINT PK_FileDocumentId PRIMARY KEY (Id)
	);
	ALTER TABLE [dbo].[FileDocument] ADD CONSTRAINT [DF_FileDocument_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [CreatedOn];
	ALTER TABLE [dbo].[FileDocument] ADD CONSTRAINT [DF_FileDocument_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [UpdatedOn];
  ALTER TABLE [dbo].[FileDocument] ADD CONSTRAINT [DF_FileDocument_IsDeleted]  DEFAULT (0) FOR [IsDeleted]

	PRINT 'Table FileDocument created!';
END
ELSE
 BEGIN
  PRINT 'Table FileDocument already exists into the database';
 END
GO


--Create table SaCategory

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.SaCategory')
)
BEGIN
CREATE TABLE SaCategory (Id INT IDENTITY(1,1) NOT NULL
                    , category VARCHAR(50) CONSTRAINT NN_Category NOT NULL
					          , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
                    , reference VARCHAR(200) CONSTRAINT NN_Reference NOT NULL
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_SaCategory PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[SaCategory] ADD CONSTRAINT [DF_SaCategory_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[SaCategory] ADD CONSTRAINT [DF_SaCategory_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[SaCategory] ADD CONSTRAINT [DF_SaCategory_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table SaCategory created!';
END
ELSE
	BEGIN
		PRINT 'Table SaCategory already exists into the database';
	END
GO

--Create table SaType

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.SaType')
)
BEGIN
CREATE TABLE SaType (Id INT IDENTITY(1,1) NOT NULL
                    , type VARCHAR(200) CONSTRAINT NN_Type NOT NULL
					          , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_SaType PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[SaType] ADD CONSTRAINT [DF_SaType_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[SaType] ADD CONSTRAINT [DF_SaType_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[SaType] ADD CONSTRAINT [DF_SaType_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table SaType created!';
END
ELSE
	BEGIN
		PRINT 'Table SaType already exists into the database';
	END
GO

--Create table Accident

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Accident')
)
BEGIN
CREATE TABLE Accident (Id INT IDENTITY(1,1) NOT NULL
					          , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
					          , dateAccident DATETIME CONSTRAINT NN_DateAccident NOT NULL
                    , statusRecord BIT CONSTRAINT NN_StatusRecrod DEFAULT 0 NOT NULL
					          , whereOcurr VARCHAR(100) CONSTRAINT NN_WhereOcurr NOT NULL
					          , totalDaysOutOfWork INT CONSTRAINT NN_TotalDaysOutOfWork NOT NULL
					          , totalDaysRestrictedTrasnferredWork INT CONSTRAINT NN_TotalDaysRestrictedTrasnferredWork NOT NULL
                    , employeeId INT
                    , saCategoryId INT
                    , saTypeId INT
					          , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_Accident PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[Accident] ADD CONSTRAINT [DF_Accident_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[Accident] ADD CONSTRAINT [DF_Accident_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[Accident] ADD CONSTRAINT [DF_Accident_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table Accident created!';
END
ELSE
	BEGIN
		PRINT 'Table Accident already exists into the database';
	END
GO


--Create table Sickness

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Sickness')
)
BEGIN
CREATE TABLE Sickness (Id INT IDENTITY(1,1) NOT NULL
					          , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
					          , dateSickness DATETIME CONSTRAINT NN_DateSickness NOT NULL
                    , statusRecord BIT CONSTRAINT NN_SicknessStatusRecrod DEFAULT 0 NOT NULL
					          , whereOcurr VARCHAR(100) CONSTRAINT NN_WhereOcurr NOT NULL
					          , totalDaysOutOfWork INT CONSTRAINT NN_TotalDaysOutOfWork NOT NULL
					          , totalDaysRestrictedTrasnferredWork INT CONSTRAINT NN_TotalDaysRestrictedTrasnferredWork NOT NULL
                    , employeeId INT
                    , saCategoryId INT
                    , saTypeId INT
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_Sickness PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[Sickness] ADD CONSTRAINT [DF_Sickness_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[Sickness] ADD CONSTRAINT [DF_Sickness_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[Sickness] ADD CONSTRAINT [DF_Sickness_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table Sickness created!';
END
ELSE
	BEGIN
		PRINT 'Table Sickness already exists into the database';
	END
GO

/*** equipment assignment relations tables ****/
--Create table PpeClassification

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.PpeClassification')
)
BEGIN
CREATE TABLE PpeClassification (Id INT IDENTITY(1,1) NOT NULL
					          , name VARCHAR(100) CONSTRAINT NN_Name NOT NULL
					          , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_PpeClassification PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[PpeClassification] ADD CONSTRAINT [DF_PpeClassification_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[PpeClassification] ADD CONSTRAINT [DF_PpeClassification_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[PpeClassification] ADD CONSTRAINT [DF_PpeClassification_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table PpeClassification created!';
END
ELSE
	BEGIN
		PRINT 'Table PpeClassification already exists into the database';
	END
GO

--Create table Ppe

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.Ppe')
)
BEGIN
CREATE TABLE Ppe (Id INT IDENTITY(1,1) NOT NULL
					          , name VARCHAR(100) CONSTRAINT NN_Name NOT NULL
					          , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
                    , ppeClassificationId INT
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_Ppe PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[Ppe] ADD CONSTRAINT [DF_Ppe_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[Ppe] ADD CONSTRAINT [DF_Ppe_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[Ppe] ADD CONSTRAINT [DF_Ppe_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table Ppe created!';
END
ELSE
	BEGIN
		PRINT 'Table Ppe already exists into the database';
	END
GO

--Create table ExistingPpe

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.ExistingPpe')
)
BEGIN
CREATE TABLE ExistingPpe (Id INT IDENTITY(1,1) NOT NULL
					          , detail VARCHAR(200) CONSTRAINT NN_Detail NOT NULL
					          , purchaseDate DATETIME CONSTRAINT NN_PurchaseDate NOT NULL
                    , lifeTimeDays INT CONSTRAINT NN_LifeTimeDays NOT NULL
                    , currentLifeTimeDays INT CONSTRAINT NN_CurrentLifeTimeDays NOT NULL
                    , ppeId INT
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_ExistingPpe PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[ExistingPpe] ADD CONSTRAINT [DF_ExistingPpe_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[ExistingPpe] ADD CONSTRAINT [DF_ExistingPpe_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[ExistingPpe] ADD CONSTRAINT [DF_ExistingPpe_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table ExistingPpe created!';
END
ELSE
	BEGIN
		PRINT 'Table ExistingPpe already exists into the database';
	END
GO

--Create table ExistingPpeAssigned

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.ExistingPpeAssigned')
)
BEGIN
CREATE TABLE ExistingPpeAssigned (Id INT IDENTITY(1,1) NOT NULL
					          , assignedNotes VARCHAR(200) CONSTRAINT NN_AssignedNotes NOT NULL
					          , assignedDate DATETIME CONSTRAINT NN_AssignedDate NOT NULL
					          , returnNotes VARCHAR(200) CONSTRAINT NN_ReturnNotes NOT NULL
                    , returnDate DATETIME CONSTRAINT NN_ReturnDate NOT NULL
                    , existingPpeId INT
                    , employeeId INT
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_ExistingPpeAssigned PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[ExistingPpeAssigned] ADD CONSTRAINT [DF_ExistingPpeAssigned_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[ExistingPpeAssigned] ADD CONSTRAINT [DF_ExistingPpeAssigned_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[ExistingPpeAssigned] ADD CONSTRAINT [DF_ExistingPpeAssigned_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table ExistingPpeAssigned created!';
END
ELSE
	BEGIN
		PRINT 'Table ExistingPpeAssigned already exists into the database';
	END
GO


/******** existing work item *****/
--Create table WorkItemClassification

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.WorkItemClassification')
)
BEGIN
CREATE TABLE WorkItemClassification (Id INT IDENTITY(1,1) NOT NULL
					          , name VARCHAR(100) CONSTRAINT NN_Name NOT NULL
                    , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_WorkItemClassification PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[WorkItemClassification] ADD CONSTRAINT [DF_WorkItemClassification_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[WorkItemClassification] ADD CONSTRAINT [DF_WorkItemClassification_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[WorkItemClassification] ADD CONSTRAINT [DF_WorkItemClassification_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table WorkItemClassification created!';
END
ELSE
	BEGIN
		PRINT 'Table WorkItemClassification already exists into the database';
	END
GO

--Create table WorkItem

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.WorkItem')
)
BEGIN
CREATE TABLE WorkItem (Id INT IDENTITY(1,1) NOT NULL
					          , name VARCHAR(100) CONSTRAINT NN_Name NOT NULL
                    , description VARCHAR(200) CONSTRAINT NN_Description NOT NULL
                    , workItemClassificationId INT
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_WorkItem PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[WorkItem] ADD CONSTRAINT [DF_WorkItem_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[WorkItem] ADD CONSTRAINT [DF_WorkItem_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[WorkItem] ADD CONSTRAINT [DF_WorkItem_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table WorkItem created!';
END
ELSE
	BEGIN
		PRINT 'Table WorkItem already exists into the database';
	END
GO

--Create table ExistingWorkItem

IF NOT EXISTS (SELECT *
   FROM sys.[objects]
   WHERE Type = 'U'
   AND object_id = OBJECT_ID('dbo.ExistingWorkItem')
)
BEGIN
CREATE TABLE ExistingWorkItem (Id INT IDENTITY(1,1) NOT NULL
                    , detail VARCHAR(100) CONSTRAINT NN_Detail NOT NULL
                    , purchaseDate DATETIME CONSTRAINT NN_PurchaseDate NOT NULL
                    , serieNo VARCHAR(50) CONSTRAINT NN_SerieNo NOT NULL
                    , workItemId INT
                    , createdOn DATETIME NOT NULL
					          , updatedOn DATETIME NOT NULL
                    , isDeleted BIT
                    , version BIGINT
                    CONSTRAINT PK_ExistingWorkItem PRIMARY KEY(
                        [Id]
                    ));

                    ALTER TABLE [dbo].[ExistingWorkItem] ADD CONSTRAINT [DF_ExistingWorkItem_CreatedOn]  DEFAULT (GETUTCDATE()) FOR [createdOn];
		                ALTER TABLE [dbo].[ExistingWorkItem] ADD CONSTRAINT [DF_ExistingWorkItem_UpdatedOn]  DEFAULT (GETUTCDATE()) FOR [updatedOn];
                    ALTER TABLE [dbo].[ExistingWorkItem] ADD CONSTRAINT [DF_ExistingWorkItem_IsDeleted]  DEFAULT (0) FOR [isDeleted]
					PRINT 'Table ExistingWorkItem created!';
END
ELSE
	BEGIN
		PRINT 'Table ExistingWorkItem already exists into the database';
	END
GO


/******* Department ****/
-- Define the relationship between Employee and Department.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employee_Department]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Department]'))
	ALTER TABLE [dbo].[Employee]  WITH CHECK ADD CONSTRAINT [FK_Employee_Department] FOREIGN KEY(ID)
	REFERENCES [dbo].[Department] (ID)
GO
	ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Department]
GO

-- Define the relationship between Audit and Department.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Audit_Department]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Department]'))
	ALTER TABLE [dbo].[Audit]  WITH CHECK ADD CONSTRAINT [FK_Audit_Department] FOREIGN KEY(ID)
	REFERENCES [dbo].[Department] (ID)
GO
	ALTER TABLE [dbo].[Audit] CHECK CONSTRAINT [FK_Audit_Department]
GO

/******* Role ****/
-- Define the relationship between Employee and Role.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employee_Role]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Role]'))
	ALTER TABLE [dbo].[Employee]  WITH CHECK ADD CONSTRAINT [FK_Employee_Role] FOREIGN KEY(ID)
	REFERENCES [dbo].[Role] (ID)
GO
	ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Role]
GO

-- Define the relationship between FunctionManual and Role.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_FunctionManual_Role]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Role]'))
	ALTER TABLE [dbo].[FunctionManual]  WITH CHECK ADD CONSTRAINT [FK_FunctionManual_Role] FOREIGN KEY(ID)
	REFERENCES [dbo].[Role] (ID)
GO
	ALTER TABLE [dbo].[FunctionManual] CHECK CONSTRAINT [FK_FunctionManual_Role]
GO

/******* Audit ****/
-- Define the relationship between SafetyRule and Audit.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_SafetyRule_Audit]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Audit]'))
	ALTER TABLE [dbo].[SafetyRule]  WITH CHECK ADD CONSTRAINT [FK_SafetyRule_Audit] FOREIGN KEY(ID)
	REFERENCES [dbo].[Audit] (ID)
GO
	ALTER TABLE [dbo].[SafetyRule] CHECK CONSTRAINT [FK_SafetyRule_Audit]
GO

/******* Employee ****/
-- Define the relationship between Audit and Employee.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Audit_Employee]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Employee]'))
	ALTER TABLE [dbo].[Audit]  WITH CHECK ADD CONSTRAINT [FK_Audit_Employee] FOREIGN KEY(ID)
	REFERENCES [dbo].[Employee] (ID)
GO
	ALTER TABLE [dbo].[Audit] CHECK CONSTRAINT [FK_Audit_Employee]
GO

/******* FileDocument ****/
-- Define the relationship between Employee and FileDocument.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employee_FileDocument]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[FileDocument]'))
	ALTER TABLE [dbo].[Employee]  WITH CHECK ADD CONSTRAINT [FK_Employee_FileDocument] FOREIGN KEY(ID)
	REFERENCES [dbo].[FileDocument] (ID)
GO
	ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_FileDocument]
GO


/******* ACCIDENT FOREIGN KEYS ********/
-- Define the relationship between Accident and SaCategory.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_SaCategory_Accident]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Accident]'))
ALTER TABLE [dbo].[Accident]  WITH CHECK ADD
       CONSTRAINT [FK_SaCategory_Accident] FOREIGN KEY([saCategoryId])
REFERENCES [dbo].[SaCategory] ([Id])
GO
ALTER TABLE [dbo].[Accident] CHECK
       CONSTRAINT [FK_SaCategory_Accident]

-- Define the relationship between Accident and SaType.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_SaType_Accident]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Accident]'))
ALTER TABLE [dbo].[Accident]  WITH CHECK ADD
       CONSTRAINT [FK_SaType_Accident] FOREIGN KEY([saTypeId])
REFERENCES [dbo].[SaType] ([Id])
GO
ALTER TABLE [dbo].[Accident] CHECK
       CONSTRAINT [FK_SaType_Accident]

 -- Define the relationship between Accident and Employee.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employe_Accident]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Accident]'))
ALTER TABLE [dbo].[Accident]  WITH CHECK ADD
       CONSTRAINT [FK_Employe_Accident] FOREIGN KEY([employeeId])
REFERENCES [dbo].[Employee] ([Id])
GO
ALTER TABLE [dbo].[Accident] CHECK
       CONSTRAINT [FK_Employe_Accident]

/******* SICKNESS FOREIGN KEYS ********/
-- Define the relationship between Sickness and SaCategory.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_SaCategory_Sickness]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Sickness]'))
ALTER TABLE [dbo].[Sickness]  WITH CHECK ADD
       CONSTRAINT [FK_SaCategory_Sickness] FOREIGN KEY([saCategoryId])
REFERENCES [dbo].[SaCategory] ([Id])
GO
ALTER TABLE [dbo].[Sickness] CHECK
       CONSTRAINT [FK_SaCategory_Sickness]

-- Define the relationship between Sickness and SaType.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_SaType_Sickness]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Sickness]'))
ALTER TABLE [dbo].[Sickness]  WITH CHECK ADD
       CONSTRAINT [FK_SaType_Sickness] FOREIGN KEY([saTypeId])
REFERENCES [dbo].[SaType] ([Id])
GO
ALTER TABLE [dbo].[Sickness] CHECK
       CONSTRAINT [FK_SaType_Sickness]

 -- Define the relationship between Sickness and Employee.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employe_Sickness]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Sickness]'))
ALTER TABLE [dbo].[Sickness]  WITH CHECK ADD
       CONSTRAINT [FK_Employe_Sickness] FOREIGN KEY([employeeId])
REFERENCES [dbo].[Employee] ([Id])
GO
ALTER TABLE [dbo].[Sickness] CHECK
       CONSTRAINT [FK_Employe_Sickness]

/******* PPE ****/
-- Define the relationship between Ppe and PpeClassification.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_PpeClassification_Ppe]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[Ppe]'))
ALTER TABLE [dbo].Ppe  WITH CHECK ADD
       CONSTRAINT [FK_PpeClassification_Ppe] FOREIGN KEY([ppeClassificationId])
REFERENCES [dbo].[PpeClassification] ([Id])
GO
ALTER TABLE [dbo].[Ppe] CHECK
       CONSTRAINT [FK_PpeClassification_Ppe]

/******* ExistingPpe ****/
-- Define the relationship between ExistingPpe and Ppe.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Ppe_ExistingPpe]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[ExistingPpe]'))
ALTER TABLE [dbo].[ExistingPpe]  WITH CHECK ADD
       CONSTRAINT [FK_Ppe_ExistingPpe] FOREIGN KEY([ppeId])
REFERENCES [dbo].[Ppe] ([Id])
GO
ALTER TABLE [dbo].[ExistingPpe] CHECK
       CONSTRAINT [FK_Ppe_ExistingPpe]

/******* ExistingPpeAssigned ****/
-- Define the relationship between ExistingPpeAssigned and ExistingPpe.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_ExistingPpe_ExistingPpeAssigned]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[ExistingPpeAssigned]'))
ALTER TABLE [dbo].[ExistingPpeAssigned]  WITH CHECK ADD
       CONSTRAINT [FK_ExistingPpe_ExistingPpeAssigned] FOREIGN KEY([existingPpeId])
REFERENCES [dbo].[ExistingPpe] ([Id])
GO
ALTER TABLE [dbo].[ExistingPpeAssigned] CHECK
       CONSTRAINT [FK_ExistingPpe_ExistingPpeAssigned]


-- Define the relationship between ExistingPpeAssigned and Employee.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_Employee_ExistingPpeAssigned]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[ExistingPpeAssigned]'))
ALTER TABLE [dbo].[ExistingPpeAssigned]  WITH CHECK ADD
       CONSTRAINT [FK_Employee_ExistingPpeAssigned] FOREIGN KEY([employeeId])
REFERENCES [dbo].[Employee] ([Id])
GO
ALTER TABLE [dbo].[ExistingPpeAssigned] CHECK
       CONSTRAINT [FK_Employee_ExistingPpeAssigned]


/******* WorkItem ****/
-- Define the relationship between WorkItem and WorkItemClassification.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_WorkItemClassification_WorkItem]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[WorkItem]'))
ALTER TABLE [dbo].[WorkItem]  WITH CHECK ADD
       CONSTRAINT [FK_WorkItemClassification_WorkItem] FOREIGN KEY([workItemClassificationId])
REFERENCES [dbo].[WorkItemClassification] ([Id])
GO
ALTER TABLE [dbo].[WorkItem] CHECK
       CONSTRAINT [FK_WorkItemClassification_WorkItem]

/******* ExistingWorkItem ****/
-- Define the relationship between ExistingWorkItem and  WorkItem.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_WorkItem_ExistingWorkItem]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[ExistingWorkItem]'))
ALTER TABLE [dbo].[ExistingWorkItem]  WITH CHECK ADD
       CONSTRAINT [FK_WorkItem_ExistingWorkItem] FOREIGN KEY([workItemId])
REFERENCES [dbo].[WorkItem] ([Id])
GO
ALTER TABLE [dbo].[ExistingWorkItem] CHECK
       CONSTRAINT [FK_WorkItem_ExistingWorkItem]
