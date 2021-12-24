/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.sie.charity_network.controllers;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.sie.charity_network.POJOs.Report;
import org.sie.charity_network.POJOs.User;
import org.sie.charity_network.services.UserService;
import org.sie.charity_network.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author sie
 */
@Controller
public class ReportController {
    @Autowired
    private Environment environment;
    @Autowired
    private UserService userService;
    @Autowired
    private ReportService reportService;
    
    @GetMapping("/user/report/")
    public String renderReportCreation(@RequestParam Map params, Model model){
        String keyword = (String) params.getOrDefault("keyword", "");
        String reportedId = (String) params.getOrDefault("reportedId", "");
        if (!reportedId.isBlank())
        {
            model.addAttribute("reportedId", reportedId);
            model.addAttribute("report", new Report());
        }
        model.addAttribute("userList", userService.getUsersByKeyword(keyword));
        return "reportCreation";
    }
    
    @PostMapping("/user/report/")
    public String submitReport(@ModelAttribute("report") Report report, HttpSession httpSession, Model model){
        report.setReporter((User) httpSession.getAttribute("currentUser"));
        if(reportService.addReport(report) && userService.updateUser(report.getReported().getId(), true)) {
            return String.format("redirect:%s", environment.getProperty("url.dashboard"));
        }
        model.addAttribute("errors", "Something wrong. Can't create report.");
        return "postCreation";
    }
}
