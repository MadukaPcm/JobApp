package tz.maduka.FirstJobApp.job.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tz.maduka.FirstJobApp.company.model.Company;

@Setter
@Getter
@Entity
//@Table(name = "job")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String minSalary;
    private String maxSalary;
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = true)
    private Company company;

    /*
    @NoArgsConstructor
    This is needed by JPA to initialize instance of an object when retrieving data
    It is recommended then after you can have more other constructors after this.
    */
    public Job(){

    }
    public Job(Long id, String title, String description, String minSalary, String maxSalary, String location) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", minSalary='" + minSalary + '\'' +
                ", maxSalary='" + maxSalary + '\'' +
                ", location='" + location + '\'' +
                ", company=" + company +
                '}';
    }
}
