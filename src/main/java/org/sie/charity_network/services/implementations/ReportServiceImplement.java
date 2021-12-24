/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.services.implementations;

import java.util.Date;
import org.sie.charity_network.POJOs.Report;
import org.sie.charity_network.repositories.ReportRepository;
import org.sie.charity_network.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sie
 */
@Service
public class ReportServiceImplement implements ReportService{
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public boolean addReport(Report report) {
        report.setCreatedDate(new Date());
        return reportRepository.addReport(report);
    }
    
    
}
