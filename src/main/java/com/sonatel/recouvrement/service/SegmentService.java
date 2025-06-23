package com.sonatel.recouvrement.service;

import com.sonatel.recouvrement.model.Segment;

import java.util.List;

public interface SegmentService {
    Segment createSegment(Segment segment);
    List<Segment> getAllSegments();
    Segment getSegmentById(Long id);
    Segment updateSegment(Long id, Segment segment);
    void deleteSegment(Long id);
}
