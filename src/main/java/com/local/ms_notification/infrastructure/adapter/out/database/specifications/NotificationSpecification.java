package com.local.ms_notification.infrastructure.adapter.out.database.specifications;

import com.local.ms_notification.domain.model.Notification;
import com.local.ms_notification.infrastructure.adapter.out.database.entities.NotificationEntity;
import jakarta.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class NotificationSpecification {

    private NotificationSpecification() {

    }

    public static Specification<NotificationEntity> filterByEntity(Notification filter) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (filter.getRecipient() != null) {
                predicates.add(builder.equal(root.get("recipient"), filter.getRecipient()));
            }

            if (filter.getType() != null) {
                predicates.add(builder.equal(root.get("type"), filter.getType()));
            }


            if (filter.getSentAt() != null) {
                predicates.add(builder.greaterThanOrEqualTo(root.get("sentAt"), filter.getSentAt()));
            }

            if (filter.getStatus() != null) {
                predicates.add(builder.equal(root.get("status"), filter.getStatus()));
            }

            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
