package hellojpa;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;

@Embeddable
public class Period {
    //기간
    private LocalDateTime stratDate;
    private LocalDateTime endDate;

    public LocalDateTime getStratDate() {
        return stratDate;
    }

    public void setStratDate(LocalDateTime stratDate) {
        this.stratDate = stratDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
