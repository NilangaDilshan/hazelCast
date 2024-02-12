package com.dilshan.hazelCast.controllers;

import com.dilshan.hazelCast.configurations.HazelCastConfig;
import com.dilshan.hazelCast.entities.Division;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/division")
public class DivisionController {
    private final HazelCastConfig hazelCastConfig;

    @PostMapping(path = "/{number}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Division> put(@RequestBody Division division, @PathVariable String number) {
        return new ResponseEntity<>(
                this.hazelCastConfig.put(number, division),
                HttpStatus.OK);
    }

    @GetMapping(path = "/{number}")
    public ResponseEntity<Division> get(@PathVariable String number) {
        return new ResponseEntity<Division>(this.hazelCastConfig.get(number), HttpStatus.OK);
    }

}
