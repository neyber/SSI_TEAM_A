/******************************************************************************
**  Name: schema team A
**  Desc: add sentences to create tables for all tables for our system
**
**  Author: Henry Bustamante
**
**  Date: 05/24/2018
*******************************************************************************/

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

/******* WorkItem ****/
-- Define the relationship between WorkItem and WorkItemClassification.
IF NOT EXISTS (SELECT * FROM sys.foreign_keys
       WHERE object_id = OBJECT_ID(N'[dbo].[FK_WorkItemClassification_WorkItem]')
       AND parent_object_id = OBJECT_ID(N'[dbo].[WorkItem]'))
ALTER TABLE [dbo].[WorkItem]  WITH CHECK ADD
       CONSTRAINT [FK_WorkItemClassification_WorkItem] FOREIGN KEY([workItemClassificationId])
REFERENCES [dbo].[ExistingPpeAssigned] ([Id])
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
