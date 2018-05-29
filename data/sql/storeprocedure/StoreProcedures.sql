

--start miguel
CREATE PROCEDURE dbo.proGetAllWorkItemClassification
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	SELECT *
    FROM dbo.WorkItemClassification;
END



CREATE PROCEDURE dbo.proGetWorkItemClassification
(
    @id INT
)
AS
SET XACT_ABORT ON;
SET NOCOUNT ON;
BEGIN
	 SELECT *
        FROM dbo.WorkItemClassification
        where id = @id;
END
GO

--end miguel



-- start henry

-- end henry


--start marcelo

--end marcelo