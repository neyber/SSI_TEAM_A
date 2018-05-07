package com.groupa.ssi.services.report;


import com.groupa.ssi.exception.DomainEntityNotFoundException;
import com.groupa.ssi.model.domain.report.Report;
import com.groupa.ssi.model.repository.report.ReportRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Linet Torrico
 */

@Service
public class ReportService {

    private ReportRepository repository;

    public ReportService(ReportRepository repository) {
        this.repository = repository;
    }

    public List<Report> findAll() {
        List<Report> results = new ArrayList<>();
        repository.findAll().forEach(results::add);
        return results;
    }

    public Report findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> {
            return new DomainEntityNotFoundException(Report.class);
        });
    }

    public Report save(Report report) {
        return repository.save(report);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

}
