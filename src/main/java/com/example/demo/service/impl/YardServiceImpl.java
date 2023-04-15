package com.example.demo.service.impl;



import com.example.demo.domain.Yard;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.DataAssociateException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.repository.CustomerYardRepository;
import com.example.demo.repository.YardRepository;
import com.example.demo.service.YardService;
import com.example.demo.service.dtos.YardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

import java.util.stream.Collectors;

@Service
public class YardServiceImpl implements YardService {

    private YardRepository yardRepository;
    private CustomerYardRepository customerYardRepository;

    @Autowired
    public YardServiceImpl(YardRepository yardRepository, CustomerYardRepository customerYardRepository) {
        this.yardRepository = yardRepository;
        this.customerYardRepository = customerYardRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<YardDto> getAllYard() {
        return yardRepository.findAll()
                .stream()
                .map(yard -> new YardDto(yard))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<YardDto> findByYardId(Long yardId) {
        return yardRepository.findById(yardId).map(YardDto::new);
    }

    @Override
    @Transactional
    public Optional<YardDto> addYard(YardDto yardDto) throws BadRequestException {
        Yard savedYard= yardRepository.save(yardDto.toYard());
        return Optional.ofNullable(savedYard).map(YardDto::new);
    }

    @Override
    @Transactional
    public Optional<YardDto> updateYard(Long yardId, YardDto dto) throws NotFoundException {
        Optional <Yard> yardFind = yardRepository.findById(yardId);
        return yardFind
                .map(
                        y -> { y = dto.toYard();
                            return yardRepository.save(y);})
                .map(YardDto::new);
    }

    @Override
    @Transactional
    public void deleteYard(Long yardId) throws NotFoundException, DataAssociateException {

        if (!yardRepository.existsById(yardId))
            throw new NotFoundException();

        //Buscar en la entidad YardCustomer para verificar relaciones
        if(customerYardRepository.existsById(yardId))
            throw new DataAssociateException("Patio con información asociada");

        yardRepository.deleteById(yardId);
    }

}
