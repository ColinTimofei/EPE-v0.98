package com.example.EPE.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "evaluation_field")
public class EvaluationField extends BaseEntity {

    @Column(name = "title", nullable = false)
    private String title;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "evaluation_group_id")
    private EvaluationGroup evaluationGroup;

    @Column(name = "first_phase_score")
    private Integer firstPhaseScore;

    @Column(name = "second_phase_score")
    private Integer secondPhaseScore;

    @Column(name = "overall_score")
    private Float overallScore;

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public EvaluationField() {
    }

    public EvaluationField(String title, EvaluationGroup evaluationGroup, Integer firstPhaseScore,
                           Integer secondPhaseScore, Float overallScore) {
        this.title = title;
        this.evaluationGroup = evaluationGroup;
        this.firstPhaseScore = firstPhaseScore;
        this.secondPhaseScore = secondPhaseScore;
        this.overallScore = overallScore;
    }
}
