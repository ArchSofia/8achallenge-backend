package com.example.achallenge.controller;

import com.example.achallenge.model.Participant;
import com.example.achallenge.service.ParticipantService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @CrossOrigin
    @AllArgsConstructor
    @RequestMapping("/participants")
    public class ParticipantController {

        private final ParticipantService service;

        @GetMapping("/list")
        public ResponseEntity<List<Participant>> listar() {
            return ResponseEntity.ok(service.listar());
        }


        @PostMapping("/add")
        public ResponseEntity<Participant> agregar(@RequestBody Participant Participant) {
            try {
                service.agregar(Participant);
                return new ResponseEntity<>(Participant, HttpStatus.CREATED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping("/update")
        public ResponseEntity<Participant> modificar(@RequestBody Participant Participant) {
            return ResponseEntity.ok(service.modificar(Participant));
        }

        @DeleteMapping("/delete/{id}")

        public ResponseEntity<?> eliminarParticipant(@PathVariable int id) {
            ResponseEntity response = null;
            if (service.getById(id) == null) {
                response = new ResponseEntity(HttpStatus.NOT_FOUND);
            } else {
                service.eliminar(id);
                response = new ResponseEntity(HttpStatus.OK);
            }
            return response;
        }
    }



