package se331.lab.controller;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.lab.repository.ParticipantRepository;
import se331.lab.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantRepository participantRepository;

    @GetMapping("/participants")
    @Transactional
    public ResponseEntity<?> getParticipants() {
        return ResponseEntity.ok(
                LabMapper.INSTANCE.getParticipantWithEventsDTO(participantRepository.findAll()));
    }
}
