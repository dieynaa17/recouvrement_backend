package com.sonatel.recouvrement.service.impl;

import com.sonatel.recouvrement.exception.ResourceNotFoundException;
import com.sonatel.recouvrement.model.Segment;
import com.sonatel.recouvrement.repository.SegmentRepository;
import com.sonatel.recouvrement.service.SegmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SegmentServiceImpl implements SegmentService {

    private final SegmentRepository segmentRepository;

    public SegmentServiceImpl(SegmentRepository segmentRepository) {
        this.segmentRepository = segmentRepository;
    }

    @Override
    public Segment createSegment(Segment segment) {
        return segmentRepository.save(segment);
    }

    @Override
    public List<Segment> getAllSegments() {
        return segmentRepository.findAll();
    }

    @Override
    public Segment getSegmentById(Long id) {
        return segmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Segment introuvable avec l'id: " + id));
    }

    @Override
    public Segment updateSegment(Long id, Segment segment) {
        Segment existing = getSegmentById(id);
        existing.setLibelle(segment.getLibelle());
        return segmentRepository.save(existing);
    }

    @Override
    public void deleteSegment(Long id) {
        segmentRepository.deleteById(id);
    }
}

