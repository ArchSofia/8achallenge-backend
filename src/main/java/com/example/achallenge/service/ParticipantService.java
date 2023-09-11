package com.example.achallenge.service;

import com.example.achallenge.model.Participant;
import com.example.achallenge.repository.ParticipantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ParticipantService {


    private ParticipantRepository participantRepository;

    public void agregar(Participant Participant){participantRepository.save(Participant);}
    public List<Participant> listar(){return participantRepository.findAll();}

    public Participant modificar(Participant Participant){return participantRepository.save(Participant);}

    public void eliminar(long id){participantRepository.deleteById(id);}

    public Optional<Participant> getById(long id){return participantRepository.findById(id);}


}
