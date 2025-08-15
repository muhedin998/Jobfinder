package com.jobfinder.jobfinder.integration;

public interface EntityMapper<D, E, L> {
    D apply(E entity, L id);
}
