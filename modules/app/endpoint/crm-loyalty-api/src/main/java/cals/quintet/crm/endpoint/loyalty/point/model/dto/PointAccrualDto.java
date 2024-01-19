package cals.quintet.crm.endpoint.loyalty.point.model.dto;

import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Getter;
import org.apache.coyote.Request;

import java.time.LocalDateTime;

/**
 * @author sycha
 * @since 1.0
 */

public class PointAccrualDto {

    @Valid
    @Getter
    public static class Request {
        private int pointAmount;
        private LocalDateTime accrualDate;
    }
    @Getter
    @Builder
    public static class Response {
        private boolean isSuccess;
    }
}
