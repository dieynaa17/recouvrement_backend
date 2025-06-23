package com.sonatel.recouvrement.controller;

import com.sonatel.recouvrement.model.Segment;
import com.sonatel.recouvrement.service.SegmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/segments")
@CrossOrigin(origins = "*")
public class SegmentController {

    private final SegmentService segmentService;

    public SegmentController(SegmentService segmentService) {
        this.segmentService = segmentService;
    }

    @PostMapping
    public ResponseEntity<Segment> create(@RequestBody Segment segment) {
        return ResponseEntity.ok(segmentService.createSegment(segment));
    }

    @GetMapping
    public ResponseEntity<List<Segment>> getAll() {
        return ResponseEntity.ok(segmentService.getAllSegments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Segment> getById(@PathVariable Long id) {
        return ResponseEntity.ok(segmentService.getSegmentById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Segment> update(@PathVariable Long id, @RequestBody Segment segment) {
        return ResponseEntity.ok(segmentService.updateSegment(id, segment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        segmentService.deleteSegment(id);
        return ResponseEntity.noContent().build();
    }
}

