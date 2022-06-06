package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.donor.DonorDTO;
import com.sptech.apikraken.entity.Donation;
import com.sptech.apikraken.service.ExportService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/export")
public class ExportController {

    @Autowired ExportService exportService;

    @ApiResponses(
            { @ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.ALL_VALUE)) }
    )
    @PostMapping
    public ResponseEntity exportArquivo(@RequestBody List<Donation> donations){
        try {

            exportService.exportTXT(donations);

            return ResponseEntity.status(201)
                    .header("content-type", "text/plain")
                    .header("content-disposition", "filename=\"relatorio-de-doacoes.txt\"")
                    .body(exportService.lerArquivo());

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

}
