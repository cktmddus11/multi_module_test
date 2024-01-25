package cals.quintet.crm.business.domain.entity.loycore;

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

@Table(name = "PNT_TXN" , catalog = "#TENANT#_loycore")
@Entity
public class PointTransaction {

    @GeneratedValue(strategy = GenerationType.IDENTITY) // 데이터베이스 자동증가 열을 사용하여 증감하도록
    @Id
    @Column(name="ID")
    private Long id;

    @Column(name = "TXN_DT")
    private LocalDateTime txnDt;


    @Column(name = "ACRL_AMT")
    private int acrlAmt;
}
