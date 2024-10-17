package com.jobfinder.jobfinder.integration;

public interface EntityMapper<E, D, L> {
    public <E> E apply(D entity, L id);
}
