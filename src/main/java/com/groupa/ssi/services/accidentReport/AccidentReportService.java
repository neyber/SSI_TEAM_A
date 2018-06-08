package com.groupa.ssi.services.accidentReport;

import com.groupa.ssi.modeldw.domain.accident.AccidentReport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AccidentReportService {
    @Value("${ssi.datawarehouse.datasource.jdbcUrl}")
    private String url;

    @Value("${ssi.datawarehouse.datasource.username}")
    private String userName;


    @Value("${ssi.datawarehouse.datasource.password}")
    private String password;

    public List<AccidentReport> findAll(Date startDate, Date endDate) throws SQLException, ClassNotFoundException {
        List<AccidentReport> results = new ArrayList<AccidentReport>();

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, userName, password);

        String SPsql = "EXEC proGetAccidentsReport ?,?";
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");

        PreparedStatement ps = conn.prepareStatement(SPsql);
        ps.setEscapeProcessing(true);
        ps.setQueryTimeout(60000);
        ps.setString(1, df.format(startDate));
        ps.setString(2, df.format(endDate));
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            AccidentReport accidentReport = new AccidentReport();
            accidentReport.setFullName(rs.getString("fullName"));
            accidentReport.setGender(rs.getString("gender"));
            accidentReport.setRole(rs.getString("role"));
            accidentReport.setYear(rs.getInt("year"));
            accidentReport.setMonth(rs.getString("month"));
            accidentReport.setDay(rs.getInt("day"));
            accidentReport.setQuantity(rs.getInt("quantity"));

            results.add(accidentReport);
        }

        return results;
    }

}
