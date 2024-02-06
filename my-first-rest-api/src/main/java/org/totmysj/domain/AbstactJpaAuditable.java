package org.totmysj.domain;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.Auditable;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.security.PrivilegedAction;
import java.time.Instant;
import java.util.Optional;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)

public class AbstactJpaAuditable<PK extends Serializable> extends AbstractPersistable<PK>
    implements Auditable<String, PK, Instant>
{
    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private Instant createdDate;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private Instant lastModifiedDate;

    @Override
    public Optional<String> getCreatedBy()
    {
        return Optional.ofNullable(createdBy);
    }

    @Override
    public void setCreatedBy(String createdBy)
    {
        this.createdBy = createdBy;
    }

    @Override
    public Optional<Instant> getCreatedDate()
    {
        return Optional.ofNullable(createdDate);
    }

    @Override
    public void setCreatedDate(Instant createdDate)
    {
        this.createdDate = createdDate;
    }

    @Override
    public Optional<String> getLastModifiedBy()
    {
        return Optional.ofNullable(lastModifiedBy);
    }

    @Override
    public void setLastModifiedBy(String lastModifiedBy)
    {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Override
    public Optional<Instant> getLastModifiedDate()
    {
        return Optional.ofNullable(lastModifiedDate);
    }

    @Override
    public void setLastModifiedDate(Instant lastModifiedDate)
    {
        this.lastModifiedDate = lastModifiedDate;
    }
}