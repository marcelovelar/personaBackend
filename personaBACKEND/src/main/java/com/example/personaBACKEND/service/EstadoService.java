package com.example.personaBACKEND.service;

import com.example.personaBACKEND.model.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import com.example.personaBACKEND.repository.EstadoRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class EstadoService implements EstadoRepository{
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> findAllByCountry(Long id){
        List<Estado> estadosRespuesta = new ArrayList<>();
        List<Estado> estados= estadoRepository.findAll();
        for (int i=0; i<estados.size(); i++) {
            if (estados.get(i).getPais().getId()==id) {
                estadosRespuesta.add(estados.get(i));
            }
        }
        return estadosRespuesta;
    }

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }

    @Override
    public List<Estado> findAll(Sort sort) {
        return estadoRepository.findAll(sort);
    }

    @Override
    public Page<Estado> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Estado> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Estado entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Estado> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Estado> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Estado> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Estado> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Estado> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Estado> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Estado> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Estado getOne(Long aLong) {
        return null;
    }

    @Override
    public Estado getById(Long aLong) {
        return null;
    }

    @Override
    public Estado getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Estado> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Estado> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Estado> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Estado> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Estado> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Estado> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Estado, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
