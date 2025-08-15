package com.jobfinder.jobfinder.integration;

public interface DTOMapper<E, D> {
    E apply(D dto);
}
