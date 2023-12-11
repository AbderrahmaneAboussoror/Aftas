package com.AboussororAbderrahmane.aftas.services;

import com.AboussororAbderrahmane.aftas.exceptions.NotFoundException;

import java.util.List;

public interface IData<T, R, ID> {
    T save(R bean);
    T update(ID id, R bean) throws NotFoundException;
    boolean delete(ID id) throws NotFoundException;
    T findById(ID id) throws NotFoundException;
    List<T> findAll();
}
