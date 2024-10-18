package com.syncfy.management.infrastructure.filters;

import com.syncfy.management.domain.AuthDtoPayloadDomain;
import com.syncfy.management.infrastructure.entities.Alert;
import com.syncfy.management.infrastructure.entities.Auth;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class AuthSpecification {

    public Specification<Auth> toSpec(AuthDtoPayloadDomain payloadDomain) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            /** if (payloadDomain.getEmail() != null)
                predicates.add(cb.equal(root.get("email"), payloadDomain.getEmail()));*/

            query.distinct(true);
            return cb.and(predicates.toArray(Predicate[]::new));
        };
    }
}
