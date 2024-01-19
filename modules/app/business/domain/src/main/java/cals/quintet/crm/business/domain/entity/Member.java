package cals.quintet.crm.business.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sycha
 * @since 1.0
 */
@Setter
@Getter
@Entity
@Table(name="MBR")
public class Member {

    @Id
    private Long id;

    private String name;

}