package cals.quintet.crm.business.domain.entity.crm;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

/**
 * @author sycha
 * @since 1.0
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)

@Table(name = "PNT_PLCY")
@Entity
public class PointPolicy {
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스 자동증가 열을 사용하여 증감하도록
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "CREATE_DATE")
    private LocalDateTime createDate;

    @Column(name = "PNT_CNCL_VLD_DAY")
    private int pntCnclVldDay;


}
