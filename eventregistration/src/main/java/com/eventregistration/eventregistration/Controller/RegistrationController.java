package com.eventregistration.eventregistration.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eventregistration.eventregistration.Model.ParticipantModel;
import com.eventregistration.eventregistration.Repository.ParticipantRepository;

@Controller
public class RegistrationController {

    @Autowired
    private ParticipantRepository participantRepository;

    @GetMapping("/")
    public String showRegistrationForm(Model model) {
        model.addAttribute("participant", new ParticipantModel());
        return "registrationForm";
    }

    @PostMapping("/register")
    public String registerParticipant(@ModelAttribute ParticipantModel participant) {
        participant.generatePassword();
        participantRepository.save(participant);
        return "redirect:/welcome?id=" + participant.getId();
    }

    @GetMapping("/welcome")
    public String showWelcomeScreen(@RequestParam int id, Model model) {
        ParticipantModel participant = participantRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid participant ID"));

        model.addAttribute("participant", participant);
        return "welcomeScreen";
    }

    @GetMapping("/allParticipants")
    public String showAllParticipants(Model model) {
        List<ParticipantModel> participants = participantRepository.findAll();
        model.addAttribute("participants", participants);
        return "allParticipantsScreen";
    }
}

