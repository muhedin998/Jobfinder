package com.jobfinder.jobfinder.integration;

public interface DTOMapper<D, E> {
    public <D> D apply(E dto);
}
