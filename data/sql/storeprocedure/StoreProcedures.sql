

--start miguel
USE ssiA;


-- Create proGetWorkItemClassification stored procedure.
IF EXISTS (SELECT * FROM sys.objects
           WHERE object_id = OBJECT_ID(N'[dbo].[proGetWorkItemClassification]')
           AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proGetWorkItemClassification;
END
GO
/******************************************************************************
**  Name: proGetWorkItemClassification
**  Desc: Get an WorkItem Classification
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proGetWorkItemClassification
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT id
		  ,name
		  ,description
    FROM dbo.WorkItemClassification
	WHERE id = @id;

	PRINT 'Executed proGetWorkItemClassification..';
END
GO

PRINT 'Procedure dbo.proGetWorkItemClassification created';
GO


-- Create proGetAllWorkItemClassification stored procedure.
IF EXISTS (SELECT * FROM sys.objects
           WHERE object_id = OBJECT_ID(N'[dbo].[proGetAllWorkItemClassification]')
           AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proGetAllWorkItemClassification;
END
GO
/******************************************************************************
**  Name: proGetAllWorkItemClassification
**  Desc: Get all WorkItem Classifications
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proGetAllWorkItemClassification
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT id
		  ,name
		  ,description
    FROM dbo.WorkItemClassification;

	PRINT 'Executed proGetAllWorkItemClassification..';
END
GO

PRINT 'Procedure dbo.proGetAllWorkItemClassification created';
GO



-- Create proInsertWorkItemClassification stored procedure.
IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[proInsertWorkItemClassification]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proInsertWorkItemClassification
END
GO
/******************************************************************************
**  Name: proInsertWorkItemClassification
**  Desc: Inserts an WorkItem Classification
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proInsertWorkItemClassification
(
	  @name VARCHAR(100)
	 ,@description VARCHAR(200)
	 ,@createdBy INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	INSERT INTO dbo.WorkItemClassification (
										name
										,description
										,createdBy
										)
	VALUES (
			 @name
			,@description
			,@createdBy
			);

	PRINT 'Executed proInsertWorkItemClassification..';
END
GO

PRINT 'Procedure dbo.proInsertWorkItemClassification created';
GO


--Create the proUpdateWorkItemClassification stored procedure.
IF EXISTS (SELECT * FROM sys.objects
		   WHERE object_id = OBJECT_ID(N'[dbo].[proUpdateWorkItemClassification]')
		   AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proUpdateWorkItemClassification;
END
GO
/******************************************************************************
**  Name: proUpdateWorkItemClassification
**  Desc: Update an WorkItem Classification
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proUpdateWorkItemClassification
(
	  @id INT
	 ,@name VARCHAR(100)
	 ,@description VARCHAR(200)
	 ,@updatedBy INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	UPDATE WorkItemClassification
	SET  name		 = @name
		,description = @description
		,updatedBy	 = @updatedBy
	WHERE id = @id;

	PRINT 'Executed proUpdateWorkItemClassification..';
END
GO

PRINT 'Procedure dbo.proUpdateWorkItemClassification created';
GO



-- Create the proDeleteWorkItemClassification stored procedure.
IF EXISTS (SELECT * FROM sys.objects
	   	   WHERE object_id = OBJECT_ID(N'[dbo].[proDeleteWorkItemClassification]')
		   AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proDeleteWorkItemClassification;
END
GO
/******************************************************************************
**  Name: proDeleteWorkItemClassification
**  Desc: Delete an WorkItem Classification
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proDeleteWorkItemClassification
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	DELETE FROM WorkItemClassification
	WHERE id = @id;

	PRINT 'Executed proDeleteWorkItemClassification..';
END
GO

PRINT 'Procedure dbo.proDeleteWorkItemClassification created';
GO



-- Create proGetWorkItem stored procedure.
IF EXISTS (SELECT * FROM sys.objects
           WHERE object_id = OBJECT_ID(N'[dbo].[proGetWorkItem]')
           AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proGetWorkItem;
END
GO
/******************************************************************************
**  Name: proGetWorkItem
**  Desc: Get an WorkItem
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proGetWorkItem
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT id
		  ,name
		  ,description
		  ,workItemClassificationId
    FROM dbo.WorkItem
	WHERE id = @id;

	PRINT 'Executed proGetWorkItem..';
END
GO

PRINT 'Procedure dbo.proGetWorkItem created';
GO


-- Create proGetAllWorkItem stored procedure.
IF EXISTS (SELECT * FROM sys.objects
           WHERE object_id = OBJECT_ID(N'[dbo].[proGetAllWorkItem]')
           AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proGetAllWorkItem;
END
GO
/******************************************************************************
**  Name: proGetAllWorkItem
**  Desc: Get all WorkItems
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proGetAllWorkItem
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT id
		  ,name
		  ,description
		  ,workItemClassificationId
    FROM dbo.WorkItem;

	PRINT 'Executed proGetAllWorkItem..';
END
GO

PRINT 'Procedure dbo.proGetAllWorkItem created';
GO



-- Create proInsertWorkItem stored procedure.
IF EXISTS (SELECT * FROM sys.objects
		WHERE object_id = OBJECT_ID(N'[dbo].[proInsertWorkItem]')
		AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proInsertWorkItem
END
GO
/******************************************************************************
**  Name: proInsertWorkItem
**  Desc: Inserts an WorkItem
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proInsertWorkItem
(
	  @name VARCHAR(100)
	 ,@description VARCHAR(200)
	 ,@workItemClassificationId INT
	 ,@createdBy INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	INSERT INTO dbo.WorkItem(
							 name
							,description
							,workItemClassificationId
							,createdBy
							)
	VALUES (
			 @name
			,@description
			,@workItemClassificationId
			,@createdBy
			);

	PRINT 'Executed proInsertWorkItem..';
END
GO

PRINT 'Procedure dbo.proInsertWorkItem created';
GO


--Create the proUpdateWorkItem stored procedure.
IF EXISTS (SELECT * FROM sys.objects
		   WHERE object_id = OBJECT_ID(N'[dbo].[proUpdateWorkItem]')
		   AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proUpdateWorkItem;
END
GO
/******************************************************************************
**  Name: proUpdateWorkItem
**  Desc: Update an WorkItem
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proUpdateWorkItem
(
	  @id INT
	 ,@name VARCHAR(100)
	 ,@description VARCHAR(200)
	 ,@workItemClassificationId INT
	 ,@updatedBy INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	UPDATE WorkItem
	SET  name		 = @name
		,description = @description
		,workItemClassificationId = @workItemClassificationId
		,updatedBy = @updatedBy
	WHERE id = @id;

	PRINT 'Executed proUpdateWorkItem..';
END
GO

PRINT 'Procedure dbo.proUpdateWorkItem created';
GO



-- Create the proDeleteWorkItem stored procedure.
IF EXISTS (SELECT * FROM sys.objects
	   	   WHERE object_id = OBJECT_ID(N'[dbo].[proDeleteWorkItem]')
		   AND type in (N'P', N'PC'))
BEGIN
	DROP PROCEDURE dbo.proDeleteWorkItem;
END
GO
/******************************************************************************
**  Name: proDeleteWorkItem
**  Desc: Delete an WorkItem
**
**  Called by: SSI
**
**  Author: Miguel Rojas
**
**  Date: 29/05/2018
*******************************************************************************
**                            Change History
*******************************************************************************
**   Date:       Author:                        Description:
** --------     --------       ------------------------------------------------
** 29/05/2018  Miguel Rojas   Initial version
*******************************************************************************/
CREATE PROCEDURE dbo.proDeleteWorkItem
(
	@id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	DELETE FROM WorkItem
	WHERE id = @id;

	PRINT 'Executed proDeleteWorkItem..';
END
GO

PRINT 'Procedure dbo.proDeleteWorkItem created';
GO

--end miguel



-- start henry

-- end henry


--start marcelo

--end marcelo