package com.nehaa.habittracker.service;

import com.nehaa.habittracker.dto.WellnessLogRequest;
import com.nehaa.habittracker.dto.WellnessLogResponse;
import com.nehaa.habittracker.model.WellnessLog;
import com.nehaa.habittracker.repository.WellnessLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class WellnessService {

    private final WellnessLogRepository wellnessLogRepository;

    // ✅ Constructor injection
    public WellnessService(WellnessLogRepository wellnessLogRepository) {
        this.wellnessLogRepository = wellnessLogRepository;
    }

    public WellnessLogResponse logWellness(WellnessLogRequest request) {
        WellnessLog log = new WellnessLog();
        log.setDate(request.getDate());
        log.setMood(request.getMood());
        log.setNotes(request.getNotes());

        WellnessLog saved = wellnessLogRepository.save(log);

        return new WellnessLogResponse(
                saved.getId(),
                saved.getDate(),
                saved.getMood(),
                saved.getNotes()
        );
    }

    public List<WellnessLogResponse> getRecentWellnessLogs(int days) {
        LocalDate end = LocalDate.now();
        LocalDate start = end.minusDays(days);

        List<WellnessLog> logs = wellnessLogRepository.findByDateBetween(start, end);
        List<WellnessLogResponse> responses = new ArrayList<>();

        for (WellnessLog log : logs) {
            responses.add(new WellnessLogResponse(
                    log.getId(),
                    log.getDate(),
                    log.getMood(),
                    log.getNotes()
            ));
        }

        return responses;
    }
}
