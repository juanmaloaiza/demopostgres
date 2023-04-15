package com.example.demo.service;


import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.DataAssociateException;
import com.example.demo.exception.DataDuplicateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.dtos.YardDto;

import java.io.File;
import java.util.List;
import java.util.Optional;

public interface YardService {

    List<YardDto> getAllYard();

    Optional<YardDto> findByYardId (Long yardId);

    Optional<YardDto> addYard (YardDto yardDto) throws BadRequestException;

    Optional <YardDto> updateYard (Long yardId, YardDto dto) throws NotFoundException;

    void deleteYard (Long yardId) throws NotFoundException, DataAssociateException;

}
