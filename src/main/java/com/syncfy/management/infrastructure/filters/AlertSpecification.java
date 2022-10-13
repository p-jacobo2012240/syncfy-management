package com.syncfy.management.infrastructure.filters;

import com.syncfy.management.infrastructure.entities.Alert;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.Predicate;

@Component
public class AlertSpecification {

    public Specification<Alert> toSpec(Long authId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (authId != null)
                predicates.add(cb.equal(root.get("auth"), authId));

            query.distinct(true);
            return cb.and(predicates.toArray(Predicate[]::new));
        };
    }
}