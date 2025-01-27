package com.gmail.seminyden.controller;

import com.gmail.seminyden.service.ResourceService;
import jakarta.annotation.Resource;
import org.apache.tika.exception.TikaException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/resources")
public class ResourceController {

    @Resource
    private ResourceService resourceService;

    @PostMapping(consumes = "audio/mpeg")
    public ResponseEntity<?> createResource(@RequestBody byte[] resource) throws IOException {
        try(InputStream inputStream = new ByteArrayInputStream(resource)) {

            return ResponseEntity.ok("ok");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getResource(@PathVariable("id") Integer id) {
        return null;
    }

    @DeleteMapping
    public ResponseEntity<?> deleteResources(@RequestParam("id") String ids) {
        return null;
    }
}