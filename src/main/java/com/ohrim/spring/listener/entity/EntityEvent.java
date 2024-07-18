package com.ohrim.spring.listener.entity;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;
@Getter
public class EntityEvent  extends ApplicationEvent {
    public final AccessType accessType;

    public EntityEvent(Object entity, AccessType accessType) {
        super(entity);
        this.accessType = accessType;
    }
}
