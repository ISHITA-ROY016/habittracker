package com.nehaa.habittracker.controller;

import com.nehaa.habittracker.dto.WellnessLogRequest;
import com.nehaa.habittracker.dto.WellnessLogResponse;
import com.nehaa.habittracker.service.WellnessService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wellness")
public class WellnessController {

    @Autowired
    private WellnessService wellnessService;

    // Log new wellness entry
    @PostMapping
    public WellnessLogResponse logWellness(@RequestBody @Valid WellnessLogRequest request) {
        return wellnessService.logWellness(request);
    }

    // Get past X days wellness logs
    @GetMapping
    public List<WellnessLogResponse> getRecentLogs(@RequestParam(defaultValue = "7") int days) {
        return wellnessService.getRecentWellnessLogs(days);
    }
}
